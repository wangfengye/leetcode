package treenode;

/**
 * 根据一棵树的中序遍历与后序遍历构造二叉树
 */
public class BuildTree23 {

    int index;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        index = postorder.length;
        return buildTreeStep(inorder, postorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeStep(int[] inorder, int[] postorder, int start, int end) {
        index--;
        int i = end;
        if (index < 0) return null;
        for (; i >= start; i--) {
            if (inorder[i] == postorder[index]) break;
        }
        if (i < start) return null;
        TreeNode root = new TreeNode(postorder[index]);
        if (end >= i + 1) {
            root.right = buildTreeStep(inorder, postorder, i + 1, end);
        }
        if (i - 1 >= start) {
            root.left = buildTreeStep(inorder, postorder, start, i-1);
            index--;
        }
        return root;
    }
}
