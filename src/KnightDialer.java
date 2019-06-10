import java.util.Arrays;

/**
 * @author maple on 2019/6/10 9:13.
 * @version v1.0
 * @see 1040441325@qq.com
 * 935. 骑士拨号器
 * 国际象棋中的骑士可以按下图所示进行移动：
 * <p>
 *  .           
 * <p>
 * <p>
 * 这一次，我们将 “骑士” 放在电话拨号盘的任意数字键（如上图所示）上，接下来，骑士将会跳 N-1 步。每一步必须是从一个数字键跳到另一个数字键。
 * <p>
 * 每当它落在一个键上（包括骑士的初始位置），都会拨出键所对应的数字，总共按下 N 位数字。
 * <p>
 * 你能用这种方式拨出多少个不同的号码？
 * <p>
 * 因为答案可能很大，所以输出答案模 10^9 + 7。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：1
 * 输出：10
 * 示例 2：
 * <p>
 * 输入：2
 * 输出：20
 * 示例 3：
 * <p>
 * 输入：3
 * 输出：46
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/knight-dialer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class KnightDialer {
    private static final int[][] STAND = new int[][]{{4, 6}, {6, 8}, {7, 9}, {4, 8}, {0, 3, 9}, {}, {0, 1, 7}, {2, 6}, {1, 3}, {4, 2}};
    private static final int MOD = (int) (Math.pow(10,9)+7);

    public int knightDialer(int N) {
        if (N == 1) return 10;
        int[] dp = new int[10];
        Arrays.fill(dp, 1);
        dp[5] = 0;
        int[] tmp = new int[10];
        for (int k = 1; k < N; k++) {
            Arrays.fill(tmp, 0);
            for (int i = 0; i < dp.length; i++) {
                for (int id : STAND[i]) {
                    tmp[id] = (tmp[id]+ dp[i])%MOD;
                }
            }
            dp = Arrays.copyOf(tmp, tmp.length);
        }
        int sum = 0;
        for (int i = 0; i < dp.length; i++) {
            sum =(sum + dp[i])%MOD;
        }
        return sum;
    }

    public static void main(String[] a) {
        System.out.println(new KnightDialer().knightDialer(161));
    }
}
