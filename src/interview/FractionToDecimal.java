package interview;

import java.util.ArrayList;

/**
 * @author maple on 2019/3/7 10:26.
 * @version v1.0
 * @see 1040441325@qq.com
 * 分数到小数
 * 给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以字符串形式返回小数。
 * <p>
 * 如果小数部分为循环小数，则将循环的部分括在括号内。
 * <p>
 * 示例 1:
 * <p>
 * 输入: numerator = 1, denominator = 2
 * 输出: "0.5"
 * 示例 2:
 * <p>
 * 输入: numerator = 2, denominator = 1
 * 输出: "2"
 * 示例 3:
 * <p>
 * 输入: numerator = 2, denominator = 3
 * 输出: "0.(6)"
 */
public class FractionToDecimal {
    /**
     *
     * @param numerator 被除数
     * @param denominator 除数
     * @return 字符串
     * 注意点:
     *  1. 符号处理
     *  2. 符号处理引起的int类型值范围超上限
     *  3. 确定循环
     *
     */
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder builder = new StringBuilder();
        int sign = 1;
        long n = numerator;
        long d = denominator;
        if (numerator < 0) {
            n = -n;
            sign *= -1;
        }
        if (denominator < 0) {
            d = -d;
            sign *= -1;
        }
        if (sign == -1 && n != 0) builder.append('-');
        long t = n / d;
        long yu = n % d;
        builder.append(t);
        if (yu == 0) {
            return builder.toString();
        }
        builder.append('.');
        int start = builder.length();
        ArrayList<Long> yus = new ArrayList<>();
        yus.add(yu);
        while (yu != 0) {
            yu *= 10;
            long a = yu / d;
            yu = yu % d;
            if (yus.contains(yu)) {
                builder.insert(start + yus.indexOf(yu), '(');
                builder.append(a).append(')');
                return builder.toString();
            }
            yus.add(yu);

            builder.append(a);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new FractionToDecimal().fractionToDecimal(1, 6));
    }
}
