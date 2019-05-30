import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author maple on 2019/5/30 9:14.
 * @version v1.0
 * @see 1040441325@qq.com
 * <p>
 * 自除数 是指可以被它包含的每一位数除尽的数。
 * <p>
 * 例如，128 是一个自除数，因为 128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。
 * <p>
 * 还有，自除数不允许包含 0 。
 * <p>
 * 给定上边界和下边界数字，输出一个列表，列表的元素是边界（含边界）内所有的自除数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * 上边界left = 1, 下边界right = 22
 * 输出： [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 * 注意：
 * <p>
 * 每个输入参数的边界满足 1 <= left <= right <= 10000。
 */
public class SelfDividingNumbers {
    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (; left <= right; left++) {
            int tmp = 1;
            int d = 0;
            while (left >= tmp) {
                if ((d = left / tmp % 10) != 0 && left % d == 0) {
                    tmp *= 10;
                } else {
                    break;
                }
                if (left < tmp) {
                    res.add(left);
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        selfDividingNumbers(1, 22);
    }
}
