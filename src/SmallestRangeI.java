import java.util.Arrays;

/**
 * @author maple on 2019/6/2 14:22.
 * @version v1.0
 * @see 1040441325@qq.com
 * 908. 最小差值 I
 * 给定一个整数数组 A，对于每个整数 A[i]，我们可以选择任意 x 满足 -K <= x <= K，并将 x 加到 A[i] 中。
 * <p>
 * 在此过程之后，我们得到一些数组 B。
 * <p>
 * 返回 B 的最大值和 B 的最小值之间可能存在的最小差值。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [1], K = 0
 * 输出：0
 * 解释：B = [1]
 * 示例 2：
 * <p>
 * 输入：A = [0,10], K = 2
 * 输出：6
 * 解释：B = [2,8]
 * 示例 3：
 * <p>
 * 输入：A = [1,3,6], K = 3
 * 输出：0
 * 解释：B = [3,3,3] 或 B = [4,4,4]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 * 0 <= K <= 10000
 */
public class SmallestRangeI {
    public int smallestRangeI(int[] A, int K) {
        if (A.length == 1) return 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > max) max = A[i];
            if (A[i] < min) min = A[i];
        }
        int res = max - min - 2 * K;
        return res > 0 ? res : 0;
    }

    /**
     * 910. 最小差值 II
     * 给定一个整数数组 A，对于每个整数 A[i]，我们可以选择 x = -K 或是 x = K，并将 x 加到 A[i] 中。
     *
     * 在此过程之后，我们得到一些数组 B。
     *
     * 返回 B 的最大值和 B 的最小值之间可能存在的最小差值。
     *
     *
     *
     * 示例 1：
     *
     * 输入：A = [1], K = 0
     * 输出：0
     * 解释：B = [1]
     * 示例 2：
     *
     * 输入：A = [0,10], K = 2
     * 输出：6
     * 解释：B = [2,8]
     * 示例 3：
     *
     * 输入：A = [1,3,6], K = 3
     * 输出：3
     * 解释：B = [4,6,3]
     *
     *
     * 提示：
     *
     * 1 <= A.length <= 10000
     * 0 <= A[i] <= 10000
     * 0 <= K <= 10000
     * @param A
     * @param K
     * @return
     */
    public int smallestRangeII(int[] A, int K) {
        Arrays.sort(A);
        int len=A.length-1;
        int max=A[len]-K;
        int min=A[0]+K;
        int res=A[len]-A[0];
        for(int i=1; i<=len; ++i){
            int max2=Math.max(max, A[i-1]+K);
            int min2=Math.min(min,A[i]-K);
            int temp=max2-min2;
            res=temp<res?temp:res;
        }
        return res;
    }
}
