  //如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。 
//
// 字母和数字都属于字母数字字符。 
//
// 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入: s = "A man, a plan, a canal: Panama"
//输出：true
//解释："amanaplanacanalpanama" 是回文串。
// 
//
// 示例 2： 
//
// 
//输入：s = "race a car"
//输出：false
//解释："raceacar" 不是回文串。
// 
//
// 示例 3： 
//
// 
//输入：s = " "
//输出：true
//解释：在移除非字母数字字符之后，s 是一个空字符串 "" 。
//由于空字符串正着反着读都一样，所以是回文串。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 2 * 10⁵ 
// s 仅由可打印的 ASCII 字符组成 
// 
//
// Related Topics 双指针 字符串 👍 732 👎 0

  
  package cn;

  import java.util.ArrayList;
  import java.util.List;

  public class ValidPalindrome{
      public static void main(String[] args) {
           Solution solution = new ValidPalindrome().new Solution();

           solution.isPalindrome("A man, a plan, a canal: Panama");
          //solution.deleteChar('a');
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

          //反转字符串
    public boolean isPalindrome(String s){
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length() ;i++){
            if(deleteChar(s.charAt(i))){
                continue;
            }
            sb.append(s.charAt(i));
        }
        String str = sb.toString();
        String reverse = sb.reverse().toString();
        return str.equals(reverse);
    }

    //双指针
    public boolean isPalindrome1(String s) {

        s = s.toLowerCase();
        int indexL = 0;
        int indexR = s.length() - 1;

        while(indexR > indexL){
            while((indexR > indexL) && deleteChar(s.charAt(indexL))){
                indexL ++;
            }
            while((indexR > indexL) && deleteChar(s.charAt(indexR))){
                indexR --;
            }
            if ((indexR > indexL) && (s.charAt(indexL) != s.charAt(indexR))){
                return false;
            }
            indexL ++;
            indexR --;
        }
        return true;
    }

    private boolean deleteChar(char c){
        if((c >= 'a') && (c <= 'z')){
            return false;
        }else return (c < '0') || (c > '9');
    }

}
//leetcode submit region end(Prohibit modification and deletion)

  }