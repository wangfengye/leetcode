import java.util.Arrays;

/**
 * 1170. 比较字符串最小字母出现频次
 * 我们来定义一个函数 f(s)，其中传入参数 s 是一个非空字符串；该函数的功能是统计 s  中（按字典序比较）最小字母的出现频次。
 * <p>
 * 例如，若 s = "dcce"，那么 f(s) = 2，因为最小的字母是 "c"，它出现了 2 次。
 * <p>
 * 现在，给你两个字符串数组待查表 queries 和词汇表 words，请你返回一个整数数组 answer 作为答案，其中每个 answer[i] 是满足 f(queries[i]) < f(W) 的词的数目，W 是词汇表 words 中的词。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：queries = ["cbd"], words = ["zaaaz"]
 * 输出：[1]
 * 解释：查询 f("cbd") = 1，而 f("zaaaz") = 3 所以 f("cbd") < f("zaaaz")。
 * 示例 2：
 * <p>
 * 输入：queries = ["bbb","cc"], words = ["a","aa","aaa","aaaa"]
 * 输出：[1,2]
 * 解释：第一个查询 f("bbb") < f("aaaa")，第二个查询 f("aaa") 和 f("aaaa") 都 > f("cc")。
 */
public class NumSmallerByFrequency {
    public static int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] qus = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            qus[i] = countMin(queries[i]);
        }
        int[] ws = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            ws[i] = countMin(words[i]);
        }
        int[] answers = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int count = qus[i];

            for (int j = 0; j < words.length; j++) {
                if (count < ws[j]) answers[i]++;
            }
        }
        return answers;
    }

    private static int countMin(String s) {
        if (s.length() == 0) return 0;
        char tag = s.charAt(0);
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == tag) count++;
            else if (c < tag) {
                count = 1;
                tag = c;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] res = numSmallerByFrequency(new String[]{"bba", "abaaaaaa", "aaaaaa", "bbabbabaab", "aba", "aa", "baab", "bbbbbb", "aab", "bbabbaabb"}, new String[]{
                "aaabbb", "aab", "babbab", "babbbb", "b", "bbbbbbbbab", "a", "bbbbbbbbbb", "baaabbaab", "aa"});
        System.out.println(Arrays.toString(res));
    }
}
