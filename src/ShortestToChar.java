import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author maple on 2019/6/3 9:31.
 * @version v1.0
 * @see 1040441325@qq.com
 * 821. 字符的最短距离
 * <p>
 * 给定一个字符串 S 和一个字符 C。返回一个代表字符串 S 中每个字符到字符串 S 中的字符 C 的最短距离的数组。
 * <p>
 * 示例 1:
 * <p>
 * 输入: S = "loveleetcode", C = 'e'
 * 输出: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
 * 说明:
 * <p>
 * 字符串 S 的长度范围为 [1, 10000]。
 * C 是一个单字符，且保证是字符串 S 里的字符。
 * S 和 C 中的所有字母均为小写字母。
 */
public class ShortestToChar {
    public static int[] shortestToChar(String S, char C) {
        ArrayList<Integer> tmp = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == C) {
                tmp.add(i);
            }
        }
        int res[] = new int[S.length()];
        if (tmp.size() == 0) return res;
        int t = tmp.get(0);
        int c = 0;
        while (t >= 0) {
            res[t] = c;
            t--;
            c++;
        }
        for (int i = 1; i < tmp.size(); i++) {
            int l = tmp.get(i - 1);
            int r = tmp.get(i);
            int id = r;
            while (id > l) {
                res[id] = Math.min(r - id, id - l);
                id--;
            }
        }
        t = tmp.get(tmp.size() - 1) + 1;
        c = 1;
        while (t < res.length) {
            res[t] = c;
            c++;
            t++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(shortestToChar("loveleetcode", 'e')));
    }
}
