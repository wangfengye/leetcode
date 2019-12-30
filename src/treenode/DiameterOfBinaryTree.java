package treenode;

import wbCompany.Tree;

/**
 * @author maple on 2019/12/30 13:58.
 * @version v1.0
 * @see 1040441325@qq.com
 * 543. 二叉树的直径
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
 *
 * 示例 :
 * 给定二叉树
 *
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diameter-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DiameterOfBinaryTree {
    private int res;
    public int diameterOfBinaryTree(TreeNode root) {
        res=0;
        getRadMax(root);
        return  res>0?res-1:0;
    }

    private int getRadMax(TreeNode root) {
        if(root==null){
            return 0;
        }else {
            int l=getRadMax(root.left);
            int r=getRadMax(root.right);
            res=Math.max(res,l+r+1);
            return Math.max(l,r)+1;
        }
    }
    public static void main(String[] args){
        TreeNode node = TreeNode.create(new int[]{1,2,3,4,5,6,7});
        node.show();
        System.out.println("树的直径:"+new DiameterOfBinaryTree().diameterOfBinaryTree(node));
    }
}
