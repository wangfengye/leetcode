package treenode;

/**
 * 783. 二叉搜索树结点最小距离
 * 给定一个二叉搜索树的根结点 root, 返回树中任意两节点的差的最小值。
 * <p>
 * 示例：
 * <p>
 * 输入: root = [4,2,6,1,3,null,null]
 * 输出: 1
 * 解释:
 * 注意，root是树结点对象(TreeNode object)，而不是数组。
 * <p>
 * 给定的树 [4,2,6,1,3,null,null] 可表示为下图:
 * <p>
 * 4
 * /   \
 * 2      6
 * / \
 * 1   3
 * <p>
 * 最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值。
 */
public class MinDiffInBST {
    int min;
    int last;
    boolean first;

    public int minDiffInBST(TreeNode root) {
        min = Integer.MAX_VALUE;
        last = 0;
        first = false;
        bfs(root);
        return min;
    }

    private void bfs(TreeNode root) {
        if(root==null)return;
        bfs(root.left);
        if (!first){
            last = root.val;
            first=true;
        }
        else {
            min = Math.min(root.val - last, min);
            last = root.val;
        }
        bfs(root.right);
    }

}
