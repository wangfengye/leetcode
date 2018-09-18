/**
 * 在未排序的数组中找到第 k 个最大的元素
 */
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) min = nums[i];
            if (nums[i] > max) max = nums[i];
        }
        int[] counter = new int[max - min + 1];// 记录与min的数量,index为(num-min),value是符合差值的数量
        for (int i = 0; i < nums.length; i++) {
            counter[nums[i] - min] += 1;
        }
        int c = 0;
        int i = max - min;
        for (; i >= 0; i--) {
            c += counter[i];
            if (c >= k) break;
        }
        return min + i;
    }
}
