////给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。 
////
//// 
////
//// 示例 1: 
////
//// 
////输入: s = "aba"
////输出: true
//// 
////
//// 示例 2: 
////
//// 
////输入: s = "abca"
////输出: true
////解释: 你可以删除c字符。
//// 
////
//// 示例 3: 
////
//// 
////输入: s = "abc"
////输出: false 
////
//// 
////
//// 提示: 
////
//// 
//// 1 <= s.length <= 10⁵ 
//// s 由小写英文字母组成 
//// 
//// Related Topics 贪心 双指针 字符串 👍 481 👎 0
//


package leetcode.editor.cn;

/**
 * 验证回文字符串 Ⅱ
 * @author DY
 * @date 2022-04-12 23:06:59
 */
public class P680_ValidPalindromeIi{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P680_ValidPalindromeIi().new Solution();
		 System.out.println(solution.validPalindrome("abc"));
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean validPalindrome(String s) {
		boolean result = true;
		int l = 0;
		int r = s.length() - 1;
		while(l < r){
			if(s.charAt(l) != s.charAt(r)){
				return valid(l + 1, r, s) || valid(l,r - 1, s);
			}
			l++;
			r--;
		}
		return result;
    }

	public boolean valid(int l, int r,String s){
		while(l < r){
			if(s.charAt(l) != s.charAt(r)){
				return false;
			}
			l++;
			r--;
		}
		return true;
	}
}
//leetcode submit region end(Prohibit modification and deletion)
}