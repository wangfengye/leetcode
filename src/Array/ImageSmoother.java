package Array;

/**
 * @author maple on 2019/6/27 9:14.
 * @version v1.0
 * @see 1040441325@qq.com
 * 661. 图片平滑器
 * 包含整数的二维矩阵 M 表示一个图片的灰度。你需要设计一个平滑器来让每一个单元的灰度成为平均灰度 (向下舍入) ，平均灰度的计算是周围的8个单元和它本身的值求平均，如果周围的单元格不足八个，则尽可能多的利用它们。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [[1,1,1],
 * [1,0,1],
 * [1,1,1]]
 * 输出:
 * [[0, 0, 0],
 * [0, 0, 0],
 * [0, 0, 0]]
 * 解释:
 * 对于点 (0,0), (0,2), (2,0), (2,2): 平均(3/4) = 平均(0.75) = 0
 * 对于点 (0,1), (1,0), (1,2), (2,1): 平均(5/6) = 平均(0.83333333) = 0
 * 对于点 (1,1): 平均(8/9) = 平均(0.88888889) = 0
 * 注意:
 * <p>
 * 给定矩阵中的整数范围为 [0, 255]。
 * 矩阵的长和宽的范围均为 [1, 150]。
 */
public class ImageSmoother {
    public int[][] imageSmoother(int[][] M) {
        int[][] R = new int[M.length][M[0].length];
        for (int i = 0; i < R.length; i++) {
            for (int j = 0; j < R[i].length; j++) {
                R[i][j] = getArea(M, i, j);
            }
        }
        return R;
    }

    private int getArea(int[][] M, int x, int y) {
        int sum = 0;int count =0;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i >= 0 && i < M.length && j >= 0 && j < M[i].length) {
                    sum += M[i][j];count++;
                }
            }
        }
        return sum / count;
    }
}
