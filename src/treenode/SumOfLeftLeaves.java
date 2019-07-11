package treenode;

/**
 * @author maple on 2019/7/11 10:02.
 * @version v1.0
 * @see 1040441325@qq.com
 * 404. 左叶子之和
 * 计算给定二叉树的所有左叶子之和。
 * <p>
 * 示例：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 */
public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root==null)return 0;
        sum = 0;
        dfs(root, false);
        return sum;
    }

    private int sum;

    private void dfs(TreeNode root, boolean b) {
        if (root.left != null) {
            dfs(root.left, true);
        }
        if (root.right != null) {
            dfs(root.right, false);
        }
        if (b && root.left == null && root.right == null) sum +=root.val;
    }
}
