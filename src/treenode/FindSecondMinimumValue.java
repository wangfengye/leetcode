package treenode;

import wbCompany.Tree;

/**
 * @author maple on 2020/1/15 9:43.
 * @version v1.0
 * @see 1040441325@qq.com
 * 671. 二叉树中第二小的节点
 * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么这个节点的值不大于它的子节点的值。 
 * <p>
 * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * 2
 * / \
 * 2   5
 * / \
 * 5   7
 * <p>
 * 输出: 5
 * 说明: 最小的值是 2 ，第二小的值是 5 。
 * 示例 2:
 * <p>
 * 输入:
 * 2
 * / \
 * 2   2
 * <p>
 * 输出: -1
 * 说明: 最小的值是 2, 但是不存在第二小的值。
 */
public class FindSecondMinimumValue {
    public int findSecondMinimumValue(TreeNode root) {
        if (root.left == null) {
            return -1;
        }
        int l = root.left.val;
        if (root.left.val == root.val) {
            l = find(root.left);
        }
        int r = root.right.val;
        if (root.right.val == root.val) {
            r = find(root.right);
        }
        if (l == -1) return r;
        if (r == -1) return l;
        return Math.min(l, r);
    }

    public int find(TreeNode node) {
        if (node.left == null) {
            return -1;
        }
        int l = node.left.val;
        if (node.left.val == node.val) {
            l = find(node.left);
        }
        int r = node.right.val;
        if (node.right.val == node.val) {
            r = find(node.right);
        }
        if (l == -1) return r;
        if (r == -1) return l;
        return Math.min(l, r);
    }

    public static void main(String[] args) {
        System.out.println(new FindSecondMinimumValue().findSecondMinimumValue(TreeNode.create(new int[]{2, 2, 2})));
        System.out.println(new FindSecondMinimumValue().findSecondMinimumValue(TreeNode.create(new int[]{2, 2, 5, 2, 2, 5, 7})));
        TreeNode root = TreeNode.create(new int[]{1, 1, 3, 1, 1, 3, 4, 3, 1, 1, 1, 3, 8, 4, 8, 3, 3, 1, 6, 2, 1});
        // root.show();
        System.out.println(new FindSecondMinimumValue().findSecondMinimumValue(root));
    }
}
