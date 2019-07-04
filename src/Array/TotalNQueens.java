package Array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author maple on 2019/7/4 9:15.
 * @version v1.0
 * @see 1040441325@qq.com
 * 52. N皇后 II
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * <p>
 * <p>
 * 上图为 8 皇后问题的一种解法。
 * <p>
 * 给定一个整数 n，返回 n 皇后不同的解决方案的数量。
 * <p>
 * 示例:
 * <p>
 * 输入: 4
 * 输出: 2
 * 解释: 4 皇后问题存在如下两个不同的解法。
 * [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 * <p>
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TotalNQueens {
    int res;

    public int totalNQueens(int n) {
        res = 0;
        usedCol = new boolean[n];
        usedDiagonal = new boolean[2 * n - 1];
        usedDiagonal2 = new boolean[2 * n - 1];
        bfs(n, 0);
        return res;
    }

    boolean[] usedCol;
    boolean[] usedDiagonal;//i-j+2
    boolean[] usedDiagonal2;//i+j

    private void bfs(int n, int id) {
        if (id == n) {
            res++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (usedCol[i] || usedDiagonal[i - id + n - 1] || usedDiagonal2[i + id]) continue;
            usedDiagonal[i - id + n - 1] = true;
            usedDiagonal2[i + id] = true;
            usedCol[i] = true;
            bfs(n, id + 1);

            usedDiagonal[i - id + n - 1] = false;
            usedDiagonal2[i + id] = false;
            usedCol[i] = false;
        }
    }


    public static void main(String[] args) {
      System.out.println(new TotalNQueens().totalNQueens(4));
      System.out.println(new TotalNQueens().totalNQueens(1));
    }


}
