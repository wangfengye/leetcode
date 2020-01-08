/**
 * @author maple on 2020/1/7 11:52.
 * @version v1.0
 * @see 1040441325@qq.com
 * LCP 2. 分式化简
 * 输入：cont = [3, 2, 0, 2]
 * 输出：[13, 4]
 * 解释：原连分数等价于3 + (1 / (2 + (1 / (0 + 1 / 2))))。注意[26, 8], [-13, -4]都不是正确答案。
 *
 */
public class Fraction {
    public int[] fraction(int[] cont) {
        int[] res = new int[2];
        res[0] = cont[cont.length - 1];
        res[1] = 1;
        for (int i = cont.length - 1; i > 0; i--) {
            int temp = res[0];
            res[0] = cont[i - 1] * res[0] + res[1];
            res[1] = temp;
        }
        return res;

    }
}
