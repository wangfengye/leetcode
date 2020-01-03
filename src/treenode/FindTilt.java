package treenode;

/**
 * @author maple on 2020/1/2 17:36.
 * @version v1.0
 * @see 1040441325@qq.com
 * 563. 二叉树的坡度
 * 给定一个二叉树，计算整个树的坡度。
 *
 * 一个树的节点的坡度定义即为，该节点左子树的结点之和和右子树结点之和的差的绝对值。空结点的的坡度是0。
 *
 * 整个树的坡度就是其所有节点的坡度之和。
 */
public class FindTilt {
    public int findTilt(TreeNode root) {
        sum=0;
        getDiff(root);
        return sum;
    }
    int sum;
    public int getDiff(TreeNode root){
        if (root==null)return 0;
        int left = getDiff(root.left);
        int right = getDiff(root.right);
        sum+=Math.abs(right-left);
        return left+right+root.val;
    }
}
