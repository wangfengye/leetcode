package Array;

/**
 * @author maple on 2019/7/2 9:24.
 * @version v1.0
 * @see 1040441325@qq.com
 * 41. 缺失的第一个正数
 * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,0]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 示例 3:
 * <p>
 * 输入: [7,8,9,11,12]
 * 输出: 1
 * 说明:
 * <p>
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。
 */
public class FirstMissingPositive {
    public static int firstMissingPositive(int[] nums) {
        boolean tmp[] = new boolean[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && nums[i] < tmp.length) tmp[nums[i]] = true;
        }
        for (int i = 1; i < tmp.length; i++) {
            if (!tmp[i]) return i;
        }
        return tmp.length;
    }

    public static int firstMissingPositive2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                swap(nums, nums[i] - 1, i);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) return i + 1;
        }
        return nums.length + 1;
    }

    private static void swap(int[] nums, int i, int i1) {
        int tmp = nums[i];
        nums[i] = nums[i1];
        nums[i1] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{3, 4, -1, 1}));
        System.out.println(firstMissingPositive2(new int[]{1, 2, 0}));
    }
}
