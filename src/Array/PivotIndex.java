package Array;

/**
 * 寻找数组的中心索引
 * 我们是这样定义数组中心索引的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和
 */
public class PivotIndex {
    public int pivotIndex(int[] nums) {
        if (nums.length==0)return -1;
        int leftSum = 0;
        int rightSum = 0;
        for (int i = 0; i < nums.length; i++) {
            rightSum += nums[i];
        }
        if (leftSum == rightSum-nums[0]) return 0;
        for (int i = 0; i < nums.length - 1; i++) {
            leftSum += nums[i];
            rightSum -= nums[i];
            if (leftSum == rightSum - nums[i + 1]) return i + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new PivotIndex().pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
    }
}
