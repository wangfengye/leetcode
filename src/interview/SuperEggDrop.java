package interview;

/**
 * @author maple on 2019/3/1 9:50.
 * @version v1.0
 * @see 1040441325@qq.com
 * 鸡蛋掉落
 * 你将获得 K 个鸡蛋，并可以使用一栋从 1 到 N  共有 N 层楼的建筑。
 * <p>
 * 每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。
 * <p>
 * 你知道存在楼层 F ，满足 0 <= F <= N 任何从高于 F 的楼层落下的鸡蛋都会碎，从 F 楼层或比它低的楼层落下的鸡蛋都不会破。
 * <p>
 * 每次移动，你可以取一个鸡蛋（如果你有完整的鸡蛋）并把它从任一楼层 X 扔下（满足 1 <= X <= N）。
 * <p>
 * 你的目标是确切地知道 F 的值是多少。
 * <p>
 * 无论 F 的初始值如何，你确定 F 的值的最小移动次数是多少？
 */
public class SuperEggDrop {

    /**
     * @param K 鸡蛋熟
     * @param N 楼层高度
     * @return F 的最小移动次数
     * 思路:
     * 最优解的最大尝试次数:  f(N,K)
     * 从X层尝试
     * 第一个鸡蛋没碎 f(N-X,K)+1;
     * 第一个鸡蛋碎了 f(X-1,K-1)+1;
     * X固定时的最小次数 Max(f(N-X,K),f(X-1,K-1))+1;
     * 最终方程f(N,k) = Min( Max(f(N-X,K),f(X-1,K-1))+1)(1<=X<=N)
     * 时间复杂度 O(K*N*N)
     * 空间复杂度 O(K*N)
     */
    public int superEggDrop1(int K, int N) {
        int[][] cache = new int[K + 1][N + 1];
        // 初始化最大尝试次数
        for (int i = 0; i <= K; i++) {
            for (int j = 0; j <= N; j++) {
                cache[i][j] = j;
            }
        }
        for (int i = 2; i <= K; i++) {
            for (int j = 1; j <= N; j++) {
                int min = cache[i][j];
                for (int k = 1; k < j; k++) {
                    int max = cache[i - 1][k - 1] + 1;
                    if (cache[i][j - k] + 1 > max) max = cache[i][j - k] + 1;
                    if (max < min) min = max;
                }
                cache[i][j] = min;
            }
        }
        return cache[K][N];
    }

    /**
     * @param K 鸡蛋熟
     * @param N 楼层高度
     * @return F 的最小移动次数
     * 思路:
     * 假设移动x次,k个鸡蛋,最优解的最坏条件下可以检测n层楼,层数n=黑箱子函数f(x,k)
     * 从 n0+1层丢下鸡蛋
     * 鸡蛋破了: 剩 x-1次机会和k-1个鸡蛋 可检测n0层楼
     * 鸡蛋没破: 剩x-1次机会和k个鸡蛋 可检测n1层楼
     * 即层数 <= n0+n1+1 可被检测出
     * f(x,k)= f(x-1,k-1)+f(x-1,k)+1;
     * 表格分析
     *         次数X  1, 2, 3
     * 鸡蛋数K
     *     1          1, 2, 3
     *     2          1, 3, 6
     *     3          1, 3, 7
     *   数组 dp[K+1] 存储 不同鸡蛋数的 最大可测层数
     *   每增加一次测试机会  dp[i] = dp'[i-1]+dp'[i+1]+1;
     * */
    public int superEggDrop(int K, int N) {
        int[] dp = new int[K + 1];
        int step = 0;
        for (; dp[K] < N; step++) {
            for (int i = K; i > 0; i--) {
                dp[i] += (1 + dp[i - 1]);
            }
        }
        return step;
    }

    public static void main(String[] args) {
        System.out.println(new SuperEggDrop().superEggDrop1(1, 2));
        System.out.println(new SuperEggDrop().superEggDrop1(2, 6));
        System.out.println(new SuperEggDrop().superEggDrop1(3, 14));
        System.out.println(new SuperEggDrop().superEggDrop(3, 14));
    }
}
