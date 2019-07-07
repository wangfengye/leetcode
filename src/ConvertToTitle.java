/**
 * @author maple on 2019/7/7 19:17.
 * @version v1.0
 * @see 1040441325@qq.com
 * 168. Excel表列名称
 * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 * <p>
 * 例如，
 * <p>
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 * ...
 * 示例 1:
 * <p>
 * 输入: 1
 * 输出: "A"
 * 示例 2:
 * <p>
 * 输入: 28
 * 输出: "AB"
 * 示例 3:
 * <p>
 * 输入: 701
 * 输出: "ZY"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/excel-sheet-column-title
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ConvertToTitle {
    public String convertToTitle(int n) {
        StringBuilder builder = new StringBuilder();
        while (n > 0) {
            int tmp = n % 26;
            if (tmp == 0) {
                builder.insert(0, 'Z');
                n -= 26;
            } else {
                builder.insert(0, (char) ('A' + tmp - 1));
            }
            n /= 26;

        }
        return builder.toString();
    }
}
