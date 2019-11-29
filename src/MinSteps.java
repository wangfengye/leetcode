/**
 * @author maple on 2019/11/29 10:07.
 * @version v1.0
 * @see 1040441325@qq.com
 * 650. 只有两个键的键盘
 * 最初在一个记事本上只有一个字符 'A'。你每次可以对这个记事本进行两种操作：
 * <p>
 * Copy All (复制全部) : 你可以复制这个记事本中的所有字符(部分的复制是不允许的)。
 * Paste (粘贴) : 你可以粘贴你上一次复制的字符。
 * 给定一个数字 n 。你需要使用最少的操作次数，在记事本中打印出恰好 n 个 'A'。输出能够打印出 n 个 'A' 的最少操作次数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 3
 * 输出: 3
 * 解释:
 * 最初, 我们只有一个字符 'A'。
 * 第 1 步, 我们使用 Copy All 操作。
 * 第 2 步, 我们使用 Paste 操作来获得 'AA'。
 * 第 3 步, 我们使用 Paste 操作来获得 'AAA'。
 */
public class MinSteps {
    /**
     * 质数只能一个个复制.
     * 本题本质是因式分解.
     *
     * @param n
     * @return
     */
    public int minSteps(int n) {
        if (n == 1) return 0;
        for (int i = n / 2; i > 1; i--) {
            if (n % i == 0) return minSteps(i) + n / i;
        }
        return n;
    }
}
