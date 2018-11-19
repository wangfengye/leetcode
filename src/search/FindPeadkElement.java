package search;

/**
 * 寻找峰值
 * 峰值元素是指其值大于左右相邻值的元素。
 * 给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
 * 数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
 * 你可以假设 nums[-1] = nums[n] = -∞
 */
public class FindPeadkElement {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] < nums[mid + 1]) low = mid + 1;  //注意为什么要+1，因为mid位置一定不是峰，而low=mid+1有可能是峰
            else high = mid;      //注意这里为什么不加+，因为high=mid有可能是峰
        }
        return low;
    }


    public static void main(String[] args) {
        new FindPeadkElement().findPeakElement(new int[]{2, 1, 2});
    }
}
