package Array;

/**
 * 翻转字符串里的单词
 */
public class ReverseWords {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        StringBuilder builder = new StringBuilder();
        int flag = 0;
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                if (flag != 0) builder.insert(0, chars, index, flag).insert(0, ' ');
                flag = 0;
                index = i + 1;
            } else {
                flag++;
            }
        }
        if (flag == 0) builder.delete(0, 1);
        else builder.insert(0, chars, index, flag);
        return builder.toString();
    }

    public String reverseWords1(String s) {
        String[] args = s.trim().split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = args.length - 1; i > 0; i--) {
            if (args[i].length() > 0) builder.append(args[i]).append(' ');

        }
        if (args[0].length() > 0) builder.append(args[0]);
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ReverseWords().reverseWords1("1 "));
    }
}
