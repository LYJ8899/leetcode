//给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
//
// 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。 
//
// 
//
// 示例 1: 
//
// 
//输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出: [["bat"],["nat","tan"],["ate","eat","tea"]] 
//
// 示例 2: 
//
// 
//输入: strs = [""]
//输出: [[""]]
// 
//
// 示例 3: 
//
// 
//输入: strs = ["a"]
//输出: [["a"]] 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 10⁴ 
// 0 <= strs[i].length <= 100 
// strs[i] 仅包含小写字母 
// 
//
// Related Topics 数组 哈希表 字符串 排序 👍 1860 👎 0


package cn;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        Solution solution = new GroupAnagrams().new Solution();
        solution.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> wordsMap = new HashMap<>();
            List<List<String>> resultList = new ArrayList<>();

            for (int i = 0; i < strs.length; i++) {
                char[] charArray = strs[i].toCharArray();
                Arrays.sort(charArray);
                String word = String.copyValueOf(charArray);

                if (wordsMap.containsKey(word)) {
                    List<String> strings = wordsMap.get(word);
                    strings.add(strs[i]);
                } else {
                    List<String> strings = new ArrayList<>();
                    strings.add(strs[i]);
                    wordsMap.put(word, strings);
                }
            }

            for (String word : wordsMap.keySet()) {
                resultList.add(wordsMap.get(word));
            }
            return resultList;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}