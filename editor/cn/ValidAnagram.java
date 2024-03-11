//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
//
// 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 
//输入: s = "rat", t = "car"
//输出: false 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, t.length <= 5 * 10⁴ 
// s 和 t 仅包含小写字母 
// 
//
// 
//
// 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
//
// Related Topics 哈希表 字符串 排序 👍 894 👎 0


package cn;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public static void main(String[] args) {
        Solution solution = new ValidAnagram().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean isAnagram(String s, String t) {

            if (s.length() != t.length()) {
                return false;
            }
            Map<Character, Integer> timesMap = new HashMap<>();

            for (int i = 0; i < s.length(); i++) {
                if (timesMap.containsKey(s.charAt(i))) {
                    timesMap.put(s.charAt(i), timesMap.get(s.charAt(i)) + 1);
                } else {
                    timesMap.put(s.charAt(i), 1);
                }
            }

            for (int i = 0; i < t.length(); i++) {
                if(timesMap.containsKey(t.charAt(i))){
                    int times = timesMap.get(t.charAt(i));
                    if(times > 0){
                        timesMap.put(t.charAt(i), times - 1);
                    }else {
                        return false;
                    }
                }else{
                    return false;
                }
            }
            return true;
        }


        public boolean isAnagram1(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }

            Map<Character, Integer> sMap = new HashMap<>();
            Map<Character, Integer> tMap = new HashMap<>();

            for (int i = 0; i < s.length(); i++) {
                if (sMap.containsKey(s.charAt(i))) {
                    sMap.put(s.charAt(i), sMap.get(s.charAt(i)) + 1);
                } else {
                    sMap.put(s.charAt(i), 1);
                }
                if (tMap.containsKey(t.charAt(i))) {
                    tMap.put(t.charAt(i), tMap.get(t.charAt(i)) + 1);
                } else {
                    tMap.put(t.charAt(i), 1);
                }
            }

            for (Character c : sMap.keySet()) {
                if (!tMap.containsKey(c) || tMap.get(c).intValue() != sMap.get(c).intValue()) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}