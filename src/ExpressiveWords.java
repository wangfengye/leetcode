import javafx.beans.NamedArg;
import javafx.util.Pair;
import org.bouncycastle.util.Strings;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author maple on 2019/6/11 9:41.
 * @version v1.0
 * @see 1040441325@qq.com
 * 809. 情感丰富的文字
 * <p>
 * 有时候人们会用重复写一些字母来表示额外的感受，比如 "hello" -> "heeellooo", "hi" -> "hiii"。我们将相邻字母都相同的一串字符定义为相同字母组，例如："h", "eee", "ll", "ooo"。
 * <p>
 * 对于一个给定的字符串 S ，如果另一个单词能够通过将一些字母组扩张从而使其和 S 相同，我们将这个单词定义为可扩张的（stretchy）。扩张操作定义如下：选择一个字母组（包含字母 c ），然后往其中添加相同的字母 c 使其长度达到 3 或以上。
 * <p>
 * 例如，以 "hello" 为例，我们可以对字母组 "o" 扩张得到 "hellooo"，但是无法以同样的方法得到 "helloo" 因为字母组 "oo" 长度小于 3。此外，我们可以进行另一种扩张 "ll" -> "lllll" 以获得 "helllllooo"。如果 S = "helllllooo"，那么查询词 "hello" 是可扩张的，因为可以对它执行这两种扩张操作使得 query = "hello" -> "hellooo" -> "helllllooo" = S。
 * <p>
 * 输入一组查询单词，输出其中可扩张的单词数量。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：
 * S = "heeellooo"
 * words = ["hello", "hi", "helo"]
 * 输出：1
 * 解释：
 * 我们能通过扩张 "hello" 的 "e" 和 "o" 来得到 "heeellooo"。
 * 我们不能通过扩张 "helo" 来得到 "heeellooo" 因为 "ll" 的长度小于 3 。
 *  
 * <p>
 * 说明：
 * <p>
 * 0 <= len(S) <= 100。
 * 0 <= len(words) <= 100。
 * 0 <= len(words[i]) <= 100。
 * S 和所有在 words 中的单词都只由小写字母组成。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/expressive-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ExpressiveWords {
    public int expressiveWords(String S, String[] words) {
        int len = 0;
        ArrayList<Pair<Character, Integer>> base = s2p(S);
        for (String word : words) {
            if (equals(base, s2p(word))) len++;
        }
        return len;
    }

    private ArrayList<Pair<Character, Integer>> s2p(String s) {
        char c = s.charAt(0);
        int count = 1;
        ArrayList<Pair<Character, Integer>> list = new ArrayList<>();
        for (int i = 1; i < s.length(); i++) {
            char tmp = s.charAt(i);
            if (tmp == c) {
                count++;
            } else {
                list.add(new Pair<>(c, count));
                c = tmp;
                count = 1;
            }
        }
        list.add(new Pair<>(c, count));
        return list;
    }

    private boolean equals(ArrayList<Pair<Character, Integer>> a, ArrayList<Pair<Character, Integer>> b) {
        if (a.size() != b.size()) return false;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).getKey() != b.get(i).getKey()) return false;
            if (a.get(i).getValue() < 3 && a.get(i).getValue() - b.get(i).getValue() != 0) return false;
            if (a.get(i).getValue() >= 3 && a.get(i).getValue() - b.get(i).getValue() < 0) return false;
        }
        return true;
    }

    public int expressiveWords2(String S, String[] words) {
        int len = 0;

        for (String word : words) {
            if (expressive(S, word)) len++;
        }
        return len;
    }

    private boolean expressive(String a, String b) {
        if (a.length() < b.length()) return false;
        int j = 0;
        for (int i = 0; i < a.length(); i++) {
            if (j < b.length() && a.charAt(i) == b.charAt(j)) j++;
            else if (i > 1 && a.charAt(i) == a.charAt(i - 1) && a.charAt(i - 1) == a.charAt(i - 2)) ;
            else if (0 < i && i < a.length() - 1 && a.charAt(i - 1) == a.charAt(i) && a.charAt(i) == a.charAt(i + 1)) ;
            else return false;
        }
        return j == b.length();
    }


    public static void main(String[] args) {
        System.out.println(new ExpressiveWords().expressiveWords("heeellooo", new String[]{"hello", "hi", "helo"}));
        System.out.println(new ExpressiveWords().expressiveWords2("heeellooo", new String[]{"hello", "hi", "helo"}));
    }

    static class Pair<K, V> {
        private K key;

        public K getKey() {
            return key;
        }

        private V value;

        public V getValue() {
            return value;
        }

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
