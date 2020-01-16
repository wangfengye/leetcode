/**
 * 696. 计数二进制子串
 * 给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的。
 * <p>
 * 重复出现的子串要计算它们出现的次数。
 * <p>
 * 示例 1 :
 * <p>
 * 输入: "00110011"
 * 输出: 6
 * 解释: 有6个子串具有相同数量的连续1和0：“0011”，“01”，“1100”，“10”，“0011” 和 “01”。
 * <p>
 * 请注意，一些重复出现的子串要计算它们出现的次数。
 * <p>
 * 另外，“00110011”不是有效的子串，因为所有的0（和1）没有组合在一起。
 * 示例 2 :
 * <p>
 * 输入: "10101"
 * 输出: 4
 * 解释: 有4个子串：“10”，“01”，“10”，“01”，它们具有相同数量的连续1和0。
 */
public class CountBinarySubstrings {
    public static int countBinarySubstrings(String s) {
        int[] group = new int[s.length()];
        int id = 0;
        group[id] = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                group[id]++;
            } else {
                group[++id] = 1;
            }
        }
        int max = 0;
        for (int i = 1; i <= id; i++) {
            max += Math.min(group[i], group[i - 1]);
        }
        return max;
    }

    //改进舍去group数组
    public static int countBinarySubstrings2(String s) {

        int last = 0;
        int cur = 1;
        int max = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                cur++;
            } else {
                max += Math.min(last, cur);
                last = cur;
                cur = 1;
            }
        }
        max += Math.min(last, cur);
        return max;
    }

    public static void main(String[] args) {
        System.out.println(countBinarySubstrings2("00110011"));
        System.out.println(countBinarySubstrings2("10101"));
        System.out.println(countBinarySubstrings2("00110"));
    }
}
