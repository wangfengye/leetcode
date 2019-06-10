import java.util.Arrays;

/**
 * @author maple on 2019/6/10 15:14.
 * @version v1.0
 * @see 1040441325@qq.com
 * 976. 三角形的最大周长
 * 给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。
 * <p>
 * 如果不能形成任何面积不为零的三角形，返回 0。
 */
public class LargestPerimeter {
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        int i = A.length - 1;
        while (i > 2) {
            if (A[i] >= (A[i - 1] + A[i - 2])) {
                i--;
            } else {
                return A[i] + A[i - 1] + A[i - 2];
            }
        }
        return 0;
    }
}
