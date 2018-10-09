package treenode;

/**
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int left = Math.min(p.val, q.val);
        int right = Math.max(p.val, q.val);
        while (root != null) {
            if (root.val > right) {
                root = root.left;
                continue;
            }
            if (root.val < left) {
                root = root.right;
                continue;
            }
            return root;
        }
        return null;
    }
}
