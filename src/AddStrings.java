/**
 * @author maple on 2019/6/3 17:02.
 * @version v1.0
 * @see 1040441325@qq.com
 * 415. 字符串相加
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 * <p>
 * 注意：
 * <p>
 * num1 和num2 的长度都小于 5100.
 * num1 和num2 都只包含数字 0-9.
 * num1 和num2 都不包含任何前导零。
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
 */
public class AddStrings {
    public String addStrings(String num1, String num2) {
        int id1 = num1.length() - 1;
        int id2 = num2.length() - 1;
        int tmp = 0;
        StringBuilder builder = new StringBuilder();
        while (id1 >= 0 || id2 >= 0) {
            int sum = (id1 < 0 ? '0' : num1.charAt(id1)) + (id2 < 0 ?'0' : num2.charAt(id2)) - '0' - '0' + tmp;
            tmp = sum / 10;
            builder.insert(0, sum % 10);
            id1--;
            id2--;
        }
        if (tmp > 0) builder.insert(0, tmp);
        if (builder.length() == 0) builder.append(0);
        return builder.toString();
    }

    public static void main(String[] args) {
      new AddStrings().addStrings("98","9");
    }
}
