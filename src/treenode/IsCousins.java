package treenode;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author maple on 2019/6/21 10:00.
 * @version v1.0
 * @see 1040441325@qq.com
 * 993. 二叉树的堂兄弟节点
 * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 * <p>
 * 如果二叉树的两个节点深度相同，但父节点不同，则它们是一对堂兄弟节点。
 * <p>
 * 我们给出了具有唯一值的二叉树的根节点 root，以及树中两个不同节点的值 x 和 y。
 * <p>
 * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true。否则，返回 false。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2,3,4], x = 4, y = 3
 * 输出：false
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
 * 输出：true
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,2,3,null,4], x = 2, y = 3
 * 输出：false
 *  
 * <p>
 * 提示：
 * <p>
 * 二叉树的节点数介于 2 到 100 之间。
 * 每个节点的值都是唯一的、范围为 1 到 100 的整数
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cousins-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsCousins {
    public boolean isCousins(TreeNode root, int x, int y) {
        Object[] xf = findNode(root, x);
        Object[] yf = findNode(root, y);
        if (xf[0] == null || yf[0] == null) return false;
        return (int) xf[1] - (int) yf[1] == 0 && xf[0] != yf[0];
    }

    private Object[] findNode(TreeNode root, int x) {
        int depth = 0;
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);
        int len;
        while ((len = nodes.size()) > 0) {
            depth++;
            for (int i = 0; i < len; i++) {
                TreeNode node = nodes.poll();
                if (node.val == x) return new Object[]{node, depth};

                if (node.left != null) nodes.offer(node.left);
                if (node.right != null) nodes.offer(node.right);
            }

        }
        return new Object[]{null, 0};
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(3);
        TreeNode a2 = new TreeNode(4);
        TreeNode b2 = new TreeNode(5);
        root.left = a;
        root.right = b;
        a.right = a2;
        b.right = b2;
        System.out.println(new IsCousins().isCousins(root, 5, 4));
    }
}
