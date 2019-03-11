package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author maple on 2019/3/11 14:56.
 * @version v1.0
 * @see 1040441325@qq.com
 * <p>
 * 最大数
 * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [10,2]
 * 输出: 210
 * 示例 2:
 * <p>
 * 输入: [3,30,34,5,9]
 * 输出: 9534330
 * 说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) return o2.compareTo(o1);
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        if ("0".equals(strs[0])) return "0";
        StringBuilder builder = new StringBuilder();
        for (String s : strs) {
            builder.append(s);
        }
        return builder.toString();
    }

}
