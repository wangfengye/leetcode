package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * @author maple on 2019/3/15 13:48.
 * @version v1.0
 * @see 1040441325@qq.com
 * 摆动排序 II
 * 给定一个无序的数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1, 5, 1, 1, 6, 4]
 * 输出: 一个可能的答案是 [1, 4, 1, 5, 1, 6]
 * 示例 2:
 * <p>
 * 输入: nums = [1, 3, 2, 2, 3, 1]
 * 输出: 一个可能的答案是 [2, 3, 1, 3, 1, 2]
 * 说明:
 * 你可以假设所有输入都会得到有效的结果。
 * <p>
 * 进阶:
 * 你能用 O(n) 时间复杂度和 / 或原地 O(1) 额外空间来实现吗？
 */
public class WiggleSort {
    public void wiggleSort(int[] nums) {// 排序,找到中点, 奇数下标取后半段,偶数下标取前半段
        Arrays.sort(nums);
        int n = nums.length;
        int temp[] = new int[n];
        for (int i = 0; i < n; i++) {
            temp[i] = nums[i];
        }
        int mid = (n + 1) / 2;
        int end = n;
        for (int i = 0; i < n; i++) {
            nums[i] = (i % 2 == 1) ? temp[--end] : temp[--mid];
        }
    }

    public void wiggleSort2(int[] nums) {
        int n = nums.length;
        int mid = getMid(nums);
        int i = 0, j = 0, k = n - 1;
        while (j <= k) {
            if (nums[(1 + 2 * (j)) % (n | 1)] > mid) {
                swap(nums, (1 + 2 * (i)) % (n | 1), (1 + 2 * (j)) % (n | 1));
                i++;
                j++;
            } else if (nums[(1 + 2 * (j)) % (n | 1)] < mid) {
                swap(nums, (1 + 2 * (j)) % (n | 1), (1 + 2 * (k)) % (n | 1));
                j++;
                k--;
            } else j++;
        }
    }


    private int getMid(int[] nums) {
        int n = nums.length;
        if (n % 2 == 0) return (quickSelect(nums, n / 2 - 1, 0, n-1) + quickSelect(nums, n / 2, 0, n-1)) / 2;
        else return quickSelect(nums, n / 2, 0, n-1);
    }

    private int quickSelect(int[] nums, int k, int start, int end) {
        if (start == end)return nums[start];
        int i = start;int j = end;
        int key = nums[i];
        while (i<j){
            while (nums[j]>=key);
        }
        return 0;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {

    }
}
