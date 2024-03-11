//给你一个二叉树的根节点 root ， 检查它是否轴对称。
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,2,3,4,4,3]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,2,2,null,3,null,3]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 1000] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你可以运用递归和迭代两种方法解决这个问题吗？ 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 2662 👎 0


package cn;

import java.util.ArrayList;
import java.util.List;

public class SymmetricTree {
    public static void main(String[] args) {
        Solution solution = new SymmetricTree().new Solution();
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
        public boolean isSymmetric(TreeNode root) {

            List<TreeNode> leftTree = new ArrayList<>();
            List<TreeNode> rightTree = new ArrayList<>();
            if (root.left != null) {
                createLeftTree(root.left, leftTree);
            }
            if (root.right != null) {
                createRightTree(root.right, rightTree);
            }

            if (leftTree.size() != rightTree.size()) {
                return false;
            }
            for (int i = 0; i < leftTree.size(); i++) {
                if (leftTree.get(i) == null && rightTree.get(i) == null) {
                    continue;
                }
                if (leftTree.get(i) == null || rightTree.get(i) == null) {
                    return false;
                }
                if (leftTree.get(i).val != rightTree.get(i).val) {
                    return false;
                }
            }
            return true;
        }

        private void createLeftTree(TreeNode root, List<TreeNode> list) {
            list.add(root);
            if (root.left != null) {
                createLeftTree(root.left, list);
            } else {
                list.add(null);
            }
            if (root.right != null) {
                createLeftTree(root.right, list);
            } else {
                list.add(null);
            }
        }

        private void createRightTree(TreeNode root, List<TreeNode> list) {
            list.add(root);
            if (root.right != null) {
                createRightTree(root.right, list);
            } else {
                list.add(null);
            }
            if (root.left != null) {
                createRightTree(root.left, list);
            } else {
                list.add(null);
            }
        }

        public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode() {
            }

            TreeNode(int val) {
                this.val = val;
            }

            TreeNode(int val, TreeNode left, TreeNode right) {
                this.val = val;
                this.left = left;
                this.right = right;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}