/**
 * @author maple on 2019/5/29 14:33.
 * @version v1.0
 * @see 1040441325@qq.com
 * 按奇偶排序数组
 * 给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。
 * <p>
 * 你可以返回满足此条件的任何数组作为答案。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：[3,1,2,4]
 * 输出：[2,4,3,1]
 * 输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 5000
 * 0 <= A[i] <= 5000
 */
public class SortArrayByParity {
    public static int[] sortArrayByParity(int[] A) {
        int l = 0;
        int r = A.length - 1;
        while (l < r) {
            if (A[l] % 2 != 0) {
                while (l < r) {
                    if (A[r] % 2 == 0) {
                        int tmp = A[l];
                        A[l] = A[r];
                        A[r] = tmp;
                        l++;
                        r--;break;
                    } else {
                        r--;
                    }
                }
            } else {
                l++;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        sortArrayByParity(new int[]{1, 0, 3, 2, 4});
    }
}
