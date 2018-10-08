package treenode;

/**
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 */
public class KthSmallest {
    int counter = 0;
    int result = 0;

    public int kthSmallest(TreeNode root, int k) {

        add(root, k);
        return result;
    }

    /**
     * 中序遍历
     *
     * @param node
     * @param k
     */
    public void add(TreeNode node, int k) {
        if (node.left != null) {
            add(node.left, k);
        }
        if (counter >= k) return;
        result = node.val;
        counter++;
        if (node.right != null) {
            add(node.right, k);
        }
    }

}
