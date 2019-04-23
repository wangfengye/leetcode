import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author maple on 2019/4/23 10:57.
 * @version v1.0
 * @see 1040441325@qq.com
 * 手机九键输入英文
 */
public class LetterCombinations {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> strs = new ArrayList<>();
        if (digits.length() > 0) {
            add(digits, 0, new StringBuilder(), strs);
        }
        return strs;
    }

    private static void add(String digits, int index, StringBuilder builder, List<String> strs) {
        if (index == digits.length()) {
            strs.add(builder.toString());
            return;
        }
        switch (digits.charAt(index)) {
            case '2':
                builder.append('a');
                add(digits, index + 1, builder, strs);
                builder.setLength(index);
                builder.append('b');
                add(digits, index + 1, builder, strs);
                builder.setLength(index);
                builder.append('c');
                add(digits, index + 1, builder, strs);
                builder.setLength(index);
                break;
            case '3':
                builder.append('d');
                add(digits, index + 1, builder, strs);
                builder.setLength(index);
                builder.append('e');
                add(digits, index + 1, builder, strs);
                builder.setLength(index);
                builder.append('f');
                add(digits, index + 1, builder, strs);
                builder.setLength(index);
                break;
            case '4':
                builder.append('g');
                add(digits, index + 1, builder, strs);
                builder.setLength(index);
                builder.append('h');
                add(digits, index + 1, builder, strs);
                builder.setLength(index);
                builder.append('i');
                add(digits, index + 1, builder, strs);
                builder.setLength(index);
                break;
            case '5':
                builder.append('j');
                add(digits, index + 1, builder, strs);
                builder.setLength(index);
                builder.append('k');
                add(digits, index + 1, builder, strs);
                builder.setLength(index);
                builder.append('l');
                add(digits, index + 1, builder, strs);
                builder.setLength(index);
                break;
            case '6':
                builder.append('m');
                add(digits, index + 1, builder, strs);
                builder.setLength(index);
                builder.append('n');
                add(digits, index + 1, builder, strs);
                builder.setLength(index);
                builder.append('o');
                add(digits, index + 1, builder, strs);
                builder.setLength(index);
                break;
            case '7':
                builder.append('p');
                add(digits, index + 1, builder, strs);
                builder.setLength(index);
                builder.append('q');
                add(digits, index + 1, builder, strs);
                builder.setLength(index);
                builder.append('r');
                add(digits, index + 1, builder, strs);
                builder.setLength(index);
                builder.append('s');
                add(digits, index + 1, builder, strs);
                builder.setLength(index);
                break;
            case '8':
                builder.append('t');
                add(digits, index + 1, builder, strs);
                builder.setLength(index);
                builder.append('u');
                add(digits, index + 1, builder, strs);
                builder.setLength(index);
                builder.append('v');
                add(digits, index + 1, builder, strs);
                builder.setLength(index);
                break;
            case '9':
                builder.append('w');
                add(digits, index + 1, builder, strs);
                builder.setLength(index);
                builder.append('x');
                add(digits, index + 1, builder, strs);
                builder.setLength(index);
                builder.append('y');
                add(digits, index + 1, builder, strs);
                builder.setLength(index);
                builder.append('z');
                add(digits, index + 1, builder, strs);
                builder.setLength(index);
                break;
        }
    }
}
