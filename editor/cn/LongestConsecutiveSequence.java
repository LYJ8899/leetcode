//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
//
// 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。 
//
// 示例 2： 
//
// 
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// Related Topics 并查集 数组 哈希表 👍 2035 👎 0


package cn;

import java.util.*;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        Solution solution = new LongestConsecutiveSequence().new Solution();
        solution.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int longestConsecutive(int[] nums) {
            int result = 0;
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                set.add(nums[i]);
                min = Math.min(min, nums[i]);
                max = Math.max(max, nums[i]);
            }
            int len = 0;
            for (int i = min; i <= max; i++) {
                if (set.contains(i)) {
                    len++;
                    result = Math.max(len, result);
                } else {
                    len = 0;
                }
            }
            return result;
        }

        //n*logn
        public int longestConsecutive1(int[] nums) {
            Arrays.sort(nums);
            Map<Integer, Set<Integer>> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(nums[i] - 1)) {
                    Set<Integer> integers = map.get(nums[i] - 1);
                    integers.add(nums[i]);
                    map.put(nums[i], integers);
                }
                if (map.containsKey(nums[i] + 1)) {
                    Set<Integer> integers = map.get(nums[i] + 1);
                    integers.add(nums[i]);
                    map.put(nums[i], integers);
                }
                if (!map.containsKey(nums[i])) {
                    Set<Integer> integers = new HashSet<>();
                    integers.add(nums[i]);
                    map.put(nums[i], integers);
                }
            }
            int max = 0;
            for (Integer key : map.keySet()) {
                max = Math.max(max, map.get(key).size());
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}