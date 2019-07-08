import java.util.Arrays;

/**
 * @author maple on 2019/7/8 9:16.
 * @version v1.0
 * @see 1040441325@qq.com
 */
public class MaximumProduct {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);//排序
        int a = nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];//最大的三个数
        int b = nums[0] * nums[1] * nums[nums.length - 1];//两个大负数乘一一个最大正数
        return a > b ? a : b;
    }
}
