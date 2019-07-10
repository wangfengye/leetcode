/**
 * @author maple on 2019/7/10 15:04.
 * @version v1.0
 * @see 1040441325@qq.com
 * 342. 4的幂
 * 给定一个整数 (32 位有符号整数)，请编写一个函数来判断它是否是 4 的幂次方。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 16
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: 5
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-four
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsPowerOfFour {
    public boolean isPowerOfFour(int num) {
        if (num <= 0) return false;

        while (num > 1) {
            if (num % 4 != 0) return false;
            num /= 4;
        }
        return true;
    }
}
