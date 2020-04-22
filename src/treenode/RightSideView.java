package treenode;

import wbCompany.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 199. 二叉树的右视图
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 * <p>
 * 1            <---
 * /   \
 * 2     3         <---
 * \     \
 * 5     4       <---
 */
public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root==null)return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int len;//每行数量
        while ((len = queue.size()) > 0) {
            TreeNode node = null;
            for (int i = 0; i < len; i++) {
                node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            res.add(node.val);
        }
        return res;
    }
    public List<Integer> rightSideView1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root==null)return res;
        bfs(root,0,res);
        return res;
    }

    private void bfs(TreeNode root, int i, List<Integer> res) {
        if (root == null) return;
        if(i==res.size()){
            res.add(root.val);
        }
        bfs(root.right,i+1,res);
        bfs(root.left,i+1,res);
    }
}
