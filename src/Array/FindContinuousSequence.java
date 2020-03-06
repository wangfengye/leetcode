package Array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 面试题57 - II. 和为s的连续正数序列
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * <p>
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 * <p>
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 *  
 * <p>
 * 限制：
 * <p>
 * 1 <= target <= 10^5
 */
public class FindContinuousSequence {
    public int[][] findContinuousSequence(int target) {
        ArrayList<int[]> results = new ArrayList<>();
        int sum = 1;
        int lastIndex = 1;
        for (int i = 2; i <= target / 2 + 1; i++) {
            sum += i;
            if (sum > target) {
                while (sum > target) {
                    sum -= lastIndex;
                    lastIndex++;
                }
            }
            if (sum == target) {
                int[] tmp = new int[i - lastIndex+1];
                for (int j = 0; j < tmp.length; j++) {
                    tmp[j] = lastIndex + j;
                }
                results.add(tmp);
            }
        }
        int[][] resArray = new int[results.size()][];
        return results.toArray(resArray);
    }

    public static void main(String[] args) {
        int[][] a = new FindContinuousSequence().findContinuousSequence(9);
        for (int i = 0; i < a.length; i++) {
            int[] b = a[i];

            System.out.println(Arrays.toString(b));
        }
        System.out.println("**************");
        a = new FindContinuousSequence().findContinuousSequence(15);
        for (int i = 0; i < a.length; i++) {
            int[] b = a[i];

            System.out.println(Arrays.toString(b));
        }
        System.out.println("**************");
    }
}
