package treenode;

import nTreenode.Node;

/**
 * @author maple on 2019/5/31 9:21.
 * @version v1.0
 * @see 1040441325@qq.com
 * 938. 二叉搜索树的范围和
 * 给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。
 * <p>
 * 二叉搜索树保证具有唯一的值。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [10,5,15,3,7,null,18], L = 7, R = 15
 * 输出：32
 * 示例 2：
 * <p>
 * 输入：root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
 * 输出：23
 */
public class RangeSubBST {
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) return 0;
        if (root.val < L) return rangeSumBST(root.right, L, R);
        else if (root.val > R) return rangeSumBST(root.left, L, R);
        else return rangeSumBST(root.right, L, R) + rangeSumBST(root.left, L, R) + root.val;

    }
}
