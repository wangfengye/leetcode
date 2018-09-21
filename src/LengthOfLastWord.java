/**
 * 最后一个单词的长度
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 *
 * 如果不存在最后一个单词，请返回 0 。
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        char[] cs = s.toCharArray();
        int len = 0;
        boolean start = false;
        for (int i = cs.length - 1; i >= 0; i--) {
            if (start) {
                if (cs[i] == ' ') break;
                else len++;
            } else {
                if (cs[i] != ' ') {
                    start = true;
                    len++;
                }
            }
        }
        return len;
    }
}
