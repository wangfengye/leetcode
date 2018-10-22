package Array;

/**
 * 对角线遍历
 */
public class FindDiagonalOrder {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return new int[0];
        int m = matrix.length, n = matrix[0].length, r = 0, c = 0;
        int[] res = new int[m * n];
        for (int i = 0; i < m * n; ++i) {
            res[i] = matrix[r][c];
            if ((r + c) % 2 == 0) {
                if (c == n - 1) {
                    ++r;
                } else if (r == 0) {
                    ++c;
                } else {
                    --r;
                    ++c;
                }
            } else {
                if (r == m - 1) {
                    ++c;
                } else if (c == 0) {
                    ++r;
                } else {
                    ++r;
                    --c;
                }
            }
        }
        return res;
    }

    public int[] findDiagonalOrder1(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return new int[0];
        int m = matrix.length, n = matrix[0].length, r = 0, c = 0;
        int[] res = new int[m * n];
        boolean flag = true; // true: ↗;false:↙
        for (int i = 0; i < m * n; i++) {
            res[i] = matrix[r][c];
            if (flag) {//右上
                if (r == 0 && c != n - 1) {
                    c++;
                    flag = false;
                } else if (c == n - 1) {
                    r++;
                    flag = false;
                } else {
                    r--;
                    c++;
                }
            } else {
                if (c == 0 && r != m - 1) {
                    r++;
                    flag = true;
                } else if (r == m - 1) {
                    c++;
                    flag = true;
                } else {
                    r++;
                    c--;
                }
            }
        }
        return res;
    }
}
