/**
 * @author maple on 2019/6/6 18:03.
 * @version v1.0
 * @see 1040441325@qq.com
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 *
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 *
 * 请找出在 t 中被添加的字母。
 *
 *
 *
 * 示例:
 *
 * 输入：
 * s = "abcd"
 * t = "abcde"
 *
 * 输出：
 * e
 *
 * 解释：
 * 'e' 是那个被添加的字母
 */
public class FindTheDifference {

    public char findTheDifference(String s, String t) {
        int[] cs = new int[26];
        for (char c : s.toCharArray()) {
            cs[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            if (cs[c-'a']<=0)return c;
            else cs[c-'a']--;
        }
        return '0';
    }
}
