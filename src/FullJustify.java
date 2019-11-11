import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * @author maple on 2019/11/11 9:25.
 * @version v1.0
 * @see 1040441325@qq.com
 * 68. 文本左右对齐
 * 给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
 * <p>
 * 你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
 * <p>
 * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 * <p>
 * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
 * <p>
 * 说明:
 * <p>
 * 单词是指由非空格字符组成的字符序列。
 * 每个单词的长度大于 0，小于等于 maxWidth。
 * 输入单词数组 words 至少包含一个单词。
 * 示例:
 * <p>
 * 输入:
 * words = ["This", "is", "an", "example", "of", "text", "justification."]
 * maxWidth = 16
 * 输出:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 * 示例 2:
 * <p>
 * 输入:
 * words = ["What","must","be","acknowledgment","shall","be"]
 * maxWidth = 16
 * 输出:
 * [
 *   "What   must   be",
 *   "acknowledgment  ",
 *   "shall be        "
 * ]
 * 解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
 *      因为最后一行应为左对齐，而不是左右两端对齐。
 * 第二行同样为左对齐，这是因为这行只包含一个单词。
 * 示例 3:
 * <p>
 * 输入:
 * words = ["Science","is","what","we","understand","well","enough","to","explain",
 *          "to","a","computer.","Art","is","everything","else","we","do"]
 * maxWidth = 20
 * 输出:
 * [
 *   "Science  is  what we",
 *    "understand      well",
 *   "enough to explain to",
 *   "a  computer.  Art is",
 *   "everything  else  we",
 *   "do                  "
 * ]
 */
public class FullJustify {
    private static char split ='@';
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<List<String>> lists = new ArrayList<>();
        lists.add(new ArrayList<>());
        List<String> list = lists.get(0);
        int tmpLen =0;
        for (int i = 0; i < words.length; i++) {
            if ((tmpLen+words[i].length())<=maxWidth){
                list.add(words[i]);
                tmpLen+=(words[i].length()+1);
            }else {
                list =new ArrayList<>();
                lists.add(list);
                tmpLen=0;i--;
            }
        }
        List<String> res= new ArrayList<>();
        StringBuilder builder =new StringBuilder();
        for (int i = 0; i < lists.size(); i++) {
            list= lists.get(i);
            builder.setLength(0);
            if (i==lists.size()-1||list.size()==1){
                for(String str: list){
                    builder.append(str).append(split);
                }
                for (int j = builder.length(); j <= maxWidth; j++) {
                    builder.append(split);
                }
                builder.setLength(maxWidth);
                res.add(builder.toString());
            }else {
                int spaceNeed=list.size()-1;
                int spaceNum= maxWidth;
                for (int j = 0; j <list.size(); j++) {
                    spaceNum-=list.get(j).length();
                }
                int[] spaces= new int[spaceNeed];
                while (spaceNum>0){
                    int tmp = spaceNum/spaceNeed;
                    for (int j = 0; j < spaceNeed; j++) {
                        spaces[j]+=tmp;
                    }
                    spaceNum-=(tmp*spaceNeed);
                    spaceNeed--;
                }

                for (int j = 0; j < list.size(); j++) {
                    builder.append(list.get(j));
                    if (j==list.size()-1)break;
                    for (int k = 0; k < spaces[j]; k++) {
                        builder.append(split);
                    }
                }
                res.add(builder.toString());
            }
        }
        return res;
    }
    public static void main(String[] args){
        show(fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."},16));
        show(fullJustify(new String[]{"What","must","be","acknowledgment","shall","be"},16));
        show(fullJustify(new String[]{"Science","is","what","we","understand","well","enough","to","explain",
                "to","a","computer.","Art","is","everything","else","we","do"},20));
    }
    private static void show(List<String> list){
        for(String str:list){
            System.out.println(str);
        }
        System.out.println(" ");
    }
}
