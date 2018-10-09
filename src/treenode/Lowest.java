package treenode;

/**
 * 二叉树的最近公共祖先
 */
public class Lowest {
    /**
     * 分析: 自底向上, left,right,不为空是至少是其中一个的父节点,
     *  1.left,right 都不为空,则公共父节点是两者的共同父节点
     *  2.若只有一个不为空,则不空的那个为公共父节点
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;//两个节点中的一个
        TreeNode left = lowestCommonAncestor(root.left, p, q);//包含两个节点
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        return left == null ? right : left;
    }

}
