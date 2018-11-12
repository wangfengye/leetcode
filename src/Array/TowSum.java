package Array;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和 II - 输入有序数组
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 *
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 *
 * 说明:
 *
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 */
public class TowSum {
    /**
     *
     * @param numbers
     * @param target
     * @return 返回下标 从1开始
     */
    public int[] twoSum(int[] numbers, int target) {
        int i=0;
        int j=numbers.length-1;
        while (i<j){
            if (numbers[i]+numbers[j]==target)return new int[]{i+1,j+1};
            if (numbers[i]+numbers[j]<target)i++;
            else j--;
        }
        return null;
    }

    /**
     *
     * @param nums
     * @param target
     * @return 返回下标,从0开始
     */
    public int[] twoSum1(int[] nums,int target){
        if(nums==null||nums.length<=1)return null;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp))return new int[]{i,map.get(temp)};
            map.put(nums[i],i);
        }
        return null;

    }
}
