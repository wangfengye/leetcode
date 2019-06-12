/**
 * @author maple on 2019/6/12 14:32.
 * @version v1.0
 * @see 1040441325@qq.com
 * 64. 最小路径和
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 *   [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinPathSum {
    public int minPathSum(int[][] grid) {
        return dfs(grid, 0, 0);
    }

    private int dfs(int[][] grid, int i, int j) {//深度优先遍历,大量重复计算,使用dp[][]缓存中间计算(即动态规划)
        if (i == grid.length - 1 && j == grid[i].length - 1) return grid[i][j];
        else if (i == grid.length - 1) return dfs(grid, i, j + 1) + grid[i][j];
        else if (j == grid[i].length - 1) return dfs(grid, i + 1, j) + grid[i][j];
        return Math.min(dfs(grid, i + 1, j), dfs(grid, i, j + 1)) + grid[i][j];
    }

    public int minPathSum2(int[][] grid) {
        int dp[][] = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < grid[0].length; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {
        new MinPathSum().minPathSum2(new int[][]{{0, 1}, {1, 0}});
    }
}
