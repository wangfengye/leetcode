package Array;

import java.util.Arrays;

/**
 * @author maple on 2019/12/16 14:36.
 * @version v1.0
 * @see 1040441325@qq.com
 * 532. 数组中的K-diff数对
 * 给定一个整数数组和一个整数 k, 你需要在数组里找到不同的 k-diff 数对。这里将 k-diff 数对定义为一个整数对 (i, j), 其中 i 和 j 都是数组中的数字，且两数之差的绝对值是 k.
 *
 * 示例 1:
 *
 * 输入: [3, 1, 4, 1, 5], k = 2
 * 输出: 2
 * 解释: 数组中有两个 2-diff 数对, (1, 3) 和 (3, 5)。
 * 尽管数组中有两个1，但我们只应返回不同的数对的数量。
 * 示例 2:
 *
 * 输入:[1, 2, 3, 4, 5], k = 1
 * 输出: 4
 * 解释: 数组中有四个 1-diff 数对, (1, 2), (2, 3), (3, 4) 和 (4, 5)。
 * 示例 3:
 *
 * 输入: [1, 3, 1, 5, 4], k = 0
 * 输出: 1
 * 解释: 数组中只有一个 0-diff 数对，(1, 1)。
 * 注意:
 *
 * 数对 (i, j) 和数对 (j, i) 被算作同一数对。
 * 数组的长度不超过10,000。
 * 所有输入的整数的范围在 [-1e7, 1e7]。
 */
public class FindPairs {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);

        int start = 0;
        int count = 0;
        int prev = 0x7fffffff;
        for (int i = 1; i < nums.length; i++) {
            if(prev == nums[start] || nums[i] - nums[start] > k) {
                start++;
                if (start != i) {
                    i--;
                }
            }else if (nums[i] - nums[start] == k) {
                prev = nums[start];
                start++;
                count++;
            }
        }
        return count;

    }
    public static void main(String[] args){
        System.out.println(new FindPairs().findPairs(new int[]{3,1,4,1,5},2));
        System.out.println(new FindPairs().findPairs(new int[]{1,2,3,4,5},1));
        System.out.println(new FindPairs().findPairs(new int[]{1,3,1,5,4},0));
    }
}
