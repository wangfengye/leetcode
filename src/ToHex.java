/**
 * @author maple on 2019/7/17 10:20.
 * @version v1.0
 * @see 1040441325@qq.com
 * 405. 数字转换为十六进制数
 * 给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用 补码运算 方法。
 * <p>
 * 注意:
 * <p>
 * 十六进制中所有字母(a-f)都必须是小写。
 * 十六进制字符串中不能包含多余的前导零。如果要转化的数为0，那么以单个字符'0'来表示；对于其他情况，十六进制字符串中的第一个字符将不会是0字符。 
 * 给定的数确保在32位有符号整数范围内。
 * 不能使用任何由库提供的将数字直接转换或格式化为十六进制的方法。
 * 示例 1：
 * <p>
 * 输入:
 * 26
 * <p>
 * 输出:
 * "1a"
 * 示例 2：
 * <p>
 * 输入:
 * -1
 * <p>
 * 输出:
 * "ffffffff"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-a-number-to-hexadecimal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ToHex {
    public static String toHex(int num) {
        StringBuilder builder = new StringBuilder();
        if (num == 0)
            return "0";

        while (num != 0 && builder.length() < 8) {
            int tmp = num & 0xf;
            builder.insert(0,tmp<10?(char)('0'+tmp):(char)('a'+tmp-10));
            num >>= 4;
        }


        return builder.toString();

    }

    public static void main(String[] args) {
        byte a= (byte) 0xa5;
        for (int i = 0; i < 8; i++) {
            System.out.print(((a>>(7-i))&1));
        }
        System.out.println("");
        System.out.println(toHex(26));
        System.out.println(toHex(-1));
        System.out.println(((1) ^ 0xffffffff) + 1);
    }
}
