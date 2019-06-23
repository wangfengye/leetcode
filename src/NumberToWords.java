/**
 * @author maple on 2019/6/23 15:19.
 * @version v1.0
 * @see 1040441325@qq.com
 * 273. 整数转换英文表示
 * 将非负整数转换为其对应的英文表示。可以保证给定输入小于 231 - 1 。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: "One Hundred Twenty Three"
 * 示例 2:
 * <p>
 * 输入: 12345
 * 输出: "Twelve Thousand Three Hundred Forty Five"
 * 示例 3:
 * <p>
 * 输入: 1234567
 * 输出: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 * 示例 4:
 * <p>
 * 输入: 1234567891
 * 输出: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-to-english-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumberToWords {
    private static final String tmp19[] = {"One ", "Two ", "Three ", "Four ", "Five ", "Six ",
            "Seven ", "Eight ", "Nine ", "Ten ", "Eleven ", "Twelve ",
            "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ",
            "Eighteen ", "Nineteen "};
    private static final String tmp90[] = {"Twenty ", "Thirty ", "Forty ", "Fifty ",
            "Sixty ", "Seventy ", "Eighty ", "Ninety "};
    private static final String types[] = {"Thousand ", "Million ", "Billion "};

    private static final int base = 1000;

    public static String numberToWords(int num) {
        if (num == 0) return "Zero";

        StringBuilder ress = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            StringBuilder res = new StringBuilder();
            if (num <= 0) break;
            int tmp = num % base;
            num /= 1000;
            int h = tmp / 100;
            if (h > 0) {
                res.append(tmp19[h - 1]).append("Hundred ");
                tmp = tmp - (h * 100);
            }
            int h1 = tmp / 10;
            if (h1 > 1) {
                res.append(tmp90[h1 - 2]);
                tmp = tmp - (h1 * 10);
            }
            if (tmp > 0) res.append(tmp19[tmp - 1]);
            if (i != 0&& res.length()>0) {//这三位数>0才需要加后缀
                res.append(types[i - 1]);
            }
            ress.insert(0,res);
        }
        ress.setLength(ress.length() - 1);
        return ress.toString();
    }

    public static void main(String[] args) {
        System.out.println(numberToWords(123));
        System.out.println(numberToWords(12345));
        System.out.println(numberToWords(1234567));
        System.out.println(numberToWords(1234567891));
        System.out.println(numberToWords(1000000));
    }
}
