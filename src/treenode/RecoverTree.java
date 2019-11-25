package treenode;

/**
 * @author maple on 2019/11/21 14:51.
 * @version v1.0
 * @see 1040441325@qq.com
 * 99. 恢复二叉搜索树
 * 二叉搜索树中的两个节点被错误地交换。
 * <p>
 * 请在不改变其结构的情况下，恢复这棵树。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,null,null,2]
 * <p>
 *    1
 *   /
 *  3
 *   \
 *    2
 * <p>
 * 输出: [3,1,null,null,2]
 * <p>
 *    3
 *   /
 *  1
 *   \
 *    2
 * 示例 2:
 * <p>
 * 输入: [3,1,4,null,null,2]
 * <p>
 * 3
 * / \
 * 1   4
 *    /
 *   2
 * <p>
 * 输出: [2,1,4,null,null,3]
 * <p>
 * 2
 * / \
 * 1   4
 *    /
 *  3
 * 进阶:
 * <p>
 * 使用 O(n) 空间复杂度的解法很容易实现。
 * 你能想出一个只使用常数空间的解决方案吗？
 */
public class RecoverTree {
    public void recoverTree(TreeNode root) {
        node = null;
        first = null;
        second = null;

        re(root);
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    TreeNode node = null;
    TreeNode first = null;
    TreeNode second = null;

    private void re(TreeNode root) {
        if (root.left != null) {
            re(root.left);
        }
        if (node == null) {
            node = root;
        } else {
            if (node.val > root.val) {
                if (first == null) {
                    first = node;
                    second=root;
                } else {
                    second = root;
                    return;
                }
            }
            node = root;
        }

        if (root.right != null) {
            re(root.right);
        }
    }
}
