package sort;

import java.util.Arrays;

/**
 * @author maple on 2019/4/9 16:52.
 * @version v1.0
 * @see 1040441325@qq.com
 * 插入排序
 */
public class InsertionSort {
    public static void sort(int[] data) {
        for (int i = 1; i < data.length; i++) {
            int tmp = data[i];
            int j = i - 1;
            while (j >= 0 && tmp < data[j]) {
                data[j + 1] = data[j];
                j--;
            }
            data[j+1] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{8, 6, 2, 54, 8, 2};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
