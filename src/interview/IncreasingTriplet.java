package interview;

/**
 * @author maple on 2019/3/2 16:00.
 * @version v1.0
 * @see 1040441325@qq.com
 * <p>
 * 递增的三元子序列
 * 给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。
 * <p>
 * 数学表达式如下:
 * <p>
 * 如果存在这样的 i, j, k,  且满足 0 ≤ i < j < k ≤ n-1，
 * 使得 arr[i] < arr[j] < arr[k] ，返回 true ; 否则返回 false 。
 * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1) 。
 */
public class IncreasingTriplet {
    public static boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) return false;
        int m1 = Integer.MAX_VALUE;//最小元素
        int m2 = Integer.MAX_VALUE;//第二小元素
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= m1) m1 = nums[i];
            else if (nums[i] <= m2) m2 = nums[i];
            else return true;
        }
        return false;
    }
    public static void main(String[] args){
        System.out.println(increasingTriplet(new int[]{1,3,4,2,5}) );
    }
}
