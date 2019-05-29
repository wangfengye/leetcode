/**
 * @author maple on 2019/5/29 10:24.
 * @version v1.0
 * @see 1040441325@qq.com
 * 977. 有序数组的平方
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 示例 2：
 * <p>
 * 输入：[-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A 已按非递减顺序排序。
 */
public class SortedSquares {
    public int[] sortedSquares(int[] A) {
        int mid = 0;//以 0 为分界线
        for (int i = 0; i < A.length; i++) {
            if (A[i] >= 0) {
                mid = i;
                break;
            }
        }
        int l = mid - 1;
        int r = mid;
        mid = 0;//作为新数组插入id记录
        int[] res = new int[A.length];
        while (l >= 0 || r < A.length) {
            if (l < 0) {
                res[mid] = A[r] * A[r];
                r++;
            } else if (r >= A.length) {
                res[mid] = A[l] * A[l];
                l--;
            } else {
                if (-A[l] > A[r]) {
                    res[mid] = A[r] * A[r];
                    r++;
                } else {
                    res[mid] = A[l] * A[l];
                    l--;
                }
            }
            mid++;
        }
        return res;
    }
}
