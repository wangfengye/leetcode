package Array;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author maple on 2019/6/27 9:28.
 * @version v1.0
 * @see 1040441325@qq.com
 * 835. 图像重叠
 * 给出两个图像 A 和 B ，A 和 B 为大小相同的二维正方形矩阵。（并且为二进制矩阵，只包含0和1）。
 * <p>
 * 我们转换其中一个图像，向左，右，上，或下滑动任何数量的单位，并把它放在另一个图像的上面。之后，该转换的重叠是指两个图像都具有 1 的位置的数目。
 * <p>
 * （请注意，转换不包括向任何方向旋转。）
 * <p>
 * 最大可能的重叠是什么？
 * <p>
 * 示例 1:
 * <p>
 * 输入：A = [[1,1,0],
 * [0,1,0],
 *           [0,1,0]]
 *      B = [[0,0,0],
 *           [0,1,1],
 *           [0,0,1]]
 * 输出：3
 * 解释: 将 A 向右移动一个单位，然后向下移动一个单位。
 * 注意: 
 * <p>
 * 1 <= A.length = A[0].length = B.length = B[0].length <= 30
 * 0 <= A[i][j], B[i][j] <= 1
 */
public class LargestOverlap {
    public int largestOverlap(int[][] A, int[][] B) {
        int sumMax = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                int sum = getSameA(A, B, i, j);
                if (sum > sumMax) sumMax = sum;
            }
        }
        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < B[i].length; j++) {
                int sum = getSameB(A, B, i, j);
                if (sum > sumMax) sumMax = sum;
            }
        }
        return sumMax;
    }

    private int getSameA(int[][] A, int[][] B, int mx, int my) {
        int sum = 0;
        for (int i = mx; i < A.length && i - mx < B.length; i++) {
            for (int j = my; j < A[i].length && j - my < B[0].length; j++) {
                sum += (A[i][j] & B[i - mx][j - my]);
            }
        }
        return sum;
    }

    private int getSameB(int[][] A, int[][] B, int mx, int my) {
        int sum = 0;
        for (int i = mx; i < B.length && i - mx < A.length; i++) {
            for (int j = my; j < B[i].length && j - my < A[0].length; j++) {
                sum += (B[i][j] & A[i - mx][j - my]);
            }
        }
        return sum;
    }
}
