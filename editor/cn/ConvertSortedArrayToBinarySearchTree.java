//给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
//
// 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。 
//
// 
//
// 示例 1： 
// 
// 
//输入：nums = [-10,-3,0,5,9]
//输出：[0,-3,9,-10,null,5]
//解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
//
// 
//
// 示例 2： 
// 
// 
//输入：nums = [1,3]
//输出：[3,1]
//解释：[1,null,3] 和 [3,1] 都是高度平衡二叉搜索树。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// nums 按 严格递增 顺序排列 
// 
//
// Related Topics 树 二叉搜索树 数组 分治 二叉树 👍 1485 👎 0


package cn;

import entity.TreeNode;

public class ConvertSortedArrayToBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new ConvertSortedArrayToBinarySearchTree().new Solution();

        TreeNode n0 = new TreeNode();
        TreeNode n1 = new TreeNode();
        TreeNode n2 = new TreeNode();
        TreeNode n3 = new TreeNode();
        TreeNode n4 = new TreeNode();
        n0.val = -10;
        n1.val = -3;
        n2.val = 0;
        n3.val = 5;
        n4.val = 9;
        n2.left = n1;
        n1.left = n0;
        n2.right = n4;
        n4.left = n3;

        int[] nums = new int[]{-10, -3, 0, 5, 9};

        solution.sortedArrayToBST(nums);


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
        public TreeNode sortedArrayToBST(int[] nums) {
            return createTree(nums, 0, nums.length - 1);
        }

        public TreeNode createTree(int[] nums, int leftIndex, int rightIndex) {

            if (leftIndex > rightIndex) {
                return null;
            }
            int rootIndex = (rightIndex + leftIndex) / 2;

            TreeNode root = new TreeNode();
            root.val = nums[rootIndex];
            root.left = createTree(nums, leftIndex, rootIndex - 1);
            root.right = createTree(nums, rootIndex + 1, rightIndex);
            return root;

        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}