package treenode;

/**
 * @author maple on 2018/12/4 16:17.
 * @version v1.0
 * @see 1040441325@qq.com
 * Delete Node in a BST
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。
 * 返回二叉搜索树（有可能被更新）的根节点的引用
 */
public class DeleteNode {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (key<root.val){
            root.left=deleteNode(root.left,key);
        }else if (key>root.val){
            root.right = deleteNode(root.right,key);
        }else {
            if (root.left == null && root.right == null) return null;
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            int val = findMaxInLeftTree(root.left);//寻找左子树最大的叶子节点(该节点必无右子树)
            root.val = val;
            root.left = deleteNode(root.left, val);//这个删除的节点必然右子树不存在
        }
        return root;
    }
    private int findMaxInLeftTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.right == null){
            return root.val;
        }
        return findMaxInLeftTree(root.right);
    }

}
