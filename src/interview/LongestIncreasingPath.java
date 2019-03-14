package interview;

/**
 * @author maple on 2019/3/14 10:53.
 * @version v1.0
 * @see 1040441325@qq.com
 * 矩阵中的最长递增路径
 * 给定一个整数矩阵，找出最长递增路径的长度。
 * <p>
 * 对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。
 */
public class LongestIncreasingPath {
    //超时
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) return 0;
        int max = 0;
        dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                max = Math.max(max, dfs(i, j, matrix, Integer.MIN_VALUE));
            }
        }
        return max;
    }

    int[][] dp;

    private int dfs(int x, int y, int[][] matrix) {
        if (dp[x][y] != 0) return dp[x][y];
        int max = 0;
        if (x > 0 && matrix[x][y] < matrix[x - 1][y]) max = Math.max(max, dfs(x - 1, y, matrix));
        if (x < matrix.length - 1 && matrix[x][y] < matrix[x + 1][y]) max = Math.max(max, dfs(x + 1, y, matrix));
        if (y > 0 && matrix[x][y] < matrix[x][y - 1]) max = Math.max(max, dfs(x, y - 1, matrix));
        if (y < matrix[x].length - 1 && matrix[x][y] < matrix[x][y + 1])
            max = Math.max(max, dfs(x, y + 1, matrix));
        dp[x][y] = max + 1;
        return max + 1;
    }

    private int dfs(int x, int y, int[][] matrix, int last) {
        if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || matrix[x][y] < last) return 0;
        if (dp[x][y] != 0) return dp[x][y];
        int max = 0;
        max = Math.max(max, dfs(x - 1, y, matrix, matrix[x][y]));
        max = Math.max(max, dfs(x + 1, y, matrix, matrix[x][y]));
        max = Math.max(max, dfs(x, y - 1, matrix, matrix[x][y]));
        max = Math.max(max, dfs(x, y + 1, matrix, matrix[x][y]));
        dp[x][y] = max + 1;
        return max + 1;
    }


    public static void main(String[] args) {
        new LongestIncreasingPath().longestIncreasingPath(new int[][]{{1, 2}});
    }
}
