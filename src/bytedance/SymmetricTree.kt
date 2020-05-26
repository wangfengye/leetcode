package bytedance

import treenode.TreeNode

/**
 * 对称树
 */
class SymmetricTree {
    fun isSymmetric(root: TreeNode?): Boolean {
        return root == null || helper(root.left, root.right)
    }

    private fun helper(left: TreeNode, right: TreeNode): Boolean {
        if (left === right) return true
        return if (left.`val` != right.`val`) false else helper(left.left, right.right) && helper(left.right, right.left)
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val root = TreeNode.create(1, 2, 2, 3, 4, 4, 3)
            root.show()
            println("是否对称: " + SymmetricTree().isSymmetric(root))
        }
    }
}