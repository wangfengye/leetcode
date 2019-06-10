/**
 * @author maple on 2019/6/9 17:52.
 * @version v1.0
 * @see 1040441325@qq.com
 * 551. 学生出勤记录 I
 * 给定一个字符串来代表一个学生的出勤记录，这个记录仅包含以下三个字符：
 * <p>
 * 'A' : Absent，缺勤
 * 'L' : Late，迟到
 * 'P' : Present，到场
 * 如果一个学生的出勤记录中不超过一个'A'(缺勤)并且不超过两个连续的'L'(迟到),那么这个学生会被奖赏。
 * <p>
 * 你需要根据这个学生的出勤记录判断他是否会被奖赏。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "PPALLP"
 * 输出: True
 * 示例 2:
 * <p>
 * 输入: "PPALLL"
 * 输出: False
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/student-attendance-record-i
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CheckRecord {
    public boolean checkRecord(String s) {
        int A = 0, L = 0;
        for (char c : s.toCharArray()) {
            switch (c) {
                case 'A':
                    A++;
                    L = 0;
                    if (A > 1) return false;
                    break;
                case 'L':
                    L++;
                    if (L > 2) return false;
                    break;
                case 'P':
                    L = 0;
                    break;
            }
        }
        return true;
    }
}
