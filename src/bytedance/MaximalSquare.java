package bytedance;

/**
 * @author maple on 2019/2/20 11:26.
 * @version v1.0
 * @see 1040441325@qq.com
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 */
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int maxLen = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int len = getLen(i, j, matrix);
                if (len > maxLen) maxLen = len;
            }
        }
        return maxLen * maxLen;
    }

    private int getLen(int x, int y, char[][] matrix) {
        int len = 0;
        if (matrix[x][y] == '1') len = 1;
        while (x + len < matrix.length && y + len < matrix[x].length) {
            for (int i = 0; i <= len; i++) {
                if (matrix[x + len][y + i] != '1') return len;
                if (matrix[x + i][y + len] != '1') return len;
            }
            len++;
        }

        return len;
    }
}
