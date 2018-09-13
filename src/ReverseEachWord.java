/**
 * 反转字符串中的单词
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 */
public class ReverseEachWord {
    public String reverseWords(String s){
        String[] words = s.split(" ");
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (i!=0)buffer.append(" ");
            buffer.append(new StringBuilder(words[i]).reverse());
        }
        return buffer.toString();
    }
}
