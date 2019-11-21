/**
 * @author maple on 2019/11/21 10:19.
 * @version v1.0
 * @see 1040441325@qq.com
 * 97. 交错字符串
 * 给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * 输出: false
 */
public class IsInterleave {
    // 暴力列举,超时
    public static boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        StringBuilder builder = new StringBuilder();
        return isInterleave(s1, s2, s3, 0, 0, builder);
    }

    private static boolean isInterleave(String s1, String s2, String s3, int i1, int i2, StringBuilder builder) {
        if (i1 == s1.length() && i2 == s2.length()) {
            return builder.toString().equals(s3);

        }
        if (i1 < s1.length()) {
            builder.append(s1.charAt(i1));
            if (builder.toString().equals(s3.substring(0, i1 + i2 + 1))) {
                boolean res = isInterleave(s1, s2, s3, i1 + 1, i2, builder);
                if (res) return true;
            }
            builder.setLength(builder.length() - 1);
        }
        if (i2 < s2.length()) {
            builder.append(s2.charAt(i2));
            if (builder.toString().equals(s3.substring(0, i1 + i2 + 1))) {
                boolean res = isInterleave(s1, s2, s3, i1, i2 + 1, builder);
                if (res) return true;
            }
            builder.setLength(builder.length() - 1);

        }
        return false;
    }

    /**
     * 动态规划
     * 核心思想: s1 和 s2 的某个前缀是否能形成 s3s3 的一个前缀
     * 二元动态规划,
     * 由于每一层的值止于上一层和当前层的上一个值有关,可以不断复用同一个一位数组
     * 最终只用一个一位数组保存动态规划结果.
     */
    public static boolean isInterleave1(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        boolean dp[] =new boolean[s2.length()+1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i==0&&j==0){
                    dp[i]=true;
                }else if (i==0){
                    dp[j]=dp[j-1]&&s2.charAt(j-1)==s3.charAt(i+j-1);
                }else if (j==0){
                    dp[j]=dp[j]&&s1.charAt(i-1)==s3.charAt(i+j-1);
                }else {
                    dp[j]=(dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }
            }
        }
        return dp[s2.length()];
    }

    public static void main(String[] args) {
        System.out.println(isInterleave1("aabcc", "dbbca", "aadbbcbcac"));
         System.out.println(isInterleave1("aabcc", "dbbca", "aadbbbaccc"));
         System.out.println(isInterleave1("bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa",
                 "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab",
                 "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab"));
    }
}
