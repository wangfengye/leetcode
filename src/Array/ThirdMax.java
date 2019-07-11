package Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author maple on 2019/7/11 10:09.
 * @version v1.0
 * @see 1040441325@qq.com
 * 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3, 2, 1]
 * <p>
 * 输出: 1
 * <p>
 * 解释: 第三大的数是 1.
 * 示例 2:
 * <p>
 * 输入: [1, 2]
 * <p>
 * 输出: 2
 * <p>
 * 解释: 第三大的数不存在, 所以返回最大的数 2 .
 * 示例 3:
 * <p>
 * 输入: [2, 2, 3, 1]
 * <p>
 * 输出: 1
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/third-maximum-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThirdMax {
    public int thirdMax(int[] nums) {
        int maxTmp[] = new int[3];
        Arrays.fill(maxTmp, Integer.MIN_VALUE);
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
            if (nums[i] == maxTmp[0] || nums[i] == maxTmp[1]) {
                continue;
            } else if (nums[i] > maxTmp[0]) {

                maxTmp[2] = maxTmp[1];
                maxTmp[1] = maxTmp[0];
                maxTmp[0] = nums[i];
            } else if (nums[i] > maxTmp[1]) {
                maxTmp[2] = maxTmp[1];
                maxTmp[1] = nums[i];
            } else if (nums[i] > maxTmp[2]) {

                maxTmp[2] = nums[i];
            }
        }
        return set.size() < 3
                ? maxTmp[0] : maxTmp[2];
    }
}
