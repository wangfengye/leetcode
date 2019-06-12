/**
 * @author maple on 2019/6/12 9:53.
 * @version v1.0
 * @see 1040441325@qq.com
 * 665. 非递减数列
 * 给定一个长度为 n 的整数数组，你的任务是判断在最多改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 * <p>
 * 我们是这样定义一个非递减数列的： 对于数组中所有的 i (1 <= i < n)，满足 array[i] <= array[i + 1]。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [4,2,3]
 * 输出: True
 * 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
 * 示例 2:
 * <p>
 * 输入: [4,2,1]
 * 输出: False
 * 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
 * 说明:  n 的范围为 [1, 10,000]。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/non-decreasing-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CheckPossibility {
    public static boolean checkPossibility(int[] nums) {
        boolean hasOne = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                if (!hasOne) {
                    //demo nums = {-1, 4, 2, 3}
                    //修改中间位置时:若修改降序位 nums[2],必须保证 nums[1]<=nums[3];
                    //修改中间位置时:若修改降序位的上一位 nums[1],必须保证 nums[0]<=nums[2];
                    if (i>1&&i < nums.length - 1 && (nums[i + 1] < nums[i - 1]&&nums[i]<nums[i-2])) return false;
                    hasOne = true;
                } else return false;
            }
        }
        return true;
    }

    public static void main(String[] a) {
        System.out.println(checkPossibility(new int[]{4, 2, 3}));
        System.out.println(checkPossibility(new int[]{4, 2, 1}));
        System.out.println(checkPossibility(new int[]{3, 4, 2, 3}));
        System.out.println(checkPossibility(new int[]{-1, 4, 2, 3}));
    }
}
