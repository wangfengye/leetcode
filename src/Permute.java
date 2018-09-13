import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 */
public class Permute {
    public static   List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();

        List<Integer> a =new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            a.add(nums[i]);
        }
        getList(a,lists,new ArrayList<>(),nums.length);
        return lists;
    }
    public static void getList(List<Integer> nums, List<List<Integer>> lists,List<Integer> list,int len){

        for (int i =0; i < nums.size(); i++) {
            List<Integer> b = new ArrayList<>(nums);
            List<Integer> a = new ArrayList<>(list);
            a.add(nums.get(i));
            b.remove(i);
            if (a.size() ==len) lists.add(a);
            else getList(b,lists,a,len);
        }
    }
    public static void main(String[] args){
        permute(new int[]{1,2,3});
    }

}
