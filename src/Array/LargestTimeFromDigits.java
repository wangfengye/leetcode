package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author maple on 2019/6/18 13:53.
 * @version v1.0
 * @see 1040441325@qq.com
 * 949. 给定数字能组成的最大时间
 * 给定一个由 4 位数字组成的数组，返回可以设置的符合 24 小时制的最大时间。
 * <p>
 * 最小的 24 小时制时间是 00:00，而最大的是 23:59。从 00:00 （午夜）开始算起，过得越久，时间越大。
 * <p>
 * 以长度为 5 的字符串返回答案。如果不能确定有效时间，则返回空字符串。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,3,4]
 * 输出："23:41"
 * 示例 2：
 * <p>
 * 输入：[5,5,5,5]
 * 输出：""
 *  
 * <p>
 * 提示：
 * <p>
 * A.length == 4
 * 0 <= A[i] <= 9
 */
public class LargestTimeFromDigits {
    public String largestTimeFromDigits(int[] A) {
        Arrays.sort(A);
        ArrayList<Integer> data = new ArrayList<>();
        for (int i = A.length - 1; i >= 0; i--) {
            for (int j = A.length - 1; j >= 0; j--) {
                if (j == i) continue;
                for (int k = A.length - 1; k >= 0; k--) {
                    if (k == j || k == i) continue;
                    for (int l = A.length - 1; l >= 0; l--) {
                        if (l == k || l == j || l == i) continue;
                        int hour = A[i] * 10 + A[j];
                        if (hour > 23) continue;
                        int minute = +A[k] * 10 + A[l];
                        if (minute > 59) continue;
                        String hourStr = hour > 9 ? String.valueOf(hour) : "0" + hour;
                        String minuteStr = minute > 9 ? String.valueOf(minute) : "0" + minute;
                        return hourStr + ":" + minuteStr;
                    }
                }
            }
        }
        return "";
    }


}
