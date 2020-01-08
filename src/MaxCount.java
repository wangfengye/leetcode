/**
 * @author maple on 2020/1/8 15:02.
 * @version v1.0
 * @see 1040441325@qq.com
 * 598. 范围求和 II
 * 给定一个初始元素全部为 0，大小为 m*n 的矩阵 M 以及在 M 上的一系列更新操作。
 * <p>
 * 操作用二维数组表示，其中的每个操作用一个含有两个正整数 a 和 b 的数组表示，含义是将所有符合 0 <= i < a 以及 0 <= j < b 的元素 M[i][j] 的值都增加 1。
 * <p>
 * 在执行给定的一系列操作后，你需要返回矩阵中含有最大整数的元素个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * m = 3, n = 3
 * operations = [[2,2],[3,3]]
 * 输出: 4
 * 解释:
 * 初始状态, M =
 * [[0, 0, 0],
 * [0, 0, 0],
 * [0, 0, 0]]
 * <p>
 * 执行完操作 [2,2] 后, M =
 * [[1, 1, 0],
 * [1, 1, 0],
 * [0, 0, 0]]
 * <p>
 * 执行完操作 [3,3] 后, M =
 * [[2, 2, 1],
 * [2, 2, 1],
 * [1, 1, 1]]
 * <p>
 * M 中最大的整数是 2, 而且 M 中有4个值为2的元素。因此返回 4。
 */
public class MaxCount {
    //内存超上限
    public int maxCount(int m, int n, int[][] ops) {
        int[][] M = new int[m][n];
        for (int z = 0; z < ops.length; z++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i < ops[z][0] && j < ops[z][1]) {
                        M[i][j]++;
                    }
                }
            }
        }
        int max = -1;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (M[i][j] > max) {
                    max = M[i][j];
                    count = 1;
                } else if (M[i][j] == max) {
                    count++;
                }
            }
        }
        return count;
    }
    //每次+的是 ops[i][0]左侧  ops[i][1]上方,求出ops的op[0],op[1],即可得到加的次数最多的矩形
    public int maxCount2(int m, int n, int[][] ops) {
        for (int[] op: ops) {
            m = Math.min(m, op[0]);
            n = Math.min(n, op[1]);
        }
        return m * n;
    }

}
