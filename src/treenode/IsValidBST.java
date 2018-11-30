package treenode;

/**
 * @author maple on 2018/11/30 9:17.
 * @version v1.0
 * @see 1040441325@qq.com
 * 验证二叉搜索树
 * 假设一个二叉搜索树具有如下特征：
 * <p>
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 */
public class IsValidBST {
    public boolean isValidBST(TreeNode root) {
        return isValid(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    private boolean isValid(TreeNode root,long min,long max) {
        if (root == null) return true;
        if (root.val<=min||root.val>=max)return false;
        return isValid(root.left,min,root.val)&&isValid(root.right,root.val,max);

    }
}
