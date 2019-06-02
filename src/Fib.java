/**
 * @author maple on 2019/6/2 14:04.
 * @version v1.0
 * @see 1040441325@qq.com
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * <p>
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 给定 N，计算 F(N)。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1.
 * 示例 2：
 * <p>
 * 输入：3
 * 输出：2
 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2.
 * 示例 3：
 * <p>
 * 输入：4
 * 输出：3
 * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3.
 */
public class Fib {
    public int fib(int N) {//直接翻译出的代码,存在重复计算的F(i)
        if (N == 0) return 0;
        else if (N == 1) return 1;
        else return fib(N - 1) + fib(N - 2);
    }

    public int fib2(int N) {//数组缓存数据
        if (N == 0) return 0;
        int[] tmp = new int[N + 1];
        tmp[0]=0;
        tmp[1]=1;
        for (int i = 2; i < N + 1; i++) {
            tmp[i]=tmp[i-1]+tmp[i-2];
        }
        return tmp[N];
    }
    public int fib3(int N) {
        if (N == 0) return 0;
        int first = 0;
        int second = 1;

        for (int i = 2; i < N + 1; i++) {
            int tmp = first+second;
            first=second;
            second=tmp;
        }
        return second;
    }
}
