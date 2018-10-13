package Array;

/**
 * 长度最小的子数组
 * <p>
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。
 * 如果不存在符合条件的连续子数组，返回 0
 */
public class MinSubArrayLen {
    public int minSubArrayLen(int s, int[] nums) {
        int minLength = nums.length + 1;
        int l = 0;
        int r = 0;
        int sum = 0;
        while (l < nums.length) {
            if (r < nums.length && sum < s) {// r未移动到队尾且 ,当前数组和小于目标值
                sum += nums[r];
                r++;//当前r下标+1;
            } else if (r >= nums.length && sum < s) {//r移动到队尾,且数组和仍小于目标值,再向右移动l必然小于目标值
                break;
            } else {// 当前数组和>=目标值,l右移动
                sum -= nums[l];
                l++;//当前l下标;因此l-r即为当前数据长度
            }
            if (sum >= s) {
                minLength = minLength < r - l ? minLength : r - l;
            }
        }
        return minLength > nums.length ? 0 : minLength;
    }

    public static void main(String[] args) {
        new MinSubArrayLen().minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3});
    }
}
