package competition.week129;

/**
 * @author maple on 2019/3/24 14:42.
 * @version v1.0
 * @see 1040441325@qq.com
 * 1023. 子串能表示从 1 到 N 数字的二进制串  显示英文描述
 * 用户通过次数 104
 * 用户尝试次数 118
 * 通过次数 105
 * 提交次数 189
 * 题目难度 Medium
 * 给定一个二进制字符串 S（一个仅由若干 '0' 和 '1' 构成的字符串）和一个正整数 N，如果对于从 1 到 N 的每个整数 X，其二进制表示都是 S 的子串，就返回 true，否则返回 false。
 */
public class QueryString {
    public static boolean queryString(String S, int N) {
        for (int i = 1; i <= N; i++) {
            String n = Integer.toString(i, 2);
            if (!S.contains(n)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(queryString("110101011011000011011111000000", 15));
    }
}
