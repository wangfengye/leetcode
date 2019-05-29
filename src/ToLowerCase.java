/**
 * @author maple on 2019/5/29 10:04.
 * @version v1.0
 * @see 1040441325@qq.com
 * 实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输入: "Hello"
 * 输出: "hello"
 * 示例 2：
 *
 * 输入: "here"
 * 输出: "here"
 * 示例 3：
 *
 * 输入: "LOVELY"
 * 输出: "lovely"
 */
public class ToLowerCase {
    public String toLowerCase(String str) {
        int diff = 'a' - 'A';
        StringBuilder builder = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c >= 'A' && c <= 'Z') c = (char) (diff + c);
            builder.append(c);
        }
        return builder.toString();
    }
}
