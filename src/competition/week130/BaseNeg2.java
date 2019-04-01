package competition.week130;

/**
 * @author maple on 2019/4/1 9:10.
 * @version v1.0
 * @see 1040441325@qq.com
 * 负二进制转换
 * 用户通过次数 156
 * 用户尝试次数 227
 * 通过次数 158
 * 提交次数 435
 * 题目难度 Medium
 * 给出数字 N，返回由若干 "0" 和 "1"组成的字符串，该字符串为 N 的负二进制（base -2）表示。
 * <p>
 * 除非字符串就是 "0"，否则返回的字符串中不能含有前导零
 */
public class BaseNeg2 {
    public static String baseNeg2(int N) {
        if (N == 0) return "0";
        long base = 1;
        StringBuilder builder = new StringBuilder();
        while (N != 0) {
            if (N % 2 == 0) {
                builder.append(0);
            } else {
                builder.append(1);
                N -= base;
            }
            N /= 2;
            base *= -1;
        }
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(baseNeg2(3));
    }
}
