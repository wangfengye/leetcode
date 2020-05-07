package treenode

/**
 * kt版  另一个树的子树
 */
class IsSubtree1 {
    fun isSubtree(s: TreeNode?, t: TreeNode?): Boolean {
        if (isSame(s, t)) return true;
        if (s == null) return false;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private fun isSame(s: TreeNode?, t: TreeNode?): Boolean {
        if (s == t) return true;
        if (s == null) return false;
        if (t == null) return false;
        if (s.`val` == t.`val`) {
            return isSame(s.left, t.left) && isSame(s.right, t.right);
        }
        return false;
    }
}