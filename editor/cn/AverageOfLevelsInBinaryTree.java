//给定一个非空二叉树的根节点
// root , 以数组的形式返回每一层节点的平均值。与实际答案相差 10⁻⁵ 以内的答案可以被接受。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[3.00000,14.50000,11.00000]
//解释：第 0 层的平均值为 3,第 1 层的平均值为 14.5,第 2 层的平均值为 11 。
//因此返回 [3, 14.5, 11] 。
// 
//
// 示例 2: 
//
// 
//
// 
//输入：root = [3,9,20,15,7]
//输出：[3.00000,14.50000,11.00000]
// 
//
// 
//
// 提示： 
//
// 
// 
//
// 
// 树中节点数量在 [1, 10⁴] 范围内 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 476 👎 0


package cn;

import entity.TreeNode;

import java.text.DecimalFormat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBinaryTree {
    public static void main(String[] args) {
        Solution solution = new AverageOfLevelsInBinaryTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {

        //层次遍历
        public List<Double> averageOfLevels(TreeNode root) {
            List<TreeNode> nodeList = new ArrayList<>();
            List<Double> resultList = new ArrayList<>();
            nodeList.add(root);

            while (!nodeList.isEmpty()) {
                double sum = 0;
                double avg;
                List<TreeNode> nextLevel = new ArrayList<>();

                for (TreeNode node : nodeList) {
                    sum = sum + node.val;
                    if (node.left != null) {
                        nextLevel.add(node.left);
                    }
                    if (node.right != null) {
                        nextLevel.add(node.right);
                    }
                }
                avg = sum / nodeList.size();
                resultList.add(avg);

                nodeList.clear();
                nodeList.addAll(nextLevel);
            }
            return resultList;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}