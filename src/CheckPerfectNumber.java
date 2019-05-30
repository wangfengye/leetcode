import java.util.ArrayList;

/**
 * @author maple on 2019/5/30 9:30.
 * @version v1.0
 * @see 1040441325@qq.com
 * 对于一个 正整数，如果它和除了它自身以外的所有正因子之和相等，我们称它为“完美数”。
 * <p>
 * 给定一个 正整数 n， 如果他是完美数，返回 True，否则返回 False
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入: 28
 * 输出: True
 * 解释: 28 = 1 + 2 + 4 + 7 + 14
 * <p>
 * <p>
 * 注意:
 * <p>
 * 输入的数字 n 不会超过 100,000,000. (1e8)
 */
public class CheckPerfectNumber {
    public static boolean checkPerfectNumber(int num) {
        if (num <= 1) return false;
        int sum = 1;
        int l = 1 + 1;
        int r = (int) Math.sqrt(num);
        int tmp = 0;
        while (l <= r) {
            if (num % l == 0) {
                tmp = num / l;
                sum = sum + l + tmp;
            }
            l++;
        }
        return sum == num;
    }

    public static void main(String[] atgs) {
        checkPerfectNumber(28);
    }
}
