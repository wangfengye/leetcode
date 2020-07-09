import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 面试题 17.13. 恢复空格
 * 哦，不！你不小心把一个长篇文章中的空格、标点都删掉了，并且大写也弄成了小写。像句子"I reset the computer. It still didn’t boot!"已经变成了"iresetthecomputeritstilldidntboot"。在处理标点符号和大小写之前，你得先把它断成词语。当然了，你有一本厚厚的词典dictionary，不过，有些词没在词典里。假设文章用sentence表示，设计一个算法，把文章断开，要求未识别的字符最少，返回未识别的字符数。
 * <p>
 * 注意：本题相对原题稍作改动，只需返回未识别的字符数
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：
 * dictionary = ["looked","just","like","her","brother"]
 * sentence = "jesslookedjustliketimherbrother"
 * 输出： 7
 * 解释： 断句后为"jess looked just like tim her brother"，共7个未识别字符。
 * 提示：
 * <p>
 * 0 <= len(sentence) <= 1000
 * dictionary中总字符数不超过 150000。
 * 你可以认为dictionary和sentence中只包含小写字母。
 */
public class Respace {
    public static void main(String[] args) {
        respace(new String[]{"looked", "just", "like", "her", "brother"},
                "jesslookedjustliketimherbrother");
    }

    public static int respace(String[] dictionary, String sentence) {
        Trie t = new Trie();
        //构造字典树
        for (String word : dictionary) {
            t.insert(word);
        }
        //动态规划.
        int[] dp = new int[sentence.length() + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;//0个未识别字符.
        for (int i = 1; i <= sentence.length(); i++) {
            dp[i] = dp[i - 1] + 1;//长度加1,未识别长度+1;
            Trie cur = t;
            for (int j = i; j >= 1; j--) {//循环招单词.
                int id = sentence.charAt(j - 1) - 'a';
                if (cur.next[id] == null) {//不可识别,退出
                    break;
                } else if (cur.next[id].isEnd) {//找的一个单词,未识别字符=单词前面一个字符位置时的未识别
                    dp[i] = Math.min(dp[i], dp[j - 1]);

                }
                if (dp[i] == 0) {//已经没了,没必要继续遍历.
                    break;
                }
                cur = cur.next[id];
            }

        }
        return dp[sentence.length()];
    }

    /**
     * 字典树
     */
    private static class Trie {
        Trie[] next;
        boolean isEnd;

        public Trie() {
            next = new Trie[26];
        }

        public void insert(String s) {
            Trie cur = this;
            for (int i = s.length() - 1; i >= 0; i--) {
                int t = s.charAt(i) - 'a';
                if (cur.next[t] == null) {
                    cur.next[t] = new Trie();
                }
                cur = cur.next[t];
            }
            cur.isEnd = true;
        }
    }


}
