/**
 * @author maple on 2019/5/29 15:10.
 * @version v1.0
 * @see 1040441325@qq.com
 * 数字的补数
 * 给定一个正整数，输出它的补数。补数是对该数的二进制表示取反。
 * <p>
 * 注意:
 * <p>
 * 给定的整数保证在32位带符号整数的范围内。
 * 你可以假定二进制数不包含前导零位。
 * 示例 1:
 * <p>
 * 输入: 5
 * 输出: 2
 * 解释: 5的二进制表示为101（没有前导零位），其补数为010。所以你需要输出2。
 * 示例 2:
 * <p>
 * 输入: 1
 * 输出: 0
 * 解释: 1的二进制表示为1（没有前导零位），其补数为0。所以你需要输出0。
 */
public class FindComplement {
    public static int findComplement(int num) {
        if (num == 0) return 1;
        int res = 0;
        int base = 1;
        while (num > 0) {
            res += (num & 1 ^ 1) * base;
            num = num >> 1;
            base *= 2;
        }
        return res;
    }
    public static void main(String[] args){
        System.out.println(Integer.toBinaryString(findComplement(5)));
        System.out.println(Integer.toBinaryString(findComplement(1)));
        System.out.println(Integer.toBinaryString(findComplement(0)));
    }
}
