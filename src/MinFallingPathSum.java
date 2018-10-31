/**
 * 下降路径最小和
 * 给定一个方形整数数组 A，我们想要得到通过 A 的下降路径的最小和。
 * 下降路径可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列。
 */
public class MinFallingPathSum {
    public int minFallingPathSum(int[][] A) {
        int[][] dp = new int[101][101];
        int sz = A.length;
        for (int i = 0; i < sz; i++) {
            dp[0][i] = A[0][i];
        }
        for (int i = 1; i < sz; i++) {//row
            for (int j = 0; j < sz; j++) {//col
                if (j == 0) dp[i][j] = Math.min(dp[i - 1][j], dp[i-1][j+1]) + A[i][j];
                else if (j == sz - 1) dp[i][j] = Math.min(dp[i - 1][j-1], dp[i-1][j]) + A[i][j];
                else dp[i][j] = Math.min(Math.min(dp[i - 1][j-1], dp[i-1][j]), dp[i - 1][j+1]) + A[i][j];
            }
        }
        int max = Integer.MAX_VALUE;
        for (int i = 0; i < sz; i++) {
            max = Math.min(max, dp[sz - 1][i]);
        }
        return max;
    }

}
