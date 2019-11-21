package Array;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author maple on 2019/11/19 16:31.
 * @version v1.0
 * @see 1040441325@qq.com
 * 0. 子集 II
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: [1,2,2]
 * 输出:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 *
 */
public class SubsetsWithDup {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res =new ArrayList<>();
        List<Integer > tmp = new ArrayList<>();
        add(nums,res,tmp,0);
        return res;
    }

    private void add(int[] nums, List<List<Integer>> res, List<Integer> tmp,int start) {
        res.add(new ArrayList<>(tmp));
        if (start>=nums.length)return;
        tmp.add(nums[start]);
        add(nums,res,tmp,start+1);
        tmp.remove(tmp.size()-1);
        for (int i = start+1; i < nums.length; i++) {
            if (nums[i]>nums[i-1]){
                tmp.add(nums[i]);
                add(nums,res,tmp,i+1);
                tmp.remove(tmp.size()-1);
            }
        }
    }
    public static void main(String[] args){
        List<List<Integer>> data = new SubsetsWithDup().subsetsWithDup(new int[]{1, 2, 2});
        for (List<Integer> list:data){
            System.out.print("[");
            for(Integer a:list){
                System.out.print(a+",");
            }
            System.out.print("]\n");
        }
    }
}
