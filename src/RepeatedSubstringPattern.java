/**
 * @author maple on 2019/6/3 14:27.
 * @version v1.0
 * @see 1040441325@qq.com
 * 459. 重复的子字符串
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abab"
 * <p>
 * 输出: True
 * <p>
 * 解释: 可由子字符串 "ab" 重复两次构成。
 * 示例 2:
 * <p>
 * 输入: "aba"
 * <p>
 * 输出: False
 * 示例 3:
 * <p>
 * 输入: "abcabcabcabc"
 * <p>
 * 输出: True
 * <p>
 * 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
 */
public class RepeatedSubstringPattern {
    public static boolean repeatedSubstringPattern(String s) {
        for (int i = 1; i <= s.length() / 2; i++) {
            if (s.charAt(0) == s.charAt(i)) {
                if (isContract(s, i)) return true;
            }
        }
        return false;
    }

    private static boolean isContract(String s, int i) {
        int tmp = 2 * i;
        while (tmp <= s.length()) {
            if (!s.substring(0, i).equals(s.substring(tmp - i, tmp))) return false;
            tmp += i;
        }

        return tmp-i==s.length();
    }

    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("abab"));
        System.out.println(repeatedSubstringPattern("aba"));
        System.out.println(repeatedSubstringPattern("abcabcabcabc"));
        System.out.println(repeatedSubstringPattern("aabaaba"));
    }
}
