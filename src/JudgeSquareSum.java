/**
 * @author maple on 2020/1/11 15:14.
 * @version v1.0
 * @see 1040441325@qq.com
 * 633. 平方数之和
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。
 * <p>
 * 示例1:
 * <p>
 * 输入: 5
 * 输出: True
 * 解释: 1 * 1 + 2 * 2 = 5
 *  
 * <p>
 * 示例2:
 * <p>
 * 输入: 3
 * 输出: False
 */
public class JudgeSquareSum {
    public boolean judgeSquareSum(int c) {
        //a从0开始取,递增,每次判断剩下的数是否可开方
        for (long a = 0; a * a <= c; a++) {
            int b = c - (int) (a * a);
            if (binary_search(0, b, b))
                return true;
        }
        return false;
    }

    /**
     * 判断n是否可开方
     *
     * @param s 起点
     * @param e 中点
     * @param n n
     * @return
     */
    public boolean binary_search(long s, long e, int n) {
        if (s > e)
            return false;
        long mid = s + (e - s) / 2;
        if (mid * mid == n)
            return true;
        if (mid * mid > n)
            return binary_search(s, mid - 1, n);
        return binary_search(mid + 1, e, n);
    }

    /**
     * 引理1：形如4k+3的自然数不能表示成2个整数的平方和
     * 引理2：正整数n可被表示为两整数平方和的充要条件为n的一切形如4k+3形状的质因子的幂次均为偶数
     * 说 明：引理2 是基于费马平方和的推论
     * 一个非负整数 cc 能够表示为两个整数的平方和，当且仅当 cc 的所有形如 4k+3 的质因子的幂次均为偶数。
     * @param c
     * @return
     */
    public boolean judgeSquareSum2(int c) {
        for (int i = 2; i * i <= c; i++) {
            //因式分解
            int count = 0;
            if (c % i == 0) {
                while (c % i == 0) {
                    count++;
                    c /= i;
                }
                //形如 4k+3 的质因子的幂次均为偶数
                if (i % 4 == 3 && count % 2 != 0) {
                    return false;
                }
            }
        }
        //剩余1或一个幂次为1的因数.
        return c % 4 != 3;
    }
}
