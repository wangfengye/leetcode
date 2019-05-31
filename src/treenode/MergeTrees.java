package treenode;

/**
 * @author maple on 2019/5/31 9:45.
 * @version v1.0
 * @see 1040441325@qq.com
 * 617. 合并二叉树
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 * <p>
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
 */
public class MergeTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;
        if (t1 == null) t1 = new TreeNode(0);
        if (t2 == null) t2 = new TreeNode(0);
        t1.val += t2.val;
        if (t1.left != null || t2.left != null) {
            if (t1.left == null) t1.left = new TreeNode(0);
            mergeTrees(t1.left, t2.left);
        }
        if (t1.right != null || t2.right != null) {
            if (t1.right == null) t1.right = new TreeNode(0);
            mergeTrees(t1.right, t2.right);
        }
        return t1;
    }
    public TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
        if (t1==null)return t2;
        if (t2==null)return t1;
        t1.val+=t2.val;
        t1.left = mergeTrees(t1.left,t2.left);
        t1.right = mergeTrees(t1.right,t2.right);
        return t1;
    }
}
