package Array;

import java.util.Arrays;

/**
 * 数组拆分 I
 * 给定长度为 2n 的数组, 你的任务是将这些数分成 n 对
 */
public class ArrayPairSum {
    public int arrayPairSum(int[] nums){
        Arrays.sort(nums);
        int res =0;
        for (int i = 0; i < nums.length / 2; i++) {
            res+=nums[2*i];
        }
        return res;
    }
    public int arrayPairSum1(int[] nums){
       int[] data  =new int[20001];
        for (int i = 0; i < nums.length; i++) {
            data[nums[i]+10000] ++;
        }
        int flag=1;
        int value =0;
        for (int i = 0; i < data.length; i++) {
            while (data[i]!=0){
                if (flag%2==1)value+=(i-10000);
                flag++;
                data[i]--;
            }
        }
        return value;
    }
}
