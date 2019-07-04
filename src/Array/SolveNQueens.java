package Array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author maple on 2019/7/3 17:02.
 * @version v1.0
 * @see 1040441325@qq.com
 * 51. N皇后
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * <p>
 * <p>
 * 上图为 8 皇后问题的一种解法。
 * <p>
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 * <p>
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * <p>
 * 示例:
 * <p>
 * 输入: 4
 * 输出: [
 * [".Q..",  // 解法 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * <p>
 * ["..Q.",  // 解法 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 */
public class SolveNQueens {
    List<List<String>> list;

    public List<List<String>> solveNQueens(int n) {
        list = new ArrayList<>();
        usedCol = new boolean[n];
        usedDiagonal = new boolean[2 * n - 1];
        usedDiagonal2 = new boolean[2 * n - 1];
        bfs(n, 0, new LinkedList<>());
        return list;
    }

    boolean[] usedCol;
    boolean[] usedDiagonal;//i-j+2
    boolean[] usedDiagonal2;//i+j

    private void bfs(int n, int id, LinkedList<String> tmp) {
        if (id == n) {
            list.add(new LinkedList<>(tmp));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (usedCol[i] || usedDiagonal[i - id + n-1] || usedDiagonal2[i + id]) continue;
            usedDiagonal[i - id +  n-1] = true;
            usedDiagonal2[i + id] = true;
            usedCol[i] = true;
            tmp.add(createStr(n, i));
            bfs(n, id + 1, tmp);
            tmp.removeLast();
            usedDiagonal[i - id +n-1] = false;
            usedDiagonal2[i + id] = false;
            usedCol[i] = false;
        }
    }

    private String createStr(int n, int id) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            builder.append(id == i ? 'Q' : '.');
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        show(4);
    }

    private static void show(int n) {
        List<List<String>> res = new SolveNQueens().solveNQueens(n);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < res.size(); i++) {
            List<String> tmp = res.get(i);
            for (int j = 0; j < tmp.size(); j++) {
                builder.append(tmp.get(j)).append("\n");
            }
            builder.append("************************************************\n");
        }
        System.out.println(builder.toString());
    }
}
