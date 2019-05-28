/**
 * @author maple on 2019/5/28 10:17.
 * @version v1.0
 * @see 1040441325@qq.com
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * <p>
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * <p>
 * 示例 1:
 * <p>
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 说明:
 * <p>
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1
 */
public class Divide {
    public static int divide(int dividend, int divisor) {
        if (dividend==Integer.MIN_VALUE && divisor==-1)
            return Integer.MAX_VALUE;
        long d1=dividend;
        long d2=divisor;
        int mod=0;
        if (d1<0){d1=-d1;mod++;}
        if (d2<0){d2=-d2;mod++;}
        if (mod==1)mod=-1;
        else mod=1;
        int res = 0;
        int resCount =1;
        long d2Tmp = d2;
        while (d1 >d2) {
            d1 -= d2Tmp;
            res += resCount;
            d2Tmp+=d2Tmp;
            resCount+=resCount;
            if (d1<d2Tmp){
                d2Tmp=d2;
                resCount=1;
            }
        }
        return mod>0?res:-res;
    }

    public static void main(String[] args) {
        System.out.println(divide(10, 3));
        System.out.println(divide(7, -3));
        System.out.println(divide(1, 1));
        System.out.println(divide(-2147483648, 1));
        System.out.println(divide(-2147483648, -1));

    }
}
