package treenode;

import sun.nio.cs.ext.MacHebrew;
import wbCompany.Tree;

/**
 * 687. 最长同值路径
 * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
 * <p>
 * 注意：两个节点之间的路径长度由它们之间的边数表示。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * <p>
 * 5
 * / \
 * 4   5
 * / \   \
 * 1   1   5
 * 输出:
 * <p>
 * 2
 * 示例 2:
 * <p>
 * 输入:
 * <p>
 * 1
 * / \
 * 4   5
 * / \   \
 * 4   4   5
 * 输出:
 * <p>
 * 2
 */
public class LongestUnivaluePath {
    private int max;

    public int longestUnivaluePath(TreeNode root) {
        max = 0;
        getLen(root);
        return max>0?max-1:0;
    }

    private int getLen(TreeNode root) {
        if (root == null) return 0;
        int left = getLen(root.left);
        int right = getLen(root.right);
        int res = 1;
        if (root.left != null && root.left.val == root.val) {
            res += left;
        }else {
            left=0;
        }
        if (root.right != null && root.right.val == root.val) {
            res += right;
        }else {
            right=0;
        }
        max=Math.max(max,res);
        return Math.max(left,right)+1;
    }
    public static void main(String[] args){
        System.out.println(new LongestUnivaluePath().longestUnivaluePath(TreeNode.create(new int[]{5,4,5,1,1,0,5})));
        System.out.println(new LongestUnivaluePath().longestUnivaluePath(TreeNode.create(new int[]{1,4,5,4,4,0,5})));
    }
}
