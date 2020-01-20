package Array;

import java.util.ArrayList;

/**
 * 背包问题.
 * 将一组数分为差值最小的两组.
 * 主要思路是,动态归化,贪心思想,每次尽量装到最大值.
 */


public class AvgHigh {
    /**
     * f[i][v] 表示前i件物品放入可达的最大重量
     * f[i][v]=max{f[i-1][v],f[i-1][v-c[i]]+w[i]}
     */
    private static void avgNums(int[] nums) {

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int halfOfSum = sum / 2;
        int matrixFirstDimensionLen = nums.length + 1;
        int matrixSecondDimensionLen = halfOfSum + 1;
        int[][] matrix = new int[matrixFirstDimensionLen][matrixSecondDimensionLen];
        ArrayList<Integer>[][] lists = new ArrayList[matrixFirstDimensionLen][matrixSecondDimensionLen];
        for (int i = 0; i < lists.length; i++) {
            for (int j = 0; j < lists[i].length; j++) {
                lists[i][j] = new ArrayList<>();
            }

        }
        //arr的下标，是否与matrix的下标冲突:是的
        //matrix[i][j]定义：用前i个物体装 容量为j的背包能够装下的最大值
        //arr[i]定义：第i+1个物体的大小，所以arr[i-1]才是第i个物体的大小
        //遍历从矩阵边界开始（不包括边界），所以i = 1， j = 1
        for (int i = 1; i < matrixFirstDimensionLen; i++) {
            for (int j = 1; j < matrixSecondDimensionLen; j++) {

                //两种情况,1.,直接延用上一层最大值.
                //         2. 查看 上一层容量为 当前容量-当前节点值时,最大值
                // 1和 2+当前值比较,取大值.
                if (j - nums[i - 1] >= 0 && matrix[i - 1][j - nums[i - 1]] + nums[i - 1] > matrix[i - 1][j]) {

                    matrix[i][j] = matrix[i - 1][j - nums[i - 1]] + nums[i - 1];
                    lists[i][j].addAll(lists[i - 1][j - nums[i - 1]]);
                    lists[i][j].add(nums[i - 1]);
                } else {
                    matrix[i][j] = matrix[i - 1][j];
                    lists[i][j].addAll(lists[i - 1][j]);
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println("");
        }
        System.out.println(matrix[nums.length][halfOfSum]);
        for (int n : lists[nums.length][halfOfSum]) {
            System.out.print(n + "  ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        avgNums(new int[]{1, 0, 1, 7, 2, 4});
        avgNums(new int[]{2, 3, 4, 5});
    }
}
