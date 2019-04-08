package competition.week131;

/**
 * @author maple on 2019/4/7 15:37.
 * @version v1.0
 * @see 1040441325@qq.com
 * 016. 删除最外层的括号  显示英文描述
 * 用户通过次数 446
 * 用户尝试次数 469
 * 通过次数 456
 * 提交次数 577
 * 题目难度 Easy
 * 有效括号字符串为空 ("")、"(" + A + ")" 或 A + B，其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。例如，""，"()"，"(())()" 和 "(()(()))" 都是有效的括号字符串。
 * <p>
 * 如果有效字符串 S 非空，且不存在将其拆分为 S = A+B 的方法，我们称其为原语（primitive），其中 A 和 B 都是非空有效括号字符串。
 * <p>
 * 给出一个非空有效字符串 S，考虑将其进行原语化分解，使得：S = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。
 * <p>
 * 对 S 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 S 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入："(()())(())"
 * 输出："()()()"
 * 解释：
 * 输入字符串为 "(()())(())"，原语化分解得到 "(()())" + "(())"，
 * 删除每个部分中的最外层括号后得到 "()()" + "()" = "()()()"。
 * 示例 2：
 * <p>
 * 输入："(()())(())(()(()))"
 * 输出："()()()()(())"
 * 解释：
 * 输入字符串为 "(()())(())(()(()))"，原语化分解得到 "(()())" + "(())" + "(()(()))"，
 * 删除每隔部分中的最外层括号后得到 "()()" + "()" + "()(())" = "()()()()(())"。
 * 示例 3：
 * <p>
 * 输入："()()"
 * 输出：""
 * 解释：
 * 输入字符串为 "()()"，原语化分解得到 "()" + "()"，
 * 删除每个部分中的最外层括号后得到 "" + "" = ""。
 */
public class RemoveOuterParentheses {
    public static String removeOuterParentheses(String S) {
        int i = 0;
        int countLeft = 1;
        StringBuilder builder = new StringBuilder(S);
        builder.deleteCharAt(0);
        while (i < builder.length()) {
            char tmp = builder.charAt(i);
            if (tmp == '(') {
                countLeft++;
                i++;
            } else {
                if (countLeft == 1) {
                    builder.deleteCharAt(i);
                    if (i>=builder.length())return builder.toString();
                    builder.deleteCharAt(i);
                } else {
                    countLeft--;
                    i++;
                }
            }
        }
        return builder.toString();
    }
    public static void main(String[] args){
        System.out.println(removeOuterParentheses("(()())(())"));
    }
}
