/**
 * @author maple on 2019/6/11 9:22.
 * @version v1.0
 * @see 1040441325@qq.com
 * 824. 山羊拉丁文
 * <p>
 * 给定一个由空格分割单词的句子 S。每个单词只包含大写或小写字母。
 * <p>
 * 我们要将句子转换为 “Goat Latin”（一种类似于 猪拉丁文 - Pig Latin 的虚构语言）。
 * <p>
 * 山羊拉丁文的规则如下：
 * <p>
 * 如果单词以元音开头（a, e, i, o, u），在单词后添加"ma"。
 * 例如，单词"apple"变为"applema"。
 * <p>
 * 如果单词以辅音字母开头（即非元音字母），移除第一个字符并将它放到末尾，之后再添加"ma"。
 * 例如，单词"goat"变为"oatgma"。
 * <p>
 * 根据单词在句子中的索引，在单词最后添加与索引相同数量的字母'a'，索引从1开始。
 * 例如，在第一个单词后添加"a"，在第二个单词后添加"aa"，以此类推。
 * 返回将 S 转换为山羊拉丁文后的句子。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "I speak Goat Latin"
 * 输出: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
 * 示例 2:
 * <p>
 * 输入: "The quick brown fox jumped over the lazy dog"
 * 输出: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/goat-latin
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ToGoatLatin {
    private static final char[] STAND = {'a', 'e', 'i', 'o', 'u'};
    private static final int DIFF = 'a' - 'A';

    public String toGoatLatin(String S) {
        StringBuilder builder = new StringBuilder();
        char ahead;
        String suffix = "maa";
        int i = 0;
        if (!arrayContains(S.charAt(0))) {
            ahead = S.charAt(0);
            i = 1;
        } else {
            ahead = ' ';
        }
        for (; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == ' ') {
                if (ahead != ' ') builder.append(ahead);
                builder.append(suffix).append(' ');
                suffix += 'a';
                if (!arrayContains(S.charAt(i + 1))) {
                    ahead = S.charAt(i + 1);
                    i++;
                } else {
                    ahead = ' ';
                }
            } else {
                builder.append(c);
            }
        }
        if (ahead != ' ') builder.append(ahead);
        builder.append(suffix);
        return builder.toString();
    }

    private boolean arrayContains(char c) {
        for (char s : STAND) {
            if (s == c || s - c == DIFF) return true;
        }
        return false;
    }
}
