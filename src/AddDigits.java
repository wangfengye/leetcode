/**
 * @author maple on 2019/6/6 9:00.
 * @version v1.0
 * @see 1040441325@qq.com
 * 258. 各位相加
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
 * <p>
 * 示例:
 * <p>
 * 输入: 38
 * 输出: 2
 * 解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
 */
public class AddDigits {
    public int addDigits(int num) {
        int tmp = 0;
        do {
            tmp = 0;
            while (num > 0) {
                tmp += num % 10;
                num /= 10;
            }
            num = tmp;
        } while (tmp >= 10);
        return tmp;
    }

    //n= 100a+10b+c;  n1 = a+b+c;  a+b+c = 100a+10b+c -99a-9b;
    //n=10a+b  n1 =a+b+c n1= 10a+b-9a;
    //以上可得,差值为9的倍数,即对num取9的余数,余数为0时是9
    public int addDigits2(int num) {
        while (num > 9) {
            num = num % 9;
            if (num == 0) return 9;
        }
        return num;
    }

    public static void main(String[] atg) {
        System.out.println(new AddDigits().addDigits2(38));
    }
}
