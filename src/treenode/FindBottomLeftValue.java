package treenode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author maple on 2019/6/13 11:31.
 * @version v1.0
 * @see 1040441325@qq.com
 * 513. 找树左下角的值
 * 给定一个二叉树，在树的最后一行找到最左边的值。
 */
public class FindBottomLeftValue {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int min = 0;
        queue.add(root);
        while (queue.size() > 0) {
            int len = queue.size();
            min = queue.peek().val;
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) queue.add(node.right);
            }
        }
        return min;
    }
}
