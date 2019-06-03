import java.util.Arrays;

/**
 * @author maple on 2019/6/3 17:48.
 * @version v1.0
 * @see 1040441325@qq.com
 * 576. 出界的路径数
 * 给定一个 m × n 的网格和一个球。球的起始坐标为 (i,j) ，你可以将球移到相邻的单元格内，或者往上、下、左、右四个方向上移动使球穿过网格边界。但是，你最多可以移动 N 次。找出可以将球移出边界的路径数量。答案可能非常大，返回 结果 mod 109 + 7 的值。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: m = 2, n = 2, N = 2, i = 0, j = 0
 * 输出: 6
 */
public class FindPaths {
    private static final int MOD = 1000000007;
    private int[][][] dp;
    // 广度优先遍历 --> 动态规划,
    //其特点是,存在大量重复计算,使用数组存储中间过程计算结果,空间换时间.
    public int findPaths(int m, int n, int N, int i, int j) {
        dp = new int[m][n][N + 1];
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                Arrays.fill(dp[x][y], -1);
            }
        }
        return dfs(m, n, N, i, j);
    }

    public int dfs(int m, int n, int N, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n) return 1;
        if (dp[i][j][N]!=-1)return dp[i][j][N];
        if (N <= 0) return 0;
        N--;
        return dp[i][j][N+1] = (((dfs(m, n, N, i - 1, j) + dfs(m, n, N, i + 1, j))%MOD + dfs(m, n, N, i, j - 1))%MOD + dfs(m, n, N, i, j + 1)) % MOD;
    }

    public int findPaths2(int m, int n, int N, int i, int j) {//动态规划
        if (m == 0 || n == 0 || N == 0) return 0;
        int mod = 1000000007;
        int dp[][][] = new int[m][n][N + 1];
        for (int k = 0; k <= N; k++) {
            for (int l = 0; l < m; l++) {
                for (int o = 0; o < n; o++) {
                    if (l - 1 < 0) dp[l][o][k] += 1;
                    else dp[l][o][k] = (dp[l][o][k] + dp[l - 1][o][k - 1]) % mod;
                    if (l + 1 >= m) dp[l][o][k] += 1;
                    else dp[l][o][k] = (dp[l][o][k] + dp[l + 1][o][k - 1]) % mod;
                    if (o - 1 < 0) dp[l][o][k] += 1;
                    else dp[l][o][k] = (dp[l][o][k] + dp[l][o - 1][k - 1]) % mod;
                    if (o + 1 >= n) dp[l][o][k] += 1;
                    else dp[l][o][k] = (dp[l][o][k] + dp[l][o + 1][k - 1]) % mod;
                }
            }
        }
        return dp[i][j][N];
    }

    public static void main(String[] a) {
        System.out.println(new FindPaths().findPaths(2, 2, 2, 0, 0));
        System.out.println(new FindPaths().findPaths(1, 3, 3, 0, 1));
        System.out.println(new FindPaths().findPaths(8, 7, 16, 1, 5));
    }
}
