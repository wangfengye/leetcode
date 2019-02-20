package bytedance;

import treenode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author maple on 2019/2/20 11:14.
 * @version v1.0
 * @see 1040441325@qq.com
 * 二叉树的锯齿形层次遍历
 *   二叉树的锯齿形层次遍历
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）
 */

public class ZigzagLevelOrder {
    /**
     * zigzag:蜿蜒(n. v. adj. adv.)
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root){
        List<List<Integer>> lists =new ArrayList<>();
        if (root==null)return lists;
        addWithFloor(0,root,lists);
        return lists;

    }
    private void addWithFloor(int floor,TreeNode node,List<List<Integer>> lists){
        if (lists.size()<=floor){
            lists.add(new ArrayList<>());
        }
        if (floor%2==0) lists.get(floor).add(node.val);
        else lists.get(floor).add(0,node.val);
        if (node.left!=null)addWithFloor(floor+1,node.left,lists);
        if (node.right!=null)addWithFloor(floor+1,node.right,lists);
    }
}
