package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author maple on 2019/4/16 15:49.
 * @version v1.0
 * @see 1040441325@qq.com
 * 计数排序(适用于确定数据源取值范围的情况)
 */
public class CountingSort {
    public static void sort(int[] nums) {
        ArrayList<Integer> data = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) min = nums[i];
            if (nums[i] > max) max = nums[i];
        }
        int len = max - min + 1;
        int[] temp = new int[len];
        for (int i = 0; i < nums.length; i++) {
            temp[nums[i] - min]++;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            while (temp[j] == 0) {
                j++;
            }
            nums[i] = j + min;
            temp[j]--;
        }
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 7, 2, 5, 9, 1, 5, 2, 1, 4, 4, 3, 1, 5, 4, 4, 1, 6, 6, 4, 4};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

}
