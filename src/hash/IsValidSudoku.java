package hash;

import java.util.Arrays;

/**
 * 有效的数独
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 */
public class IsValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9
                || board[0].length != 9) {
            return false;
        }

        boolean[] base = new boolean[9];
        for (int i = 0; i < 9; i++) {//行
            for (int j = 0; j < 9; j++) {
                int temp = board[i][j] - '1';
                if (temp >= 0 && temp < 10) {
                    if (base[temp]) return false;
                    else base[temp] = true;
                }
            }
            Arrays.fill(base, false);
        }
        for (int i = 0; i < 9; i++) {//列
            for (int j = 0; j < 9; j++) {
                int temp = board[j][i] - '1';
                if (temp >= 0 && temp < 10) {
                    if (base[temp]) return false;
                    else base[temp] = true;
                }
            }
            Arrays.fill(base, false);
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int temp = board[i % 3 * 3 + j % 3][i / 3 * 3 + j / 3] - '1';
                if (temp >= 0 && temp < 10) {
                    if (base[temp]) return false;
                    else base[temp] = true;
                }
            }
            Arrays.fill(base, false);
        }
        return true;
    }


}
