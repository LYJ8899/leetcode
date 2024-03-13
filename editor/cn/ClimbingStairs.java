//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：2
//解释：有两种方法可以爬到楼顶。
//1. 1 阶 + 1 阶
//2. 2 阶 
//
// 示例 2： 
//
// 
//输入：n = 3
//输出：3
//解释：有三种方法可以爬到楼顶。
//1. 1 阶 + 1 阶 + 1 阶
//2. 1 阶 + 2 阶
//3. 2 阶 + 1 阶
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 45 
// 
//
// Related Topics 记忆化搜索 数学 动态规划 👍 3465 👎 0


package cn;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new ClimbingStairs().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        

        //dp
        public int climbStairs(int n) {
            Map<Integer, Integer> map = new HashMap<>();
            return dp(n, map);
        }

        private int dp(int n, Map<Integer, Integer> map) {
            if (n == 1) {
                return 1;
            }
            if (n == 2) {
                return 2;
            } else {
                if (map.containsKey(n)) {
                    return map.get(n);
                } else {
                    int result = dp(n - 1, map) + dp(n - 2, map);
                    map.put(n, result);
                    return result;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}