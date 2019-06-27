package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author maple on 2019/6/27 9:21.
 * @version v1.0
 * @see 1040441325@qq.com
 * 216. 组合总和 III
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * <p>
 * 说明：
 * <p>
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * <p>
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 * <p>
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> lists = new ArrayList<>();
        int[] candidates = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        dfs(candidates, n, new ArrayList<>(), lists, 0, 1, k);
        return lists;
    }

    private void dfs(int[] candidates, int target, ArrayList<Integer> tmp, List<List<Integer>> lists, int left, int depth, int depthtarget) {
        if (depth > depthtarget) return;
        for (int i = left; i < candidates.length; i++) {
            if (candidates[i] == target) {
                if (depth == depthtarget) {
                    tmp.add(candidates[i]);
                    lists.add(new ArrayList<>(tmp));
                    tmp.remove(tmp.size() - 1);
                }
                break;
            } else if (candidates[i] > target) {
                break;
            } else {
                tmp.add(candidates[i]);
                dfs(candidates, target - candidates[i], tmp, lists, i + 1, depth + 1, depthtarget);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
