package bytedance

/**
 * 221. 最大正方形
在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。

示例:

输入:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

输出: 4
 */
class MaximalSquarekt {
    fun maximalSquare(matrix: Array<CharArray>): Int {
        var maxLen = 0;
        for (i in matrix.indices) {
            for (j in matrix[i].indices) {
                maxLen = Math.max(maxLen, getLen(i, j, matrix));
            }
        }
        return maxLen * maxLen;
    }

    private fun getLen(x: Int, y: Int, matrix: Array<CharArray>): Int {
        var len = 0;
        while (true) {
            for (i in 0..len) {
                if (matrix[x+len][y + i] != '1') return len;
                if (matrix[x + i][y+len] != '1') return len;
            }
            len++;
            if (x + len >= matrix.size||y+len>=matrix[x].size) return len;
        }
    }
}