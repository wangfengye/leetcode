import javaBase.HashMapTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 697. 数组的度
 * 给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。
 * <p>
 * 你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1, 2, 2, 3, 1]
 * 输出: 2
 * 解释:
 * 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
 * 连续子数组里面拥有相同度的有如下所示:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * 最短连续子数组[2, 2]的长度为2，所以返回2.
 * 示例 2:
 * <p>
 * 输入: [1,2,2,3,1,4,2]
 * 输出: 6
 */
public class FindShortestSubArray {
    public static int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int max = 0;

        ArrayList<Integer> tags = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() > max) {
                max = e.getValue();
                tags.clear();
                tags.add(e.getKey());
            } else if (e.getValue() == max) {
                tags.add(e.getKey());
            }
        }
        int minLen = Integer.MAX_VALUE;
        for (int tag : tags) {
            boolean start = false;
            int maxC = max;
            int len = 0;
            for (int num : nums) {
                if (start) {
                    len++;
                    if (tag == num) maxC--;
                } else {
                    if (num == tag) {
                        start = true;
                        maxC--;
                        len++;
                    }
                }
                if (maxC == 0) break;
            }
            minLen = Math.min(minLen, len);
        }
        return minLen;
    }
    //思路相似,主要用数组取代hashmap.进行统计
    public int fun2(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int minLen = nums.length;
        int max = 0;
        int min = 0;
        for(int x : nums){
            if( x > max ) max =x;
            if( x < min ) min = x;
        }

        int[] freq = new int[max - min +1];
        max = 0;
        for(int x : nums){
            freq[x-min]++;
            if(freq[x-min] > max) max = freq[x-min];
        }
        if(max  == 1) return 1;

        for(int i = 0; i < freq.length; i++){
            if(freq[i] == max){
                int l = 0;
                int r = nums.length-1;
                while(l < r){
                    if(nums[l] == i+min ){
                        if(nums[r] == i+min){
                            minLen = Math.min(r-l+1,minLen);
                            break;
                        }
                        else r--;
                    }
                    else l++;
                }
            }
        }
        return minLen;
    }
    public static void main(String[] args) {
        System.out.println(findShortestSubArray(new int[]{1, 2, 2, 3, 1}));
        System.out.println(findShortestSubArray(new int[]{1, 2, 2, 3, 1, 4, 2}));
    }
}
