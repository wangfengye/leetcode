package interview;

import java.util.ArrayList;
import java.util.List;

/**
 * @author maple on 2019/3/4 17:27.
 * @version v1.0
 * @see 1040441325@qq.com
 * 单词拆分
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * <p>
 * 说明：
 * <p>
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词
 */
public class WordBreak {


    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];//dp[i]记录 0-i 之间是否由单词组成;

        dp[0] = true;
        for (int i = 0; i < s.length(); i++) {     // 从一个字符开始判断是否可由单词组成,依次扩大长度
            StringBuilder str = new StringBuilder(s.substring(0, i + 1));
            for (int j = 0; j <= i; j++) {
                if (dp[j] && wordDict.contains(str.toString())) {
                    dp[i + 1] = true;
                    break;
                }
                str.deleteCharAt(0);
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("apple");
        list.add("pen");
        System.out.println(new WordBreak().wordBreak("applepenapple", list));
    }
}
