/**
 * @author maple on 2019/7/11 14:00.
 * @version v1.0
 * @see 1040441325@qq.com
 * 434. 字符串中的单词数
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 * <p>
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 * <p>
 * 示例:
 * <p>
 * 输入: "Hello, my name is John"
 * 输出: 5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-segments-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CountSegments {
    public int countSegments(String s) {
        boolean co = true;//若前面为空格
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                if (!co) {
                    co = true;
                    count++;
                }
            } else {
                co = false;
            }
        }
        if (!co) count++;
        return count;
    }
    public static void main(String[] args){
        String s = " a  b  ";
        String[] res = s.split(" +");
        System.out.println(res.length);
    }

}
