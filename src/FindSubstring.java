import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author maple on 2019/6/25 14:23.
 * @version v1.0
 * @see 1040441325@qq.com
 * 30. 串联所有单词的子串
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 * <p>
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * s = "barfoothefoobarman",
 * words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoor" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * 示例 2：
 * <p>
 * 输入：
 * s = "wordgoodgoodgoodbestword",
 * words = ["word","good","best","word"]
 * 输出：[]
 */
public class FindSubstring {//todo:构造搜索树
    public List<Integer> findSubstring(String s, String[] words) {
        if(words==null|| words.length<=0)return new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<String, int[]> map = new HashMap<>();//int[0],总数, int[1]记录使用次数
        for (String word : words) {
            int[] res = map.get(word);
            if (res == null) res = new int[]{0, 0};
            res[0] = res[0] + 1;
            map.put(word, res);
        }
        int wordLen = words[0].length();
        int wordSize = words.length;
        for (int i = 0; i < s.length(); i++) {
            int wordCount = 0;
            for (Map.Entry<String, int[]> e :
                    map.entrySet()) {
                e.getValue()[1] = 0;
            }
            while (i + (wordCount + 1) * wordLen <= s.length()) {
                int[] res = map.get(s.substring(i + wordCount * wordLen, i + (wordCount + 1) * wordLen));
                if (res == null || res[0] == res[1]) break;
                else {
                    wordCount++;
                    res[1]++;
                    if (wordCount == wordSize) {
                        list.add(i);
                        break;
                    }
                }
            }
        }
        return list;
    }
}
