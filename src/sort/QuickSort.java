package sort;

import java.util.Arrays;

/**
 * @author maple on 2019/4/12 16:21.
 * @version v1.0
 * @see 1040441325@qq.com
 * 快速排序
 */
public class QuickSort {
    public static void sort(int[] nums, int l, int r) {
        int partIndex;
        if (l < r) {
            partIndex = partition(nums, l, r);
            sort(nums, l, partIndex - 1);
            sort(nums, partIndex + 1, r);
        }
    }

    private static int partition(int[] nums, int l, int r) {

        int tem = nums[l];
        while (l < r) {
            while (l < r && nums[r] >tem) r--;
            if (l < r) {
                nums[l]=nums[r];
                l++;
            }
            while (l < r && nums[l] < tem) l++;
            if (l < r) {
                nums[r] =nums[l];
                r--;
            }
        }
        nums[l]=tem;
        return l;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{8, 6, 2, 54, 8, 2};
        sort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
