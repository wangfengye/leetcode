package interview;

/**
 * @author maple on 2019/3/5 17:10.
 * @version v1.0
 * @see 1040441325@qq.com
 * 两整数之和
 * 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
 *
 * 示例 1:
 *
 * 输入: a = 1, b = 2
 * 输出: 3
 * 示例 2:
 *
 * 输入: a = -2, b = 3
 * 输出: 1
 */
public class GetSum {
    public int getSum(int a, int b) {
        int sum,carry;
        do{
            sum = a^b;
            carry = (a&b)<<1;
            a = sum;
            b = carry;
        }while(carry!=0);
        return sum;
    }

    public static void main(String[] args){
        System.out.println(new GetSum().getSum(1,2));
    }
}
