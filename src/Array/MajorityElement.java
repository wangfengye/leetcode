package Array;

import java.util.HashMap;
import java.util.Map;

/**
 * 169. 多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i <nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int res=0;

        for (Map.Entry<Integer, Integer> entry:map.entrySet()){
            if (entry.getValue()>nums.length/2){
                res=entry.getKey();
                return res;
            }
        }
        return res;
    }
    public int majorityElement2(int[] nums) {
        //摩尔投票法思路
        int cand_num=nums[0];
        int count =1;
        for (int i = 1; i < nums.length; i++) {
            if(cand_num==nums[i]){
                count++;
            }else {
                count--;
                if(count==0){
                    cand_num=nums[i];
                    count=1;
                }
            }
        }
        return cand_num;
    }
}
