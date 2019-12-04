package treenode;

/**
 * @author maple on 2019/12/4 10:39.
 * @version v1.0
 * @see 1040441325@qq.com
 * 114. 二叉树展开为链表
 * 给定一个二叉树，原地将它展开为链表。
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *
 */
public class Flatten {
    public void flatten(TreeNode root){
        while (root!=null){
            if (root.left!=null){
                TreeNode ri=root.left;
                while (ri.right!=null)ri=ri.right;
                ri.right=root.right;
                root.right=root.left;
                root.left=null;
            }
            root=root.right;
        }
    }
}
