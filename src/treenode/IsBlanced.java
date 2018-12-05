package treenode;

/**
 * @author maple on 2018/12/5 9:20.
 * @version v1.0
 * @see 1040441325@qq.com
 * 平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 */
public class IsBlanced {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        if (Math.abs(leftDepth - rightDepth) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = maxDepth(root.left) + 1;
        int rightDepth = maxDepth(root.right) + 1;
        return Math.max(leftDepth, rightDepth);
    }
}
