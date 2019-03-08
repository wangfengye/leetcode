package interview;

/**
 * @author maple on 2019/3/7 17:22.
 * @version v1.0
 * @see 1040441325@qq.com
 * 阶乘后的零
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 3
 * 输出: 0
 * 解释: 3! = 6, 尾数中没有零。
 * 示例 2:
 * <p>
 * 输入: 5
 * 输出: 1
 * 解释: 5! = 120, 尾数中有 1 个零.
 * 说明: 你算法的时间复杂度应为 O(log n) 。

 */
public class TrailingZeroes {
    public int trailingZeroes(int n) {
        /**
         * 10 =2*5; 2的数量远大于5的数量,因此0的数量取决于5的数量
         * 数字    5  10  15 20  25 30
         * 5的个数 1  1   1  1   2  1
         * 即 5的个数 =  n/5 + n/25 + ... n/5^n;
         */
        int counter = 0;
        while (n >= 5) {
            n = n / 5;
            counter += n;
        }
        return counter;
    }

    public static void main(String[] args) {
        System.out.println(new TrailingZeroes().trailingZeroes(1808548329));
    }
}
