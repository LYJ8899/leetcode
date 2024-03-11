//给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
//
// 如果可以，返回 true ；否则返回 false 。 
//
// magazine 中的每个字符只能在 ransomNote 中使用一次。 
//
// 
//
// 示例 1： 
//
// 
//输入：ransomNote = "a", magazine = "b"
//输出：false
// 
//
// 示例 2： 
//
// 
//输入：ransomNote = "aa", magazine = "ab"
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：ransomNote = "aa", magazine = "aab"
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= ransomNote.length, magazine.length <= 10⁵ 
// ransomNote 和 magazine 由小写英文字母组成 
// 
//
// Related Topics 哈希表 字符串 计数 👍 866 👎 0


package cn;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    public static void main(String[] args) {
        Solution solution = new RansomNote().new Solution();

        solution.canConstruct("aab", "baa");

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public boolean canConstruct(String ransomNote, String magazine) {

            Map<Character, Integer> mapR = new HashMap<>();
            Map<Character, Integer> mapM = new HashMap<>();

            for (int i = 0; i < ransomNote.length(); i++) {
                count(mapR, ransomNote.charAt(i));
            }
            for (int i = 0; i < magazine.length(); i++){
                count(mapM, magazine.charAt(i));
            }
            for(Character c :mapR.keySet()){
                if(!mapM.containsKey(c) || mapR.get(c) > mapM.get(c)){
                    return false;
                }
            }
            return true;
        }

        private void count(Map<Character, Integer> map, Character key) {
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            }else{
                map.put(key, 1);
            }
        }

        public boolean canConstruct1(String ransomNote, String magazine) {

            if (ransomNote.length() <= magazine.length()) {
                Map<Character, Integer> timesMap = new HashMap<>();
                for (int i = 0; i < magazine.length(); i++) {
                    if (timesMap.containsKey(magazine.charAt(i))) {
                        timesMap.put(magazine.charAt(i), timesMap.get(magazine.charAt(i)) + 1);
                    } else {
                        timesMap.put(magazine.charAt(i), 1);
                    }
                }
                for (int i = 0; i < ransomNote.length(); i++) {
                    if (timesMap.containsKey(ransomNote.charAt(i)) && timesMap.get(ransomNote.charAt(i)) > 0) {
                        timesMap.put(ransomNote.charAt(i), timesMap.get(ransomNote.charAt(i)) - 1);
                    } else {
                        return false;
                    }
                }
                return true;
            } else {
                return false;
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}