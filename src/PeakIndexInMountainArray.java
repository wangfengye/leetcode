/**
 * @author maple on 2019/5/29 15:40.
 * @version v1.0
 * @see 1040441325@qq.com
 * <p>
 * 852. 山脉数组的峰顶索引
 * 我们把符合下列属性的数组 A 称作山脉：
 * <p>
 * A.length >= 3
 * 存在 0 < i < A.length - 1 使得A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
 * 给定一个确定为山脉的数组，返回任何满足 A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1] 的 i 的值。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[0,1,0]
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：[0,2,1,0]
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= A.length <= 10000
 * 0 <= A[i] <= 10^6
 * A 是如上定义的山脉
 */
public class PeakIndexInMountainArray {
    public int peakIndexInMountainArray(int[] A) {
        // 直接遍历
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] > A[i + 1]) return i;
        }
        return A.length - 1;
    }

    public int peakIndexInMountainArray2(int[] A) {
        // 二分
        int l = 0;
        int r = A.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (A[mid] < A[mid - 1]) {
                r = mid;
            } else if (A[mid] < A[mid + 1]) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return l;

    }
}
