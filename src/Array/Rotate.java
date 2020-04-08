package Array;

import java.util.Arrays;

/**
 * 面试题 01.07. 旋转矩阵
 * 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
 * <p>
 * 不占用额外内存空间能否做到？
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 给定 matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * 示例 2:
 * <p>
 * 给定 matrix =
 * [
 * [ 5, 1, 9,11],
 * [ 2, 4, 8,10],
 * [13, 3, 6, 7],
 * [15,14,12,16]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [15,13, 2, 5],
 * [14, 3, 4, 1],
 * [12, 6, 8, 9],
 * [16, 7,10,11]
 * ]
 */
public class Rotate {
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n-1 -i; j++) {
                //计算出一个位置旋转四次90度对应的位置,依次替换数值.
                int last = matrix[i][j];
                int tmp = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = last;
                last = tmp;
                tmp = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = last;
                last = tmp;
                tmp = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = last;
                last = tmp;
                matrix[i][j] = last;
            }
        }
    }

    public static void main(String[] args) {
      int[][] arr = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        arr = new int[][]{{5, 1, 9, 11},
                          {2, 4, 8, 10},
                          {13, 3, 6, 7},
                          {15, 14, 12, 16}};
        rotate(arr);
        System.out.println(arr2Str(arr));
    }

    public static String arr2Str(int[][] tmp) {
        StringBuilder builder = new StringBuilder();
        builder.append('[');
        for (int[] t : tmp) {
            builder.append("\n").append(Arrays.toString(t));
        }
        builder.append('\n').append(']');
        return builder.toString();

    }
}
