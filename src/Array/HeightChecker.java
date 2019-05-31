package Array;

import java.util.Arrays;

/**
 * @author maple on 2019/5/31 10:18.
 * @version v1.0
 * @see 1040441325@qq.com
 * 1051. 高度检查器
 * 学校在拍年度纪念照时，一般要求学生按照 非递减 的高度顺序排列。
 *
 * 请你返回至少有多少个学生没有站在正确位置数量。该人数指的是：能让所有学生以 非递减 高度排列的必要移动人数。
 *
 *
 *
 * 示例：
 *
 * 输入：[1,1,4,2,1,3]
 * 输出：3
 * 解释：
 * 高度为 4、3 和最后一个 1 的学生，没有站在正确的位置。
 */
public class HeightChecker {
    public int heightChecker(int[] heights) {
        int[] copy = Arrays.copyOf(heights,heights.length);
        Arrays.sort(copy);
        int diff=0;
        for (int i = 0; i <heights.length ; i++) {
            if (heights[i]!=copy[i])diff++;
        }
        return diff;
    }
}
