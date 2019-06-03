/**
 * @author maple on 2019/6/3 15:28.
 * @version v1.0
 * @see 1040441325@qq.com
 * 1034. 边框着色
 * 给出一个二维整数网格 grid，网格中的每个值表示该位置处的网格块的颜色。
 * <p>
 * 只有当两个网格块的颜色相同，而且在四个方向中任意一个方向上相邻时，它们属于同一连通分量。
 * <p>
 * 连通分量的边界是指连通分量中的所有与不在分量中的正方形相邻（四个方向上）的所有正方形，或者在网格的边界上（第一行/列或最后一行/列）的所有正方形。
 * <p>
 * 给出位于 (r0, c0) 的网格块和颜色 color，使用指定颜色 color 为所给网格块的连通分量的边界进行着色，并返回最终的网格 grid 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [[1,1],[1,2]], r0 = 0, c0 = 0, color = 3
 * 输出：[[3, 3], [3, 2]]
 * 示例 2：
 * <p>
 * 输入：grid = [[1,2,2],[2,3,2]], r0 = 0, c0 = 1, color = 3
 * 输出：[[1, 3, 3], [2, 3, 3]]
 * 示例 3：
 * <p>
 * 输入：grid = [[1,1,1],[1,1,1],[1,1,1]], r0 = 1, c0 = 1, color = 2
 * 输出：[[2, 2, 2], [2, 1, 2], [2, 2, 2]]
 */
public class ColorBorder {
    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        boolean[][] marked = new boolean[grid.length][grid[0].length];
        int tmp = grid[r0][c0];
        draw(grid, r0, c0, tmp, color, marked);
        for (int i = 0; i < marked.length; i++) {
            for (int j = 0; j < marked[i].length; j++) {
                if (marked[i][j] ){
                    if (getLen(marked, i, j) == 4) grid[i][j] = tmp;
                    else grid[i][j]=color;
                }
            }
        }
        return grid;
    }

    private boolean draw(int[][] grid, int i, int j, int tar, int color, boolean[][] marked) {
        if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[i].length - 1) return false;
        if (grid[i][j] == tar) {
            grid[i][j] = tar-1;
            draw(grid, i - 1, j, tar, color, marked);
            draw(grid, i + 1, j, tar, color, marked);
            draw(grid, i, j - 1, tar, color, marked);
            draw(grid, i, j + 1, tar, color, marked);
            marked[i][j] = true;
            return true;
        }
        return false;
    }

    private int getLen(boolean[][] grid, int i, int j) {
        int len = 0;
        if (i > 0 && grid[i - 1][j]) len++;
        if (i < grid.length - 1 && grid[i + 1][j]) len++;
        if (j > 0 && grid[i][j - 1]) len++;
        if (j < grid[i].length - 1 && grid[i][j + 1]) len++;
        return len;
    }

    public static void main(String[] args) {
         new ColorBorder().colorBorder(new int[][]{{1,1},{1,2}},0,0,3);
         new ColorBorder().colorBorder(new int[][]{{1,2,2},{2,3,2}},0,1,3);
        new ColorBorder().colorBorder(new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}}, 1, 1, 2);
        new ColorBorder().colorBorder(new int[][]{{1, 2, 1}, {1, 2,2}, {2,2, 1}}, 1, 1, 2);
    }
}
