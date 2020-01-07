package Array;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author maple on 2020/1/7 9:30.
 * @version v1.0
 * @see 1040441325@qq.com
 * 和谐数组是指一个数组里元素的最大值和最小值之间的差别正好是1。
 * 594. 最长和谐子序列
 * 现在，给定一个整数数组，你需要在所有可能的子序列中找到最长的和谐子序列的长度。
 *
 * 示例 1:
 *
 * 输入: [1,3,2,2,5,2,3,7]
 * 输出: 5
 * 原因: 最长的和谐数组是：[3,2,2,2,3].
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-harmonious-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindLHS {
    public int findLHS(int[] nums) {
        HashMap<Integer,Integer> map=new LinkedHashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int max=0;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            int rmp=entry.getValue()+map.getOrDefault(entry.getKey()+1,Integer.MIN_VALUE);
            if (rmp>max)max=rmp;
        }
        return max;
    }
}
