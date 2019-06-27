package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author maple on 2019/6/27 9:01.
 * @version v1.0
 * @see 1040441325@qq.com
 * 40. 组合总和 II
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用一次。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * <p>
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 */
public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, new ArrayList<>(), lists, 0);
        return lists;
    }

    private void dfs(int[] candidates, int target, ArrayList<Integer> tmp, List<List<Integer>> lists, int left) {
        int used = -1;
        for (int i = left; i < candidates.length; i++) {
            if (candidates[i] == target) {
                tmp.add(candidates[i]);
                lists.add(new ArrayList<>(tmp));
                tmp.remove(tmp.size() - 1);
                break;
            } else if (candidates[i] > target) {
                break;
            } else {
                if (used==candidates[i])continue;
                used = candidates[i];
                tmp.add(candidates[i]);
                dfs(candidates, target - candidates[i], tmp, lists, i + 1);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
