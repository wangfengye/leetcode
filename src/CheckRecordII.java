import java.util.ArrayList;
import java.util.List;

/**
 * @author maple on 2019/6/9 17:56.
 * @version v1.0
 * @see 1040441325@qq.com
 * 552. 学生出勤记录 II
 * 给定一个正整数 n，返回长度为 n 的所有可被视为可奖励的出勤记录的数量。 答案可能非常大，你只需返回结果mod 109 + 7的值。
 * <p>
 * 学生出勤记录是只包含以下三个字符的字符串：
 * <p>
 * 'A' : Absent，缺勤
 * 'L' : Late，迟到
 * 'P' : Present，到场
 * 如果记录不包含多于一个'A'（缺勤）或超过两个连续的'L'（迟到），则该记录被视为可奖励的。
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 2
 * 输出: 8
 * 解释：
 * 有8个长度为2的记录将被视为可奖励：
 * "PP" , "AP", "PA", "LP", "PL", "AL", "LA", "LL"
 * 只有"AA"不会被视为可奖励，因为缺勤次数超过一次。
 * 注意：n 的值不会超过100000。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/student-attendance-record-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CheckRecordII {

    public static final int MOD = (int) (Math.pow(10, 9) + 7);

    public int checkRecordII(int n) {//动态规划,
        if (n == 0) return 1;
        int P = 1;//无A,插入的不是L
        int AP = 0;//有A,插入的不是L
        int L = 1;//无A,插入是L,
        int AL = 0;//有A,插入L,
        int LL = 0;//wuA,插入两个L,
        int ALL = 0;//有A, 插入两个L,
        int A = 1;//插入A,
        for (int i = 2; i < n + 1; i++) {
            int tP = ((P + L) % MOD + LL) % MOD;//插入个P,
            int tAP = (((AP + AL) % MOD + ALL) % MOD + A) % MOD;
            int tL = P;
            int tLL = L;
            int tAL = (AP + A) % MOD;
            int tALL = AL;
            int tA = ((P + L) % MOD + LL) % MOD;
            P = tP;
            AP = tAP;
            L = tL;
            AL = tAL;
            LL = tLL;
            ALL = tALL;
            A = tA;
        }
        return ((((((P + AP) % MOD + L) % MOD + LL) % MOD + AL) % MOD + ALL) % MOD + A) % MOD;
    }

    public static void main(String[] a) {
        System.out.println(new CheckRecordII().checkRecordII(100));
    }
}
