package treenode;

/**
 * @author maple on 2019/12/17 10:40.
 * @version v1.0
 * @see 1040441325@qq.com
 * 538. 把二叉搜索树转换为累加树
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 *
 * 例如：
 *
 * 输入: 二叉搜索树:
 *               5
 *             /   \
 *            2     13
 *
 * 输出: 转换为累加树:
 *              18
 *             /   \
 *           20     13
 *
 */
public class ConvertBST {
    public TreeNode convertBST(TreeNode root) {
        sum=0;
        bfs(root);
        return root;
    }
    private int sum=0;
    private void bfs(TreeNode root){
        if (root==null)return;
        //right
        bfs(root.right);
        //current;
        root.val+=sum;
        sum= root.val;
        //left;
        bfs(root.left);
    }
}
