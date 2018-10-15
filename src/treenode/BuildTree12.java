package treenode;

/**
 * 从前序与中序遍历序列构造二叉树
 */
public class BuildTree12 {
    int index;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        index = -1;
        return create(preorder, inorder, 0, inorder.length - 1);
    }

    private TreeNode create(int[] preorder, int[] inorder, int start, int end) {
        index++;
        int i = start;
        for (; i <= end; i++) {
            if (inorder[i] == preorder[index]) break;
        }
        if (i > end) return null;
        TreeNode root = new TreeNode(preorder[index]);
        if (i - 1 >= start) {
            root.left = create(preorder, inorder, start, i - 1);
        }
        if (i + 1 <= end) {
            root.right = create(preorder, inorder, i + 1, end);
        }
        return root;
    }
}
