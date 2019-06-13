import interview.LongestIncreasingPath;

import java.util.HashMap;
import java.util.Map;

/**
 * @author maple on 2019/6/13 9:37.
 * @version v1.0
 * @see 1040441325@qq.com
 * 409. 最长回文串
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * <p>
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 * <p>
 * 注意:
 * 假设字符串的长度不会超过 1010。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * "abccccdd"
 * <p>
 * 输出:
 * 7
 * <p>
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int sum = 0;
        boolean hasOdd = false;
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            if (e.getValue() % 2 == 0) sum += e.getValue();
            else {
                hasOdd = true;
                sum += (e.getValue() - 1);
            }
        }
        if (hasOdd) sum += 1;
        return sum;
    }

    public int longestPalindrome2(String s) {
        int[] map = new int['z' - 'A' + 1];
        for (char c : s.toCharArray()) {
            map[c - 'A'] += 1;
        }
        int sum = 0;
        boolean hasOdd = false;
        for (int i = 0; i < 'z' - 'A' + 1; i++) {
            if (map[i] % 2 == 0) sum += map[i];
            else {
                hasOdd = true;
                sum += (map[i] - 1);
            }
        }
        if (hasOdd) sum += 1;
        return sum;
    }

    public static void main(String[] a) {
        new LongestPalindrome().longestPalindrome("abccccdd");
    }
}
