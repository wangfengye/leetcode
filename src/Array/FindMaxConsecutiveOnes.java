package Array;

/**
 *  最大连续1的个数
 *  给定一个二进制数组， 计算其中最大连续1的个数。
 */
public class FindMaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums){
        int flag = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==0){
                max = Math.max(max,flag);
                flag = 0;
            }else {
                flag++;
            }
        }
        return Math.max(flag,max);
    }
}
