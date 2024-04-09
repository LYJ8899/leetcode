//给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
//
// 你应当 保留 两个分区中每个节点的初始相对位置。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,4,3,2,5,2], x = 3
//输出：[1,2,2,4,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [2,1], x = 2
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 200] 内 
// -100 <= Node.val <= 100 
// -200 <= x <= 200 
// 
//
// Related Topics 链表 双指针 👍 827 👎 0


package cn;

public class PartitionList {
    public static void main(String[] args) {
        Solution solution = new PartitionList().new Solution();
        ListNode listNode1 = new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(0, new ListNode(2, new ListNode(5, new ListNode(2)))))));
        solution.partition(listNode1, 3);
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
        public ListNode partition(ListNode head, int x) {

            if (head == null) {
                return null;
            } else if (head.next == null) {
                return head;
            }

            ListNode virNode = new ListNode(Integer.MIN_VALUE, head);
            ListNode insert = virNode;
            ListNode subHead = head.val >= x ? head : null;
            head = virNode;
            while (head != null) {
                if (insert.val == Integer.MIN_VALUE && head.next.val >= x && subHead == null) {
                    insert = head;
                    subHead = head.next;
                }
                if (head.next != null && head.next.val < x && subHead != null) {
                    //todo: 寻找右节点
                    ListNode rNode = head.next.next;
                    ListNode moveNode = head.next;
                    head.next = rNod
                    moveNode.next = subHead;
                    subHead = moveNode;
                    insert.next = subHead;
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
//leetcode submit region end(Prohibit modification and deletion)

}