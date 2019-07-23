import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author maple on 2019/7/18 15:51.
 * @version v1.0
 * @see 1040441325@qq.com
 * 438. 找到字符串中所有字母异位词
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 * <p>
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 * <p>
 * 说明：
 * <p>
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 * 示例 1:
 * <p>
 * 输入:
 * s: "cbaebabacd" p: "abc"
 * <p>
 * 输出:
 * [0, 6]
 * <p>
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 *  示例 2:
 * <p>
 * 输入:
 * s: "abab" p: "ab"
 * <p>
 * 输出:
 * [0, 1, 2]
 * <p>
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        char[] sChar = s.toCharArray();
        char[] pChar = p.toCharArray();
        int[] curAToZ = new int[26];
        int[] aToZ = new int[26];
        for (char c : pChar) {
            aToZ[c - 'a']++;
        }
        for (int i = 0; i < sChar.length; i++) {
            if (i >= pChar.length) {
                curAToZ[sChar[i - pChar.length] - 'a']--;
            }
            curAToZ[sChar[i] - 'a']++;
            if (Arrays.equals(curAToZ, aToZ)) {
                result.add(i - pChar.length + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        new FindAnagrams().findAnagrams("SSSSSSSSSSSSSSSSSSSSSSSSSSSSS", "yqrbgjdwtcaxzsnifvhmou");
    }
}
