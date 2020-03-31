package Array;

import java.util.Arrays;

/**
 * 912. 排序数组
 * 给你一个整数数组 nums，将该数组升序排列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,2,3,1]
 * 输出：[1,2,3,5]
 * 示例 2：
 * <p>
 * 输入：nums = [5,1,1,2,0,0]
 * 输出：[0,0,1,1,2,5]
 */
public class SortArray {
    public int[] sortArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            boolean flag = false;
            for (int j = 1; j < nums.length; j++) {
                if (nums[j] < nums[j - 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = tmp;
                    flag = true;
                }
            }
            if (!flag) break;
        }
        return nums;
    }

    public void quickSort(int[] nums,int l,int h) {

        if (l < h) {
           int index =getIndex(nums,l,h);
           quickSort(nums,0,index-1);
           quickSort(nums,index+1,h);
        }

    }
    private static int getIndex(int[] arr, int low, int high) {
        // 基准数据
        int tmp = arr[low];
        while (low < high) {
            // 当队尾的元素大于等于基准数据时,向前挪动high指针
            while (low < high && arr[high] >= tmp) {
                high--;
            }
            // 如果队尾元素小于tmp了,需要将其赋值给low
            arr[low] = arr[high];
            // 当队首元素小于等于tmp时,向前挪动low指针
            while (low < high && arr[low] <= tmp) {
                low++;
            }
            // 当队首元素大于tmp时,需要将其赋值给high
            arr[high] = arr[low];

        }
        // 跳出循环时low和high相等,此时的low或high就是tmp的正确索引位置
        // 由原理部分可以很清楚的知道low位置的值并不是tmp,所以需要将tmp赋值给arr[low]
        arr[low] = tmp;
        return low; // 返回tmp的正确位置
    }
    private void swap(int[] nums, int l, int h) {
        int tmp = nums[l];
        nums[l] = nums[h];
        nums[h] = tmp;
    }

    /**
     * 非比较排序的计数排序 适用于元素有限的排序
     * @param nums
     * @return
     */
    public int[] sortArray2(int[] nums){
        int max = -50001, min = 50001;
        for (int num: nums) {
            max = Math.max(num, max);
            min = Math.min(num, min);
        }


        int[] counter = new int[max - min + 1];
        for (int num: nums) {
            counter[num - min]++;
        }

        int idx = 0;
        for (int num = min; num <= max; num++) {
            int cnt = counter[num - min];
            while (cnt-- > 0) {
                nums[idx++] = num;
            }
        }
        return nums;
    }
}
