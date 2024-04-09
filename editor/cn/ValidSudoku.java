//请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图） 
// 
//
// 
//
// 注意： 
//
// 
// 一个有效的数独（部分已被填充）不一定是可解的。 
// 只需要根据以上规则，验证已经填入的数字是否有效即可。 
// 空白格用 '.' 表示。 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：board = 
//[["5","3",".",".","7",".",".",".","."]
//,["6",".",".","1","9","5",".",".","."]
//,[".","9","8",".",".",".",".","6","."]
//,["8",".",".",".","6",".",".",".","3"]
//,["4",".",".","8",".","3",".",".","1"]
//,["7",".",".",".","2",".",".",".","6"]
//,[".","6",".",".",".",".","2","8","."]
//,[".",".",".","4","1","9",".",".","5"]
//,[".",".",".",".","8",".",".","7","9"]]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = 
//[["8","3",".",".","7",".",".",".","."]
//,["6",".",".","1","9","5",".",".","."]
//,[".","9","8",".",".",".",".","6","."]
//,["8",".",".",".","6",".",".",".","3"]
//,["4",".",".","8",".","3",".",".","1"]
//,["7",".",".",".","2",".",".",".","6"]
//,[".","6",".",".",".",".","2","8","."]
//,[".",".",".","4","1","9",".",".","5"]
//,[".",".",".",".","8",".",".","7","9"]]
//输出：false
//解释：除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无
//效的。 
//
// 
//
// 提示： 
//
// 
// board.length == 9 
// board[i].length == 9 
// board[i][j] 是一位数字（1-9）或者 '.' 
// 
//
// Related Topics 数组 哈希表 矩阵 👍 1222 👎 0


package cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidSudoku {
    public static void main(String[] args) {
        Solution solution = new ValidSudoku().new Solution();

        solution.isValidSudoku(new char[][]{{'5', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'}});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValidSudoku(char[][] board) {
            Map<Integer, Set<Character>> map = new HashMap<>();
            Map<Integer, Set<Character>> rowMap = new HashMap<>();
            Map<Integer, Set<Character>> colMap = new HashMap<>();

            for (int i = 0; i < 9; i++) {
                map.put(i, new HashSet<>());
                rowMap.put(i, new HashSet<>());
                colMap.put(i, new HashSet<>());

            }
            for (int i = 0; i < 9; i++) {
                Set<Character> rowSet = rowMap.get(i);
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] == '.') {
                        continue;
                    }
                    Set<Character> colSet = colMap.get(j);
                    if (rowSet.contains(board[i][j])) {
                        return false;
                    } else {
                        rowSet.add(board[i][j]);
                    }

                    if (colSet.contains(board[i][j])) {
                        return false;
                    } else {
                        colSet.add(board[i][j]);
                    }
                    int setNum;
                    if (i < 3) {
                        if (j < 3) {
                            setNum = 0;
                        } else if (j > 2 && j < 6) {
                            setNum = 1;
                        } else {
                            setNum = 2;
                        }
                    } else if (i > 2 && i < 6) {
                        if (j < 3) {
                            setNum = 3;
                        } else if (j > 2 && j < 6) {
                            setNum = 4;
                        } else {
                            setNum = 5;
                        }

                    } else {
                        if (j < 3) {
                            setNum = 6;
                        } else if (j > 2 && j < 6) {
                            setNum = 7;
                        } else {
                            setNum = 8;
                        }
                    }
                    Set<Character> characters = map.get(setNum);
                    if (characters.contains(board[i][j])) {
                        return false;
                    } else {
                        characters.add(board[i][j]);
                    }
                    {
                    }

                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}