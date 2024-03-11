  //编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
//
// Related Topics 字典树 字符串 👍 3063 👎 0

  
  package cn;
  public class LongestCommonPrefix{
      public static void main(String[] args) {
           Solution solution = new LongestCommonPrefix().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
          public String longestCommonPrefix(String[] strs) {

              StringBuilder sb = new StringBuilder();

              for (int i = 0; i < strs[0].length(); i++) {
                  char c = strs[0].charAt(i);
                  String pub = pub(strs, c, i);
                  if (pub.isEmpty()) {
                      break;
                  }
                  sb.append(pub);
              }
              return sb.toString();
          }

          public String pub(String[] strs, char c, int index) {
              for (int j = 0; j < strs.length; j++) {
                  if(strs[j].length() - 1 < index){
                      return "";
                  }
                  if (strs[j].charAt(index) != c) {
                      return "";
                  }
              }
              return String.valueOf(c);
          }
}
//leetcode submit region end(Prohibit modification and deletion)

  }