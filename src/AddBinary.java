/**
 * 二进制求和
 * 给定两个二进制字符串，返回他们的和
 */
public class AddBinary {
    /**
     * 方法1
     * @param a
     * @param b
     * @return
     */
    private static String addBinary(String a, String b) {
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        int len = Math.max(aChars.length, bChars.length);
        char[] rChars = new char[len + 1];
        int add = 0;
        for (int i = 0; i < len; i++) {
            int aChar = '0';
            int bChar = '0';
            if (i < aChars.length) aChar = aChars[aChars.length - 1 - i];
            if (i < bChars.length) bChar = bChars[bChars.length - 1 - i];
            int counter = 0;
            if (aChar == '1') counter++;
            if (bChar == '1') counter++;
            if (add == 1) counter++;
            if (counter == 3) {
                rChars[rChars.length - i - 1] = '1';
                add = 1;
            } else if (counter == 2) {
                rChars[rChars.length - i - 1] = '0';
                add = 1;
            } else if (counter == 1) {
                rChars[rChars.length - i - 1] = '1';
                add = 0;
            } else {
                rChars[rChars.length - i - 1] = '0';
                add = 0;
            }
        }
        if (add == 1) rChars[0] = '1';
        else rChars[0] = '0';
        StringBuilder builder = new StringBuilder(len + 1);
        boolean start = false;
        for (char rChar : rChars) {
            if (!start && rChar == '1') start = true;
            if (start) {
                builder.append(String.valueOf(rChar));
            }
        }
        if (builder.length()==0)builder.append("0");
        return builder.toString();
    }

    /**
     * 错误解法,在数值超出long上限出现异常
     * @param a
     * @param b
     * @return
     */
    private static String addBinary1(String a, String b) {
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        int len = Math.max(aChars.length, bChars.length);

        long re = 0;
        for (int i = 0; i < len; i++) {
            int aChar = '0';
            int bChar = '0';
            if (i < aChars.length) aChar = aChars[aChars.length - 1 - i];
            if (i < bChars.length) bChar = bChars[bChars.length - 1 - i];
            if (aChar == '1') re+=(1<<i);
            if (bChar == '1') re+=(1<<i);
        }

        return Long.toBinaryString(re);
    }
    public static void main(String[] args) {
        System.out.println("Sss");
        System.out.println(AddBinary.addBinary("1010", "1011"));
    }
}
