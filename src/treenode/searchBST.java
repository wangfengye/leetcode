package treenode;

/**
 * @author maple on 2018/12/4 9:12.
 * @version v1.0
 * @see 1040441325@qq.com
 * Search in a Binary Search Tree
 * 给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。
 * 如果节点不存在，则返回 NULL。
 */
public class searchBST {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root==null)return null;
        if (root.val ==val)return root;
        if (val<root.val) return searchBST(root.left,val);
        return searchBST(root.right,val);
    }
}
