package Array;

/**
 * @author maple on 2019/7/10 11:09.
 * @version v1.0
 * @see 1040441325@qq.com
 * 303. 区域和检索 - 数组不可变
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 * <p>
 * 示例：
 * <p>
 * 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
 * <p>
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-sum-query-immutable
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumArray {
    int[] cache;

    public NumArray(int[] nums) {
        cache = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            cache[i + 1] = nums[i] + cache[i];
        }
    }

    public int sumRange(int i, int j) {
        return cache[j + 1] - cache[i];
    }
}
