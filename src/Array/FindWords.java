package Array;

import org.bouncycastle.util.Arrays;

import java.util.ArrayList;

/**
 * @author maple on 2019/5/31 10:35.
 * @version v1.0
 * @see 1040441325@qq.com
 * 给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。键盘如下图所示。
 */
public class FindWords {
    private static final String UP="qwertyuiop";
    private static final String MID="asdfghjkl";
    private static final String DOWN="zxcvbnm";
    public String[] findWords(String[] words) {
        String tmp;
        boolean is;
        ArrayList<String> strs = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            char[] word = words[i].toLowerCase().toCharArray();
            if (UP.indexOf(word[0])!=-1)tmp=UP;
            else if (MID.indexOf(word[0])!=-1)tmp=MID;
            else tmp=DOWN;
            is=true;
            for (int j = 1; j < word.length; j++) {
                if (tmp.indexOf(word[j])==-1){
                    is =false;break;
                }
            }
            if (is)strs.add(words[i]);
        }
        return strs.toArray(new String[strs.size()]);
    }
}
