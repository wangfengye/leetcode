package sort;

import java.util.Arrays;

/**
 * @author maple on 2019/4/2 16:53.
 * @version v1.0
 * @see 1040441325@qq.com
 * 冒泡排序
 */
public class BubbleSort {
    /**
     * 冒泡排序
     *
     * @param nums 数据源
     */
    public static void bubbleSort(int[] nums){
        for (int i = 0; i < nums.length-1; i++) {
            int last =0;//记录交换次数,
            for (int j = 1; j < nums.length-i; j++) {
                if (nums[j-1]>nums[j]){
                    last++;
                    swap(nums,j-1,j);
                }
            }
            if (last==0)return;
        }
    }
    public static void swap(int[] nums,int x,int y){
        int temp = nums[x];
        nums[x] =nums[y];
        nums[y] = temp;
    }
    public static void main(String[] args){
        int[] nums = new int[]{8,6,2,54,8,2};
        int[] b = new int[]{1,2,3,4,5,6};
        //573523 ,441961,40
        long time = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            bubbleSort(nums);
            //System.out.println(Arrays.toString(nums));
            bubbleSort(b);
        }
        System.out.println(System.nanoTime()-time);

    }

}
