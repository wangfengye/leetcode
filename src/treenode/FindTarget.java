package treenode;

import wbCompany.Tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author maple on 2020/1/14 14:23.
 * @version v1.0
 * @see 1040441325@qq.com
 * 653. 两数之和 IV - 输入 BST
 * 给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 * <p>
 * 案例 1:
 * <p>
 * 输入:
 * 5
 * / \
 * 3   6
 * / \   \
 * 2   4   7
 * <p>
 * Target = 9
 * <p>
 * 输出: True
 *  
 * <p>
 * 案例 2:
 * <p>
 * 输入:
 * 5
 * / \
 * 3   6
 * / \   \
 * 2   4   7
 * <p>
 * Target = 28
 * <p>
 * 输出: False
 */
public class FindTarget {
    ArrayList<Integer> data;

    //转为数组操作
    public boolean findTarget1(TreeNode root, int k) {
        data = new ArrayList<>();
        bst(root);
        for (int i = 0; i < data.size(); i++) {
            for (int j = i + 1; j < data.size(); j++) {
                if (data.get(i) + data.get(j) == k) return true;
            }
        }
        return false;
    }

    private void bst(TreeNode root) {
        if (root == null) return;
        bst(root.left);
        data.add(root.val);
        bst(root.right);
    }

    public boolean findTarget(TreeNode root, int k) {
        return findRoot(root, root, k);
    }

    private boolean findRoot(TreeNode node, TreeNode root, int k) {
        if (node == null) return false;
        TreeNode node1 = find(root, k - node.val);
        if (node1 != null && node != node1) {
            return true;
        }
        return findRoot(node.left, root, k) || findRoot(node.right, root, k);

    }

    private TreeNode find(TreeNode root, int i) {
        if (root == null) return null;
        if (root.val == i) return root;
        if (root.val < i) return find(root.right, i);
        return find(root.left, i);

    }

}
