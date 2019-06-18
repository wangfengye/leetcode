/**
 * @author maple on 2019/6/18 14:36.
 * @version v1.0
 * @see 1040441325@qq.com
 * 6. Z 字形变换
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * <p>
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 * 示例 1:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * <p>
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 */
public class Convert {
    public static String convert(String s, int numRows) {//暴力处理
        if (numRows==1)return s;
        char[][] chars = new char[numRows][s.length()];
        int i = 0;
        int j = 0;
        int iStep = 1;
        int jStep = 0;
        for (char c : s.toCharArray()) {
            chars[i][j] = c;
            if (i == numRows - 1) {
                iStep = -1;
                jStep = 1;
            } else if (i == 0) {
                iStep = 1;
                jStep = 0;
            }
            i += iStep;
            j += jStep;
        }
        StringBuilder builder = new StringBuilder();
        for (int k = 0; k < chars.length; k++) {
            for (int l = 0; l < chars[k].length; l++) {
                if (chars[k][l] != 0) builder.append(chars[k][l]);
            }
        }
        return builder.toString();
    }
    public static String convert2(String s,int numRows){
        if (numRows==1||s.length()<numRows)return s;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = i; j <s.length() ; j+=(2*numRows-2)) {
                builder.append(s.charAt(j));
                if (i!=0&&i!=numRows-1){
                    if (j+2*(numRows-i-1)<s.length())builder.append(s.charAt(j+2*(numRows-i-1)));
                }
            }
        }
        return builder.toString();
    }
    public static void main(String[] args) {
        System.out.println(convert("LEETCODEISHIRING", 3));
        System.out.println(convert2("LEETCODEISHIRING", 3));
        System.out.println(convert("LEETCODEISHIRING", 4));
        System.out.println(convert2("LEETCODEISHIRING", 4));
        System.out.println(convert("LEETCODEISHIRING", 1));
        System.out.println(convert2("LEETCODEISHIRING", 1));
    }
}
