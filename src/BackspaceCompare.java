import java.util.Stack;

/**
 * @author maple on 2019/11/30 11:32.
 * @version v1.0
 * @see 1040441325@qq.com
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 * 示例 2：
 * <p>
 * 输入：S = "ab##", T = "c#d#"
 * 输出：true
 * 解释：S 和 T 都会变成 “”。
 * 示例 3：
 * <p>
 * 输入：S = "a##c", T = "#a#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “c”。
 * 示例 4：
 * <p>
 * 输入：S = "a#c", T = "b"
 * 输出：false
 * 解释：S 会变成 “c”，但 T 仍然是 “b”。
 */
public class BackspaceCompare {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> s = str2Stack(S);
        Stack<Character> t = str2Stack(T);
        while (s.size() > 0 && t.size() > 0) {
            if (s.pop() != t.pop()) return false;
        }
        return s.size() == 0 && t.size() == 0;
    }

    private Stack<Character> str2Stack(String S) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c != '#') {
                s.push(c);
            } else {
                if (s.size() > 0) s.pop();
            }
        }
        return s;
    }
}
