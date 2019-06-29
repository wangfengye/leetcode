package Array;

import java.util.Arrays;

/**
 * @author maple on 2019/6/29 11:39.
 * @version v1.0
 * @see 1040441325@qq.com
 * 37. 解数独
 * 编写一个程序，通过已填充的空格来解决数独问题。
 * <p>
 * 一个数独的解法需遵循如下规则：
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 空白格用 '.' 表示。
 * <p>
 * <p>
 * <p>
 * 一个数独。
 * <p>
 * <p>
 * <p>
 * 答案被标成红色。
 * <p>
 * Note:
 * <p>
 * 给定的数独序列只包含数字 1-9 和字符 '.' 。
 * 你可以假设给定的数独只有唯一解。
 * 给定数独永远是 9x9 形式的。
 */
public class SolveSudoku {
    public void solveSudoku(char[][] board) {
        bfs(board, 0, 0, new boolean[9]);
    }

    private boolean bfs(char[][] board, int i, int j, boolean[] tmp) {
        if (j == 9) {
            i++;
            j = 0;
            tmp = new boolean[9];
        }
        if (i >= 9) return true;//完成遍历
        int x = (i / 3) * 3 + j / 3;
        int y = (i % 3) * 3 + j % 3;
        show(chars);
        System.out.println(x + " --- " + y);
        if (board[x][y] == '.') {
            for (int k = 0; k < tmp.length; k++) {
                if (!tmp[k]) {
                    board[x][y] = (char) (k + '1');
                    tmp[k] = true;
                    if (checkRowCol(board, x, y) && bfs(board, i, j + 1, tmp)) {
                        return true;
                    } else {
                        tmp[k] = false;
                        board[x][y] = '.';
                    }
                }
            }
            return false;
        } else {
            if (tmp[board[x][y] - '1']) return false;
            tmp[board[x][y] - '1'] = true;
            boolean res =bfs(board, i, j + 1, tmp);
            tmp[board[x][y] - '1'] = false;
            return res;
        }
    }

    private boolean checkRowCol(char[][] board, int i, int j) {
        for (int k = 0; k < board.length; k++) {
            if (i != k && board[k][j] == board[i][j]) return false;
        }
        for (int k = 0; k < board[i].length; k++) {
            if (j != k && board[i][k] == board[i][j]) return false;
        }
        return true;
    }

    static char[][] chars = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

    public static void main(String[] args) {

        new SolveSudoku().solveSudoku(chars);
        // show(chars);

    }

    private static String show(char[][] chars) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars.length; j++) {
                builder.append(chars[i][j]).append(", ");
            }
            builder.append("\n");
        }
        System.out.println(builder.toString());
        return builder.toString();
    }
}
