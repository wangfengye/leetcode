/**
 * @author maple on 2019/6/4 10:02.
 * @version v1.0
 * @see 1040441325@qq.com
 * 868. 二进制间距
 * 给定一个正整数 N，找到并返回 N 的二进制表示中两个连续的 1 之间的最长距离。
 * <p>
 * 如果没有两个连续的 1，返回 0 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：22
 * 输出：2
 * 解释：
 * 22 的二进制是 0b10110 。
 * 在 22 的二进制表示中，有三个 1，组成两对连续的 1 。
 * 第一对连续的 1 中，两个 1 之间的距离为 2 。
 * 第二对连续的 1 中，两个 1 之间的距离为 1 。
 * 答案取两个距离之中最大的，也就是 2 。
 */
public class BinaryGap {
    public int binaryGap(int N) {
        int[] A = new int[32];
        int t = 0;
        for (int i = 0; i < 32; ++i) {
            if (((N >> i) & 1) != 0)
                A[t++] = i;
            if (N <= 0) break;
        }

        int ans = 0;
        for (int i = 0; i < t - 1; ++i)
            ans = Math.max(ans, A[i + 1] - A[i]);
        return ans;
    }

    public int binaryGap2(int N) {
        int last = -1, ans = 0;
        for (int i = 0; i < 32; ++i) {
            if ((N & 1) > 0) {
                if (last >= 0) ans = Math.max(ans, i - last);
                last = i;
            }
            if (N <= 0) break;
            N = N >> 1;
        }
        return ans;
    }

}
