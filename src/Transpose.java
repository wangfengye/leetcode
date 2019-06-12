/**
 * @author maple on 2019/6/12 14:25.
 * @version v1.0
 * @see 1040441325@qq.com
 * 867. 转置矩阵
 * 给定一个矩阵 A， 返回 A 的转置矩阵。
 * <p>
 * 矩阵的转置是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
 */
public class Transpose {
    public int[][] transpose(int[][] A) {
        int B[][] = new int[A[0].length][A.length];
        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < A.length; j++) {
                B[i][j] = A[j][i];
            }
        }
        return B;
    }
}
