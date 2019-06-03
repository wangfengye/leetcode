import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.List;

/**
 * @author maple on 2019/6/3 9:54.
 * @version v1.0
 * @see 1040441325@qq.com
 * 784. 字母大小写全排列
 * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
 * <p>
 * 示例:
 * 输入: S = "a1b2"
 * 输出: ["a1b2", "a1B2", "A1b2", "A1B2"]
 * <p>
 * 输入: S = "3z4"
 * 输出: ["3z4", "3Z4"]
 * <p>
 * 输入: S = "12345"
 * 输出: ["12345"]
 * 注意：
 * <p>
 * S 的长度不超过12。
 * S 仅由数字和字母组成。
 */
public class LetterCasePermutation {
    public static List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        add(S, 0, res);
        return res;
    }

    private static void add(String s, int i, List<String> res) {
        while (i < s.length()) {
            char tmp = s.charAt(i);
            i++;
            if ('a' <= tmp && tmp <= 'z') {
                add(s, i, res);
                StringBuilder strBuilder = new StringBuilder(s);
                strBuilder.setCharAt(i - 1, (char) (tmp - 32));
                add(strBuilder.toString(), i, res);
                return;
            } else if ('A' <= tmp && tmp <= 'Z') {
                StringBuilder strBuilder = new StringBuilder(s);
                strBuilder.setCharAt(i - 1, (char) (tmp + 32));
                add(strBuilder.toString(), i, res);
                add(s, i, res);
                return;
            }
        }
        res.add(s);
    }

    public static void main(String[] args) {
      /*  letterCasePermutation("a1b2");
        letterCasePermutation("3z4");
        letterCasePermutation("12345");*/
        letterCasePermutation("RmR");

    }
}
