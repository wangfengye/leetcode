package competition.week129;

/**
 * @author maple on 2019/3/24 14:06.
 * @version v1.0
 * @see 1040441325@qq.com\
 * 1020. 将数组分成和相等的三个部分  显示英文描述
 * 用户通过次数 321
 * 用户尝试次数 401
 * 通过次数 324
 * 提交次数 883
 * 题目难度 Easy
 * 给定一个整数数组 A，只有我们可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。
 *
 * 形式上，如果我们可以找出索引 i+1 < j 且满足 (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1]) 就可以将数组三等分。
 */
public class CanThreePartsEqualSum {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum =0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        if (sum%3!=0)return false;
        int sum_3 = sum/3;
        int tmp = 0;
        int counter =0;
        for (int i = 0; i < A.length; i++) {
            tmp+=A[i];
            if (tmp==sum_3){
                tmp=0;counter++;
            }
        }
        if (counter!=3)return false;
        return true;
    }
}
