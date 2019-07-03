package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author maple on 2019/7/3 9:24.
 * @version v1.0
 * @see 1040441325@qq.com
 * 47. 全排列 II
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,1,2]
 * 输出:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PermuteUnique {
    boolean[] used;
    List<List<Integer>> res;

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        used = new boolean[nums.length];
        res = new ArrayList<>();
        bfs(nums, used, new LinkedList<>());
        return res;
    }

    private void bfs(int[] nums, boolean[] used, LinkedList<Integer> tmp) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            if (i > 0&& !used[i-1] && nums[i] == nums[i - 1]) continue;
            used[i] = true;
            tmp.add(nums[i]);
            bfs(nums, used, tmp);
            used[i] = false;
            tmp.removeLast();
        }
    }

    public List<List<Integer>> permuteUnique2(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        permuteUnique(nums, 0, list);
        return list;
    }

    public void permuteUnique(int[] nums, int start, List<List<Integer>> list){
        if(start == nums.length - 1){
            List<Integer> tempList = new ArrayList<>(nums.length);
            for(int num: nums){
                tempList.add(num);
            }
            list.add(tempList);
        } else {
            // start < nums.length
            for(int i = start; i < nums.length; i++){
                // do not do useless swap
                boolean isContinue = false;
                for(int j = start; j < i; j++){// 包含两种情况, 交换的双方重复,本次遍历中出现重复的交换
                    if(nums[j] == nums[i]){
                        isContinue = true;
                        break;
                    }
                }
                if(isContinue){
                    continue;
                }

                swap(nums, start, i);
                permuteUnique(nums, start + 1, list);
                swap(nums, start, i);
            }
        }

    }

    public void swap(int a[], int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
