import org.bouncycastle.util.Integers;

/**
 * @author maple on 2019/6/5 11:09.
 * @version v1.0
 * @see 1040441325@qq.com
 * 91. 解码方法
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2:
 * <p>
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 */
public class NumDecodings {
    public int numDecodings(String s) {//超时
        return bfs(s, 0, 1) + bfs(s, 0, 2);
    }

    private int bfs(String s, int id, int len) {
        if (id + len > s.length()) return 0;
        int tmp = Integer.parseInt(s.substring(id, id + len));
        if (len == 1 && tmp <= 0) return 0;
        if (len == 2 && (tmp < 10 || tmp > 26)) return 0;
        if (id + len == s.length()) return 1;
        return bfs(s, id + len, 1) + bfs(s, id + len, 2);
    }

    public int num(String s) {//动态规划
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        for (int i = 1; i < s.length() + 1; i++) {
            char c = s.charAt(i - 1);
            if (c != '0') dp[i] += dp[i - 1];
            if (i > 1) {
                int num = (s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0';
                if (num == 0) return 0;
                if (num > 9 && num < 27) dp[i] += dp[i - 2];
            }
        }
        return s.length() == 0 ? 0 : dp[s.length()];
    }

    public static void main(String[] args) {
        System.out.println(new NumDecodings().numDecodings("226"));
        System.out.println(new NumDecodings().numDecodings("12"));
    }
}
