package Array;

import java.util.Arrays;

/**
 * @author maple on 2020/1/3 9:25.
 * @version v1.0
 * @see 1040441325@qq.com
 * 566. 重塑矩阵
 * 在MATLAB中，有一个非常有用的函数 reshape，它可以将一个矩阵重塑为另一个大小不同的新矩阵，但保留其原始数据。
 * <p>
 * 给出一个由二维数组表示的矩阵，以及两个正整数r和c，分别表示想要的重构的矩阵的行数和列数。
 * <p>
 * 重构后的矩阵需要将原始矩阵的所有元素以相同的行遍历顺序填充。
 * <p>
 * 如果具有给定参数的reshape操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵
 */
public class MatrixReshape {
    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        int rS = nums.length;
        if (rS == 0) return new int[0][0];
        int cS = nums[0].length;
        if (rS * cS != r * c) {
            //操作不可行,输出源矩阵
            return nums;
        }
        int rId = 0;
        int cId = 0;
        int res[][] = new int[r][c];
        for (int i = 0; i < rS; i++) {
            for (int j = 0; j < cS; j++) {
                res[rId][cId] = nums[i][j];
                cId++;
                if (cId == c) {
                    cId = 0;
                    rId++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int source[][] = {{1, 2}, {3, 4}};
        show(source);
        show(matrixReshape(source, 1, 4));
        show(matrixReshape(source, 2, 4));
    }

    public static void show(int[][] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.print(data[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
