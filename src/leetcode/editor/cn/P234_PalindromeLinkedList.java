//给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,2,1]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围[1, 10⁵] 内 
// 0 <= Node.val <= 9 
// 
//
// 
//
// 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 栈 递归 链表 双指针 👍 1340 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 回文链表
 * @author DY
 * @date 2022-04-13 11:18:25
 */
public class P234_PalindromeLinkedList{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P234_PalindromeLinkedList().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    private ListNode frountPointer;

    public boolean isPalindrome(ListNode head) {
		boolean result = true;
        List<ListNode> nodeList = new ArrayList<>();
        nodeList.add(head);
        while(head.next != null){
            nodeList.add(head.next);
            head = head.next;
        }
        int l = 0;
        int r = nodeList.size() - 1;
        while(l < r){
            if(nodeList.get(l).val != nodeList.get(r).val){
                return false;
            }
            l++;
            r--;
        }
		return result;
    }
    public boolean isPalindrome1(ListNode head){
        frountPointer = head;
        return valid(head);
    }

    public boolean valid(ListNode node){
        if(node.next == null){
            if(node.val != frountPointer.val){
                frountPointer = frountPointer.next;
                return false;
            }else{
                frountPointer = frountPointer.next;
                return true;
            }
        }else{
            if(valid(node.next) && (node.val == frountPointer.val)){
                frountPointer = frountPointer.next;
                return true;
            }else{
                frountPointer = frountPointer.next;
                return false;
            }
        }
    }

    public boolean compare(ListNode node,ListNode node1){
        if(node.val == node1.val){
            return true;
        }else{
            return false;
        }
    }

}

class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val){
	  this.val = val;
  }
  ListNode(int val, ListNode next){
	  this.val = val;
	  this.next = next;
  }
}
//leetcode submit region end(Prohibit modification and deletion)

}