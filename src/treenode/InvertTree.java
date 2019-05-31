package treenode;

/**
 * @author maple on 2019/5/31 10:11.
 * @version v1.0
 * @see 1040441325@qq.com
 * 226. 翻转二叉树
 */
public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root==null)return root;
        TreeNode tmp =root.left;
        root.left=root.right;
        root.right =tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
