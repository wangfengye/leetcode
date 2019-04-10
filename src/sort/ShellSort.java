package sort;

import java.util.Arrays;

/**
 * @author maple on 2019/4/9 17:16.
 * @version v1.0
 * @see 1040441325@qq.com
 * 希尔排序.
 */
public class ShellSort {
    public static void sort(int[] nums) {

        int increment = nums.length;
        do {
            increment = increment / 3 + 1;
            for (int i = increment; i < nums.length; i++) {//直接插入排序
                if (nums[i - increment] > nums[i]) {
                    int temp = nums[i];
                    int j = i - increment;
                    do {
                        nums[j + increment] = nums[j];
                        j -= increment;
                    } while (j >= 0  && nums[j] > temp);
                    nums[j + increment] = temp;
                }
            }
        } while (increment > 1);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{8, 6, 2, 54, 8, 2};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
