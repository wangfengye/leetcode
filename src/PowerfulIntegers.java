import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author maple on 2019/6/6 18:09.
 * @version v1.0
 * @see 1040441325@qq.com
 * 970. 强整数
 * 给定两个正整数 x 和 y，如果某一整数等于 x^i + y^j，其中整数 i >= 0 且 j >= 0，那么我们认为该整数是一个强整数。
 * <p>
 * 返回值小于或等于 bound 的所有强整数组成的列表。
 * <p>
 * 你可以按任何顺序返回答案。在你的回答中，每个值最多出现一次。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 2, y = 3, bound = 10
 * 输出：[2,3,4,5,7,9,10]
 * 解释：
 * 2 = 2^0 + 3^0
 * 3 = 2^1 + 3^0
 * 4 = 2^0 + 3^1
 * 5 = 2^1 + 3^1
 * 7 = 2^2 + 3^1
 * 9 = 2^3 + 3^0
 * 10 = 2^0 + 3^2
 * 示例 2：
 * <p>
 * 输入：x = 3, y = 5, bound = 15
 * 输出：[2,4,6,8,10,14]
 */
public class PowerfulIntegers {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        HashSet<Integer> res = new HashSet<>();
        int tmp = 0;
        for (int i = 0, x1; (x1 = pow(x, i)) <= bound; i++) {
            for (int j = 0, y1; (y1 = pow(y, j)) <= bound; j++) {
                if ((tmp = x1 + y1) <= bound) res.add(tmp);
                else break;
                if (y==1)break;
            }
            if (x==1)break;
        }
        return new ArrayList<>(res);
    }

    private static int pow(int a, int b) {
        if (b == 0) return 1;
        int tmp = a;
        for (int i = 1; i < b; i++) {
            tmp *= a;
        }
        return tmp;
    }

    public static void main(String[] args) {
        new PowerfulIntegers().powerfulIntegers(2, 3, 10);
        System.out.println(pow(2, 0));
    }
}
