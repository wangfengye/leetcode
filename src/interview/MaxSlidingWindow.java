package interview;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author maple on 2019/3/15 9:55.
 * @version v1.0
 * @see 1040441325@qq.com
 *滑动窗口最大值
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口 k 内的数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口最大值。
 *
 * 示例:
 */
public class MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length==0)return new int[0];
        int[] res = new int[nums.length - k + 1];
        int maxIndex = -1;
        for (int i = k - 1; i < nums.length; i++) {
            if (i - maxIndex >= k) maxIndex = getMaxIndex(nums, i, k);
            else if (nums[i] > nums[maxIndex]) maxIndex = i;
            res[i - k + 1] = nums[maxIndex];
        }
        return res;
    }

    private int getMaxIndex(int[] nums, int i, int k) {
        int res = i;
        for (int j = i - k + 1; j < i; j++) {
            if (nums[j] > nums[res]) res = j;
        }
        return res;
    }
}
