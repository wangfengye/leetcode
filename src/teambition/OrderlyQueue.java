package teambition;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author maple on 2019/2/26 11:39.
 * @version v1.0
 * @see 1040441325@qq.com
 * 给出了一个由小写字母组成的字符串 S。然后，我们可以进行任意次数的移动。
 * <p>
 * 在每次移动中，我们选择前 K 个字母中的一个（从左侧开始），将其从原位置移除，并放置在字符串的末尾。
 * <p>
 * 返回我们在任意次数的移动之后可以拥有的按字典顺序排列的最小字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：S = "cba", K = 1
 * 输出："acb"
 * 解释：
 * 在第一步中，我们将第一个字符（“c”）移动到最后，获得字符串 “bac”。
 * 在第二步中，我们将第一个字符（“b”）移动到最后，获得最终结果 “acb”。
 * 示例 2：
 * <p>
 * 输入：S = "baaca", K = 3
 * 输出："aaabc"
 * 解释：
 * 在第一步中，我们将第一个字符（“b”）移动到最后，获得字符串 “aacab”。
 * 在第二步中，我们将第三个字符（“c”）移动到最后，获得最终结果 “aaabc”。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= K <= S.length <= 1000
 * S 只由小写字母组成。
 */
public class OrderlyQueue {
    public String orderlyQueue(String S, int K) {
        if (K > 1) {//可任意排列
            int[] chars = new int[26];
            for (char c : S.toCharArray()) {
                chars[c - 'a']++;
            }
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < chars.length; i++) {
                for (int j = 0; j < chars[i]; j++) {
                    builder.append((char) ('a' + i));
                }
            }
            return builder.toString();
        } else {
            ArrayList<Integer> integers = new ArrayList<>();
            for (int i = 0; i < 26; i++) {
                int id = S.indexOf('a' + i);
                while (id != -1) {
                    integers.add(id);
                    id = S.indexOf('a' + i, id + 1);
                }
                if (integers.size() > 0) break;
            }
            String res = S;
            for (int i = 0; i < integers.size(); i++) {
                String tmp = S.substring(integers.get(i)) + S.substring(0, integers.get(i));
                if (compare(res,tmp)) res = tmp;
            }
            return res;
        }
    }
    /**
     *
     * @param s 源
     * @param t 目标
     * @return 是否比目标大 相等返回false
     */
    public boolean compare(String s,String t){
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)>t.charAt(i))return true;
            if (s.charAt(i)<t.charAt(i))return false;
        }
        return false;
    }

    public static void main(String[] args) {
        new OrderlyQueue().orderlyQueue("mwgiweo", 1);
    }
}
