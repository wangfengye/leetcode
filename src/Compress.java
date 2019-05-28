import java.util.ArrayList;

/**
 * @author maple on 2019/5/28 11:23.
 * @version v1.0
 * @see 1040441325@qq.com
 * 给定一组字符，使用原地算法将其压缩。
 * <p>
 * 压缩后的长度必须始终小于或等于原数组长度。
 * <p>
 * 数组的每个元素应该是长度为1 的字符（不是 int 整数类型）。
 * <p>
 * 在完成原地修改输入数组后，返回数组的新长度。
 * <p>
 * <p>
 * <p>
 * 进阶：
 * 你能否仅使用O(1) 空间解决问题？
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["a","a","b","b","c","c","c"]
 * <p>
 * 输出：
 * 返回6，输入数组的前6个字符应该是：["a","2","b","2","c","3"]
 * <p>
 * 说明：
 * "aa"被"a2"替代。"bb"被"b2"替代。"ccc"被"c3"替代。
 * 示例 2：
 * <p>
 * 输入：
 * ["a"]
 * <p>
 * 输出：
 * 返回1，输入数组的前1个字符应该是：["a"]
 * <p>
 * 说明：
 * 没有任何字符串被替代。
 */
public class Compress {
    public static int compress(char[] chars) {
        int id = 0;
        int len = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i-1]) {
                len++;
            } else {
                if (len == 1) {
                    chars[id] = chars[i - 1];
                    id++;
                } else {
                    chars[id] = chars[i - 1];

                    id = addLen(chars, len, id) + 1;
                    len = 1;
                }
            }
        }
        if (len > 1) {
            chars[id] = chars[chars.length - 1];
            id = addLen(chars, len, id) + 1;
        } else {
            chars[id] = chars[chars.length - 1];
            id++;
        }
        return id;
    }

    private static int addLen(char[] chars, int len, int id) {
        ArrayList<Character> characters = new ArrayList<>();
        while (len > 0) {
            characters.add((char) ('0' + len % 10));
            len /= 10;
        }
        for (int i = characters.size() - 1; i >= 0; i--) {
            id++;
            chars[id] = characters.get(i);
        }
        return id;
    }

    public static void main(String[] args) {
        compress(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'});
    }
}
