//给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链
//表节点，返回 反转后的链表 。
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], left = 2, right = 4
//输出：[1,4,3,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [5], left = 1, right = 1
//输出：[5]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目为 n 
// 1 <= n <= 500 
// -500 <= Node.val <= 500 
// 1 <= left <= right <= n 
// 
//
// 
//
// 进阶： 你可以使用一趟扫描完成反转吗？ 
//
// Related Topics 链表 👍 1762 👎 0


package cn;

import java.util.ArrayList;
import java.util.List;

public class ReverseLinkedListIi {
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedListIi().new Solution();
        Solution.ListNode listNode1 = new Solution.ListNode(1);
        Solution.ListNode listNode2 = new Solution.ListNode(2);
        Solution.ListNode listNode3 = new Solution.ListNode(3);
        Solution.ListNode listNode4 = new Solution.ListNode(4);
        Solution.ListNode listNode5 = new Solution.ListNode(5);
        listNode4.next = listNode5;
        listNode3.next = listNode4;
        listNode2.next = listNode3;
        listNode1.next = listNode2;

        solution.reverseBetween(listNode1, 2, 4);

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
        public ListNode reverseBetween(ListNode head, int left, int right) {

            int index = 1;
            ListNode now = head;
            ListNode endNode = null;

            while (index <= right) {
                if (index < left) {
                    now = now.next;
                    index++;
                } else {
                    ListNode nextNode = now.next;
                    now.next = endNode;
                    endNode = now;
                    now = nextNode;
                    index++;
                }
            }
            return head;
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
    }
//leetcode submit region end(Prohibit modification and deletion)

}