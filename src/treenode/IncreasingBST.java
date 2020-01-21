package treenode;

/**
 * 897. 递增顺序查找树
 * 给定一个树，按中序遍历重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。
 */
public class IncreasingBST {
    static TreeNode node;
    public TreeNode increasingBST(TreeNode root) {
        node=new TreeNode(0);
        TreeNode log=node;
        build(root);
        return log.right;
    }

    private void build(TreeNode root) {
        if(root==null)return;
        build(root.left);
        node.right=new TreeNode(root.val);
        node=node.right;
        build(root.right);
    }
}
