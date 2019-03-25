package competition.week128;

/**
 * @author maple on 2019/3/18 10:46.
 * @version v1.0
 * @see 1040441325@qq.com\
 * 1015. 至少有 1 位重复的数字  显示英文描述
 * 用户通过次数 22
 * 用户尝试次数 120
 * 通过次数 23
 * 提交次数 289
 * 题目难度 Hard
 * 给定正整数 N，返回小于等于 N 且具有至少 1 位重复数字的正整数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：20
 * 输出：1
 * 解释：具有至少 1 位重复数字的正数（<= 20）只有 11 。
 * 示例 2：
 * <p>
 * 输入：100
 * 输出：10
 * 解释：具有至少 1 位重复数字的正数（<= 100）有 11，22，33，44，55，66，77，88，99 和 100 。
 * 示例 3：
 * <p>
 * 输入：1000
 * 输出：262
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= N <= 10^9
 */
public class NumDupDigitsAtMostN {
    int[] a;
    int[][] dp;

    public int numDupDigitsMostN(int N) {
        a = new int[12];
        dp = new int[1024][12];
        int ans = N;
        for (int i = 0; i < N; N /= 10) {
            a[i++] = N % 10;

        }
        return 0;

    }

    public static int a(int m, int n) {
        return n == 0 ? 1 : (a(m, n - 1) * (m - n + 1));
    }

    public static void main(String[] args) {
        int n = Integer.MAX_VALUE;
        int c = 0;
        while (n > 0) {
            c++;
            n /= 16;
        }
        System.out.println(c);
    }
}
