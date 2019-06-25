import java.util.*;

/**
 * @author maple on 2019/6/25 9:23.
 * @version v1.0
 * @see 1040441325@qq.com
 * <p>
 * 39. 组合总和
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * <p>
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 * [7],
 * [2,2,3]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> data = new ArrayList<>();
        Arrays.sort(candidates);
        due(candidates,target,new LinkedList<Integer>(),data,0);
        return data;
    }

    private void due(int[] candidates, int target, LinkedList<Integer> tmp, List<List<Integer>> data,int start) {
        for (int i = start; i <candidates.length; i++) {
            if (target == candidates[i]) {
                List<Integer> res = new LinkedList<>(tmp);
                res.add(target);
                data.add(res);
                break;
            } else if (target > candidates[i]) {
                tmp.add(candidates[i]);
                due(candidates, target - candidates[i], tmp, data,i);
                tmp.removeLast();
            } else {
                break;
            }
        }
    }
}
