package findtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 存在重复元素 II
 *
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，
 * 并且 i 和 j 的差的绝对值最大为 k
 */
public class ContainsNearbyDuplicate {
    public static boolean containsNearbyDuplicate(int[] nums,int k){
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < i+k+1; j++) {
                if (j>=nums.length)break;
                if (nums[i]==nums[j])return true;
            }
        }
        return false;
    }
    public static boolean containsNearbyDuplicate1(int[] nums,int k){
        if (k<1||nums.length<=1)return false;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])){
                if (k>= i- map.get(nums[i]))return true;
            }
            map.put(nums[i],i);
        }
        return false;
    }
    public static void main(String[] args){
        System.out.println(ContainsNearbyDuplicate.containsNearbyDuplicate1(new int[]{1,2,3,4,1,1},3));
    }
}
