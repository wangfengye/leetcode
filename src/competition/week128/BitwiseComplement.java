package competition.week128;

/**
 * @author maple on 2019/3/18 10:23.
 * @version v1.0
 * @see 1040441325@qq.com
 * 进制整数的反码  显示英文描述
 * 用户通过次数 571
 * 用户尝试次数 602
 * 通过次数 582
 * 提交次数 1191
 * 题目难度 Easy
 * 每个非负整数 N 都有其二进制表示。例如， 5 可以被表示为二进制 "101"，11 可以用二进制 "1011" 表示，依此类推。注意，除 N = 0 外，任何二进制表示中都不含前导零。
 * <p>
 * 二进制的反码表示是将每个 1 改为 0 且每个 0 变为 1。例如，二进制数 "101" 的二进制反码为 "010"。
 * <p>
 * 给定十进制数 N，返回其二进制表示的反码所对应的十进制整数
 */
public class BitwiseComplement {
    public int bitwiseComplement(int N) {
        if (N == 0) return 1;
        int temp = 0;
        int base = 1;
        while (N > 0) {
            temp = temp + (N & 1 ^ 1) * base;
            base = base << 1;
            N = N >> 1;
        }
        return temp;
    }

}
