package Array;

/**
 * @author maple on 2019/11/12 9:18.
 * @version v1.0
 * @see 1040441325@qq.com
 * 74. 搜索二维矩阵
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * <p>
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 示例 1:
 * <p>
 * 输入:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 13
 * 输出: false
 */
public class SearchMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int i = 0, j = 0;
        while (i < matrix.length && j < matrix[0].length) {
            if (matrix[i][j] == target) {
                return true;
            }
            if (matrix[i][j] > target) {
                return false;
            }
            if (i + 1 >= matrix.length) {
                j++;
            } else if (matrix[i + 1][j] == target) {
                return true;
            } else if (matrix[i + 1][j] < target) {
                i++;
            } else {
                j++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][]{{1, 3, 5, 7},
                        {10, 11, 16, 20},
                        {23, 30, 34, 50}},
                3));
        System.out.println(searchMatrix(new int[][]{{1, 3, 5, 7},
                        {10, 11, 16, 20},
                        {23, 30, 34, 50}},
                13));
        System.out.println(searchMatrix(new int[][]{{1}},
                2));
    }
}
