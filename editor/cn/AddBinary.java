//给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
//
// 
//
// 示例 1： 
//
// 
//输入:a = "11", b = "1"
//输出："100" 
//
// 示例 2： 
//
// 
//输入：a = "1010", b = "1011"
//输出："10101" 
//
// 
//
// 提示： 
//
// 
// 1 <= a.length, b.length <= 10⁴ 
// a 和 b 仅由字符 '0' 或 '1' 组成 
// 字符串如果不是 "0" ，就不含前导零 
// 
//
// Related Topics 位运算 数学 字符串 模拟 👍 1169 👎 0


package cn;

public class AddBinary {
    public static void main(String[] args) {
        Solution solution = new AddBinary().new Solution();

        solution.addBinary("100", "110010");

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addBinary(String a, String b) {
            int next = 0;
            StringBuilder result = new StringBuilder();
            int indexA = a.length() - 1;
            int indexB = b.length() - 1;

            while (indexA >= 0 && indexB >= 0) {
                int sum = add(a.charAt(indexA), b.charAt(indexB), next);
                if (sum == 2) {
                    next = 1;
                    sum = 0;
                } else if (sum == 3) {
                    next = 1;
                    sum = 1;
                } else {
                    next = 0;
                }
                result.insert(0, sum);
                indexA--;
                indexB--;
            }
            if (indexA < 0 && indexB >= 0) {
                for (int i = indexB; i >= 0; i--) {
                    int sum = add('0', b.charAt(i), next);
                    if (sum == 2) {
                        next = 1;
                        sum = 0;
                    } else if (sum == 3) {
                        next = 1;
                        sum = 1;
                    } else {
                        next = 0;
                    }
                    result.insert(0, sum);
                }
            } else if (indexA >= 0) {
                for (int i = indexA; i >= 0; i--) {
                    int sum = add('0', a.charAt(i), next);
                    if (sum == 2) {
                        next = 1;
                        sum = 0;
                    } else if (sum == 3) {
                        next = 1;
                        sum = 1;
                    } else {
                        next = 0;
                    }
                    result.insert(0, sum);
                }
            }
            result.insert(0, next != 0 ? next : "");

            return result.toString();
        }

        private int add(char a, char b, int next) {
            int result = Integer.parseInt(String.valueOf(a)) + Integer.parseInt(String.valueOf(b)) + next;
            if (result == 0) {
                return 0;
            } else if (result == 1) {
                return 1;
            } else if (result == 2) {
                return 2;
            } else {
                return 3;
            }
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}