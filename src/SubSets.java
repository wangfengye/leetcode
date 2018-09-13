import java.util.ArrayList;
import java.util.List;

/**
 *   子集
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 */
public class SubSets {
    public List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(new ArrayList<>());
        getList(nums,0,lists,new ArrayList<>());
        return lists;
    }
    public void getList(int[] nums,int len, List<List<Integer>> lists,List<Integer> list){
        if (len==nums.length)return;
        for (int i =len; i < nums.length; i++) {
            List<Integer> a = new ArrayList<>(list);
            a.add(nums[i]);
            lists.add(a);
            getList(nums,i+1,lists,a);
        }
    }
}
