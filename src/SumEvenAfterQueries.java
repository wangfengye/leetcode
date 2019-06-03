/**
 * @author maple on 2019/6/3 11:22.
 * @version v1.0
 * @see 1040441325@qq.com
 * 985. 查询后的偶数和
 * 给出一个整数数组 A 和一个查询数组 queries。
 * <p>
 * 对于第 i 次查询，有 val = queries[i][0], index = queries[i][1]，我们会把 val 加到 A[index] 上。然后，第 i 次查询的答案是 A 中偶数值的和。
 * <p>
 * （此处给定的 index = queries[i][1] 是从 0 开始的索引，每次查询都会永久修改数组 A。）
 * <p>
 * 返回所有查询的答案。你的答案应当以数组 answer 给出，answer[i] 为第 i 次查询的答案。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：A = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
 * 输出：[8,6,2,4]
 * 解释：
 * 开始时，数组为 [1,2,3,4]。
 * 将 1 加到 A[0] 上之后，数组为 [2,2,3,4]，偶数值之和为 2 + 2 + 4 = 8。
 * 将 -3 加到 A[1] 上之后，数组为 [2,-1,3,4]，偶数值之和为 2 + 4 = 6。
 * 将 -4 加到 A[0] 上之后，数组为 [-2,-1,3,4]，偶数值之和为 -2 + 4 = 2。
 * 将 2 加到 A[3] 上之后，数组为 [-2,-1,3,6]，偶数值之和为 -2 + 6 = 4。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * 1 <= queries.length <= 10000
 * -10000 <= queries[i][0] <= 10000
 * 0 <= queries[i][1] < A.length
 */
public class SumEvenAfterQueries {

    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int sum = 0;
        int[] res = new int[queries.length];
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) sum += A[i];
        }
        for (int i = 0; i < queries.length; i++) {
            int[] q = queries[i];
            int tmp = q[0] + A[q[1]];
            if (tmp % 2 == 0) {
                if (q[0] % 2 == 0) {

                    A[q[1]] += q[0];
                    sum += q[0];
                } else {
                    A[q[1]] += q[0];
                    sum += A[q[1]];
                }
            } else {
                if (q[0] % 2 == 0) {
                    A[q[1]] += q[0];
                } else {
                    sum -= A[q[1]];
                    A[q[1]] += q[0];
                }
            }
            res[i] = sum;
        }
        return res;
    }

    public int[] sumEvenAfterQueries2(int[] A, int[][] queries) {
        int sum = 0;
        int[] res = new int[queries.length];
        for (int a : A) {
            sum += ((a + 1) & 1) * a;
        }
        for (int i = 0; i < queries.length; i++) {
            int[] q = queries[i];
            sum -= ((A[q[1]] + 1) & 1) * A[q[1]];
            A[q[1]] += q[0];
            sum += ((A[q[1]] + 1) & 1) * A[q[1]];
            res[i] = sum;
        }
        return res;
    }
}
