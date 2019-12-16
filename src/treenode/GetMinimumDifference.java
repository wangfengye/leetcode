package treenode;

/**
 * @author maple on 2019/12/16 9:43.
 * @version v1.0
 * @see 1040441325@qq.com
 * 530. 二叉搜索树的最小绝对差
 * 给定一个所有节点为非负值的二叉搜索树，求树中任意两节点的差的绝对值的最小值。
 *
 * 示例 :
 *
 * 输入:
 *
 *    1
 *     \
 *      3
 *     /
 *    2
 *
 * 输出:
 * 1
 *
 * 解释:
 * 最小绝对差为1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 * 注意: 树中至少有2个节点。
 */
public class GetMinimumDifference {
    /**
     * solution: 中序遍历是递增序列,遍历过程求出每个最小值.
     */
    private int last =-1;
    private int min=Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        last =-1;
        min=Integer.MAX_VALUE;
        midForeach(root);
        return min;
    }

    private void midForeach(TreeNode root){
        if (root==null)return;
        midForeach(root.left);
        if (last==-1){
            last=root.val;
        }else {
            min=Math.min(min,Math.abs(root.val-last));
            last=root.val;
        }
        midForeach(root.right);
    }
}
