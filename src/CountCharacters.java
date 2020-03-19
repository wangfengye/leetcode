import java.util.Arrays;

/**
 * 1160. 拼写单词
 * 给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
 * <p>
 * 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
 * <p>
 * 注意：每次拼写时，chars 中的每个字母都只能用一次。
 * <p>
 * 返回词汇表 words 中你掌握的所有单词的 长度之和。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["cat","bt","hat","tree"], chars = "atach"
 * 输出：6
 * 解释：
 * 可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6。
 * 示例 2：
 * <p>
 * 输入：words = ["hello","world","leetcode"], chars = "welldonehoneyr"
 * 输出：10
 * 解释：
 * 可以形成字符串 "hello" 和 "world"，所以答案是 5 + 5 = 10。
 */
public class CountCharacters {
    public int countCharacters(String[] words, String chars) {
        int[] charsArr = new int[26];
        for (char c : chars.toCharArray()) {
            charsArr[c - 'a']++;
        }
        int resLen = 0;
        int[] charsArrCopy;
        for (String word : words) {
            charsArrCopy = Arrays.copyOf(charsArr, charsArr.length);
            boolean flag = false;//记录是否超出字母表范围
            for (char c : word.toCharArray()) {
                if (charsArrCopy[c - 'a'] <= 0) {
                    flag = true;
                    break;
                } else {
                    charsArrCopy[c - 'a']--;
                }
            }
            if (!flag) resLen += word.length();
        }
        return resLen;
    }
}
