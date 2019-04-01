package competition.week130;

import java.util.ArrayList;
import java.util.List;

/**
 * @author maple on 2019/4/1 9:01.
 * @version v1.0
 * @see 1040441325@qq.com
 * 1029. 可被 5 整除的二进制前缀  显示英文描述
 * 用户通过次数 467
 * 用户尝试次数 662
 * 通过次数 477
 * 提交次数 1964
 * 题目难度 Easy
 * 给定由若干 0 和 1 组成的数组 A。我们定义 N_i：从 A[0] 到 A[i] 的第 i 个子数组被解释为一个二进制数（从最高有效位到最低有效位）。
 * <p>
 * 返回布尔值列表 answer，只有当 N_i 可以被 5 整除时，答案 answer[i] 为 true，否则为 false。
 */
public class PrefixesDivBy5 {
    public static List<Boolean> prefixesDivBy5(int[] A) {
        long temp = 0;
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            temp = temp * 2 + A[i];
            temp = temp % 5;//每次存储余数
            if (temp == 0) res.add(true);
            else res.add(false);
        }
        return res;
    }

    public static void main(String[] args) {
        prefixesDivBy5(new int[]{0, 1, 1});
        System.out.println(Integer.toString(150, 2));

    }
}
