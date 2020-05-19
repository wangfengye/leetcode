package string;

/**
 * 子串位置
 */
public class SubStrIndex {
    public static int staStr(String haystack, String needle) {
        for (int i = 0; i < haystack.length() - needle.length(); i++) {
            boolean flag = true;
            for (int j = 0; j < needle.length(); j++) {
                if (needle.charAt(j) != haystack.charAt(i + j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(staStr("hello","ll"));
        System.out.println(staStr("aaaaa","bba"));
    }
}
