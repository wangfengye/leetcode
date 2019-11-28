import java.util.Stack;

/**
 * @author maple on 2019/11/28 12:02.
 * @version v1.0
 * @see 1040441325@qq.com
 * 给定一个整数序列：a1, a2, ..., an，一个132模式的子序列 ai, aj, ak 被定义为：当 i < j < k 时，ai < ak < aj。设计一个算法，当给定有 n 个数字的序列时，验证这个序列中是否含有132模式的子序列。
 * <p>
 * 注意：n 的值小于15000。
 * <p>
 * 示例1:
 * <p>
 * 输入: [1, 2, 3, 4]
 * <p>
 * 输出: False
 * <p>
 * 解释: 序列中不存在132模式的子序列。
 * 示例 2:
 * <p>
 * 输入: [3, 1, 4, 2]
 * <p>
 * 输出: True
 * <p>
 * 解释: 序列中有 1 个132模式的子序列： [1, 4, 2].
 * 示例 3:
 * <p>
 * 输入: [-1, 3, 2, 0]
 * <p>
 * 输出: True
 * <p>
 * 解释: 序列中有 3 个132模式的的子序列: [-1, 3, 2], [-1, 3, 0] 和 [-1, 2, 0].
 * 456. 132模式
 */
public class Find132pattern {
    public static boolean find132pattern(int[] nums) {
        if (nums.length < 3) return false;
        int last = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            last = Math.min(last, nums[i - 1]);
            if (nums[i] <= last) continue;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i] && nums[j] > last) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean find132pattern2(int[] nums) {
        int n = nums.length, top = n, third = Integer.MIN_VALUE;

        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < third) return true;
            // 从右侧取出比 nums[i]小的值,并用nums[i]覆盖 这保证i右侧非递减,
            // 即下面的while循环最后渠道的是右侧最大值.
            while (top < n && nums[i] > nums[top]) third = nums[top++];//次大值
            nums[--top] = nums[i];
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(find132pattern(new int[]{1, 2, 3, 4}));
        System.out.println(find132pattern(new int[]{3, 1, 4, 2}));
        System.out.println(find132pattern(new int[]{-1, 3, 2, 0}));
        System.out.println(find132pattern2(new int[]{1, 2, 3, 4}));
        System.out.println(find132pattern2(new int[]{3, 1, 4, 2}));
        System.out.println(find132pattern2(new int[]{-1, 3, 2, 0}));
    }
}
