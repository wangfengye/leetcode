package sort;

import java.util.Arrays;

/**
 * @author maple on 2019/4/9 16:29.
 * @version v1.0
 * @see 1040441325@qq.com
 * 选择排序
 */
public class SelectionSort {
    /**
     * 不稳定情况 nums =[2,4,2,1]
     * 排序后nums[0]和nums[2]交换了位置
     * @param nums 数据源
     */
    public static void  sort(int[] nums){
        for (int i = 0; i < nums.length-1; i++) {
            int maxIndex=i;
            for (int j = i; j < nums.length; j++) {
                if (nums[j]<nums[maxIndex])maxIndex=j;
            }
            BubbleSort.swap(nums,i,maxIndex);
        }
    }
    public static void main(String[] args){
        int[] data = new int[]{3,5,2,15,26,21,19,58};
        sort(data);
        System.out.println(Arrays.toString(data));
    }
}
