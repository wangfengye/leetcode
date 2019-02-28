package teambition;

/**
 * @author maple on 2019/2/28 10:27.
 * @version v1.0
 * @see 1040441325@qq.com
 *
 * 在一个 8 x 8 的棋盘上，有一个白色车（rook）。也可能有空方块，白色的象（bishop）和黑色的卒（pawn）。它们分别以字符 “R”，“.”，“B” 和 “p” 给出。大写字符表示白棋，小写字符表示黑棋。
 *
 * 车按国际象棋中的规则移动：它选择四个基本方向中的一个（北，东，西和南），然后朝那个方向移动，直到它选择停止、到达棋盘的边缘或移动到同一方格来捕获该方格上颜色相反的卒。另外，车不能与其他友方（白色）象进入同一个方格。
 *
 * 返回车能够在一次移动中捕获到的卒的数量。
 */
public class NumRookCaptures {
    public int numRookCaptures(char[][] board) {
        int[] rook = getRook(board);
        int canGetCounter = 0;
        int x = rook[0] - 1;
        while (x > -1) {
            if (board[x][rook[1]] == 'B') break;
            if (board[x][rook[1]] == 'p') {
                canGetCounter++;
                break;
            }
            x--;
        }
        x = rook[0] + 1;
        while (x < 8) {
            if (board[x][rook[1]] == 'B') break;
            if (board[x][rook[1]] == 'p') {
                canGetCounter++;
                break;
            }
            x++;
        }
        x = rook[1] - 1;
        while (x > -1) {
            if (board[rook[0]][x] == 'B') break;
            if (board[rook[0]][x] == 'p') {
                canGetCounter++;
                break;
            }
            x--;
        }
        x = rook[1] + 1;
        while (x < 8) {
            if (board[rook[0]][x] == 'B') break;
            if (board[rook[0]][x] == 'p') {
                canGetCounter++;
                break;
            }
            x++;
        }
        return canGetCounter;
    }

    private int[] getRook(char[][] board) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
