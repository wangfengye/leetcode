package interview;

import java.util.ArrayList;
import java.util.List;

/**
 * @author maple on 2019/3/4 18:02.
 * @version v1.0
 * @see 1040441325@qq.com
 * 单词拆分 II
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 * <p>
 * 说明：
 * <p>
 * 分隔时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单
 */
public class WordBreak2 {
    int maxWordLen = 0;
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean[] dp = new boolean[s.length() + 1];//dp[i]记录 0-i 之间是否由单词组成;
        dp[0] = true;

        for (String word : wordDict) {
            if (word.length() > maxWordLen) maxWordLen = word.length();
        }
        for (int i = 0; i < s.length(); i++) {     // 从一个字符开始判断是否可由单词组成,依次扩大长度
            if (dp[i]) {
                for (int j = i + 1; j <= s.length() && i + maxWordLen >= j; ++j)// i + maxWordLen >= j 只向后检测一个单词
                    if (wordDict.contains(s.substring(i, j))) dp[j] = true;
            }
        }
        if (!dp[s.length()]) return res;

        dfs(s, wordDict, dp, sb, res, 0);
        return res;
    }

    private void dfs(String s, List<String> wordDict, boolean[] dp, StringBuilder sb, List<String> res, int start) {
        if (start == s.length()) {
            res.add(sb.toString().trim());
            return;
        }
        for (int i = start + 1; i <= s.length()&& start+ maxWordLen >=i; i++) {
            if (!dp[i]) continue;
            String tmp = s.substring(start, i);
            if (!wordDict.contains(tmp)) continue;
            int len = sb.length();
            sb.append(tmp).append(' ');
            dfs(s, wordDict, dp, sb, res, i);
            sb.setLength(len);//builder只有前len个字符有效
        }
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("apple");
        list.add("pen");
        list.add("applepen");
        list.add("pine");
        list.add("pineapple");
        new WordBreak2().wordBreak("pineapplepenapple", list);
    }
}
