package treenode;

import ListNode.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author maple on 2019/7/11 15:38.
 * @version v1.0
 * @see 1040441325@qq.com
 * 437. 路径总和 III
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 * <p>
 * 找出路径和等于给定数值的路径总数。
 * <p>
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * <p>
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 * <p>
 * 示例：
 * <p>
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 * <p>
 * 10
 * /  \
 * 5   -3
 * / \    \
 * 3   2   11
 * / \   \
 * 3  -2   1
 * <p>
 * 返回 3。和等于 8 的路径有:
 * <p>
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3.  -3 -> 11
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PathSum {
    int pathCount;

    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        pathCount = 0;
        dfsA(root, sum);
        return pathCount;
    }

    private void dfsA(TreeNode root, int sum) {
        dfs(root, sum);
        if (root.left != null) dfsA(root.left, sum);
        if (root.right != null) dfsA(root.right, sum);
    }

    private void dfs(TreeNode root, int sum) {
        if (root.val == sum) {
            pathCount++;
        }
        if (root.left != null) dfs(root.left, sum - root.val);
        if (root.right != null) dfs(root.right, sum - root.val);
    }

    /**
     * 113. 路径总和 II
     * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
     * <p>
     * 说明: 叶子节点是指没有子节点的节点。
     * <p>
     * 示例:
     * 给定如下二叉树，以及目标和 sum = 22，
     * <p>
     * 5
     * / \
     * 4   8
     * /   / \
     * 11  13  4
     * /  \    / \
     * 7    2  5   1
     * 返回:
     * <p>
     * [
     * [5,4,11,2],
     * [5,8,4,5]
     * ]
     */
    public List<List<Integer>> pathSumII(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> tmp = new ArrayList<>();
        dfsII(root, tmp, sum, 0, res);
        return res;
    }

    private void dfsII(TreeNode root, ArrayList<Integer> tmp, int sum, int c, List<List<Integer>> res) {
        if (root != null) {
            tmp.add(root.val);
            if (root.left == null && root.right == null) {
                if (c + root.val == sum) {
                    res.add(new ArrayList<>(tmp));
                }
            } else {
                if (root.left != null) dfsII(root.left, tmp, sum, c + root.val, res);
                if (root.right != null) dfsII(root.right, tmp, sum, c + root.val, res);
            }
            tmp.remove(tmp.size() - 1);
        }
    }
}
