package treenode;

/**
 * 给定一个非空二叉树，返回其最大路径和
 */
public class MaxPathSum {
    int max = Integer.MIN_VALUE;

    /**
     * 分析: 结果必然 从某个根节点的左右两分支的和;
     * 即比较从各个根节点触发,左右两侧的最大路径,与两侧路径和比较,求最大值
     *
     * @param root
     * @return
     */
    public int maxPathSum(TreeNode root) {
        subMax(root);
        return max;
    }

    private int subMax(TreeNode node) {
        if (node == null) return 0;
        int left = subMax(node.left);
        int right = subMax(node.right);
        int maxS = Math.max(left + node.val, right + node.val);// 单侧最大长度
        int subMax = Math.max(maxS, left + right + node.val);
        if (max < subMax) max = subMax;
        return Math.max(maxS, node.val);
    }

    private int subMax1(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(0, subMax1(node.left));
        int right = Math.max(0, subMax1(node.right));
        max = Math.max(max, left + right + node.val);
        return Math.max(left, right) + node.val;
    }
}
