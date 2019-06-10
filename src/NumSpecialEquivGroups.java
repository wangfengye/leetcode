import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author maple on 2019/6/10 10:54.
 * @version v1.0
 * @see 1040441325@qq.com
 * 893. 特殊等价字符串组
 * 你将得到一个字符串数组 A。
 * <p>
 * 如果经过任意次数的移动，S == T，那么两个字符串 S 和 T 是特殊等价的。
 * <p>
 * 一次移动包括选择两个索引 i 和 j，且 i ％ 2 == j ％ 2，交换 S[j] 和 S [i]。
 * <p>
 * 现在规定，A 中的特殊等价字符串组是 A 的非空子集 S，这样不在 S 中的任何字符串与 S 中的任何字符串都不是特殊等价的。
 * <p>
 * 返回 A 中特殊等价字符串组的数量。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：["a","b","c","a","c","c"]
 * 输出：3
 * 解释：3 组 ["a","a"]，["b"]，["c","c","c"]
 * 示例 2：
 * <p>
 * 输入：["aa","bb","ab","ba"]
 * 输出：4
 * 解释：4 组 ["aa"]，["bb"]，["ab"]，["ba"]
 * 示例 3：
 * <p>
 * 输入：["abc","acb","bac","bca","cab","cba"]
 * 输出：3
 * 解释：3 组 ["abc","cba"]，["acb","bca"]，["bac","cab"]
 * 示例 4：
 * <p>
 * 输入：["abcd","cdab","adcb","cbad"]
 * 输出：1
 * 解释：1 组 ["abcd","cdab","adcb","cbad"]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/groups-of-special-equivalent-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumSpecialEquivGroups {
    public int numSpecialEquivGroups(String[] A) {//同组判定,奇数位置相同,偶数位置,结果相同
        HashSet<String> map = new HashSet<>();
        StringBuilder builder = new StringBuilder();
        for (String a : A) {
            builder.setLength(0);
            char[] cs2 = new char[(a.length() + 1) / 2];
            char[] cs1 = new char[a.length() / 2];
            for (int i = 0; i < a.length(); i++) {
                if (i % 2 == 0) cs2[i / 2] = a.charAt(i);
                else cs1[i / 2] = a.charAt(i);
            }
            Arrays.sort(cs1);
            Arrays.sort(cs2);
            builder.append(cs1).append(cs2);
            map.add(builder.toString());
        }
        return map.size();
    }

    public static void main(String[] a) {
        new NumSpecialEquivGroups().numSpecialEquivGroups(new String[]{"abcd", "cdab", "cbad", "xyzz", "zzxy", "zzyx"});
        new NumSpecialEquivGroups().numSpecialEquivGroups(new String[]{"a", "b", "c", "a", "c", "c"});
    }
}
