import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author maple on 2019/6/3 11:38.
 * @version v1.0
 * @see 1040441325@qq.com
 * <p>
 * 1002. 查找常用字符
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 * <p>
 * 你可以按任意顺序返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 * 示例 2：
 * <p>
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 * A[i][j] 是小写字母
 */
public class CommonChars {
    public static List<String> commonChars(String[] A) {
        List<String> data = new ArrayList<>();
        String fir = A[0];
        char[] cs = fir.toCharArray();
        Arrays.sort(cs);
        for (char c : cs) {
            data.add(Character.toString(c));
        }
        for (int i = 1; i < A.length; i++) {
            fir = A[i];
            cs = fir.toCharArray();
            Arrays.sort(cs);
            int id = 0;
            Iterator<String> it = data.iterator();
            String s = it.hasNext() ? it.next() : null;
            while (id < cs.length && (it.hasNext() || s != null)) {
                if (cs[id] == s.charAt(0)) {
                    s = it.hasNext() ? it.next() : null;
                    id++;
                } else if (cs[id] > s.charAt(0)) {
                    it.remove();
                    s = it.hasNext() ? it.next() : null;
                } else {
                    id++;
                }
            }
            if (s != null) it.remove();
            while (it.hasNext()) {
                it.next();
                it.remove();
            }
        }
        return data;
    }

    public static List<String> commonChars2(String[] A) {
        int[] res = new int[26];
        for (char c : A[0].toCharArray()) {
            res[c - 'a']++;
        }
        int[] tmpList = new int[26];
        for (int i = 1; i < A.length; i++) {
            Arrays.fill(tmpList, 0);
            for (char c : A[i].toCharArray()) {
                tmpList[c - 'a']++;
            }
            for (int j = 0; j < 26; j++) {
                if (tmpList[j] < res[j]) res[j] = tmpList[j];
            }
        }
        ArrayList<String> resList = new ArrayList<>();
        int tmp;
        for (int i = 0; i < res.length; i++) {
            tmp = res[i];
            while (tmp > 0) {
                tmp--;
                resList.add(String.valueOf((char) ('a' + i)));
            }
        }
        return resList;
    }

    public static void main(String[] args) {
        commonChars2(new String[]{"bella", "label", "roller"});
        commonChars2(new String[]{"cool", "lock", "cook"});
        commonChars2(new String[]{"daaccccd", "adacbdda", "abddbaba", "bacbcbcb", "bdaaaddc", "cdadacba", "bacbdcda", "bacdaacd"});
    }
}
