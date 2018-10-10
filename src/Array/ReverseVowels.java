package Array;

/**
 * 反转字符串中的元音字母
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "hello"
 * 输出: "holle"
 */
public class ReverseVowels {
    public String reverseVowels(String s) {
        char[] sChars = s.toCharArray();
        int i = 0;
        int j = sChars.length - 1;
        while (i < j) {
            if (!isVowel(sChars[i])) {
                i++;
                continue;
            }
            if (!isVowel(sChars[j])) {
                j--;
                continue;
            }
            char temp = sChars[i];
            sChars[i] = sChars[j];
            sChars[j] = temp;
            i++;
            j--;

        }
        return String.valueOf(sChars);
    }

    /**
     * 判断元音字母
     *
     * @param c
     * @return
     */
    private boolean isVowel(char c) {
        switch (c) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
                return true;
            default:
                return false;
        }
    }
}
