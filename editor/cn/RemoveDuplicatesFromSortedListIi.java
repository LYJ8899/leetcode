//给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,3,4,4,5]
//输出：[1,2,5]
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,1,1,2,3]
//输出：[2,3]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围 [0, 300] 内 
// -100 <= Node.val <= 100 
// 题目数据保证链表已经按升序 排列 
// 
//
// Related Topics 链表 双指针 👍 1282 👎 0


package cn;

public class RemoveDuplicatesFromSortedListIi {
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedListIi().new Solution();


        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(2);
        listNode1.next = listNode2;
        listNode2.next = listNode3;

        solution.deleteDuplicates(listNode1);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode virNode = new ListNode(Integer.MIN_VALUE);
            ListNode pre = virNode;
            int deleteVal = Integer.MIN_VALUE;

            while (head != null) {
                if (head.next != null && head.next.val != head.val && deleteVal != head.val) {
                    pre.next = head;
                    pre = head;
                    deleteVal = Integer.MIN_VALUE;
                } else if (head.next != null && head.next.val == head.val) {
                    deleteVal = head.val;
                    pre.next = null;
                }
                if (head.next == null && head.val != pre.val && deleteVal != head.val) {
                    pre.next = head;
                }
                head = head.next;
            }
            return virNode.next;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

//leetcode submit region end(Prohibit modification and deletion

}
