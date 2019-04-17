package sort;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author maple on 2019/4/16 17:21.
 * @version v1.0
 * @see 1040441325@qq.com
 * 基数排序
 */
public class RadixSort {
    public static void radix(int[] nums, int mod) {

        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            lists.add(new ArrayList<>());
        }
        for (int i = 0; i < nums.length; i++) {
            lists.get((nums[i] / mod) % 10).add(nums[i]);
        }
        int index = 0;
        ArrayList<Integer> tmp = lists.get(index);
        for (int i = 0; i < nums.length; i++) {
            while (tmp.size() == 0) {
                index++;
                tmp = lists.get(index);
            }
            nums[i] = tmp.get(0);
            tmp.remove(0);
        }
    }

    public static void sort(int[] nums) {
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) max = nums[i];
        }
        int mod = 1;
        while (max > mod) {
            radix(nums, mod);
            mod *= 10;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{50, 2, 12, 5, 38, 2, 3, 4, 44, 15, 19, 48, 27, 47};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
