package treenode;

import wbCompany.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode next;

    public TreeNode(int x) {
        val = x;
    }

    /**
     * 传入数组 空值用-1表示.
     *
     * @param val 数组
     * @return 树根
     */
    public static TreeNode create(int... val) {
        TreeNode root = new TreeNode(val[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int index = 1;
        while (index < val.length) {
            int qL = queue.size();
            for (int i = 0; i < qL; i++) {
                TreeNode node = queue.poll();
                if (index >= val.length) break;
                node.left = new TreeNode(val[index]);
                queue.offer(node.left);
                index++;
                if (index >= val.length) break;
                node.right = new TreeNode(val[index]);
                queue.offer(node.right);
                index++;
            }
        }
        dfsRemoveFlag(root);
        return root;
    }

    private static void dfsRemoveFlag(TreeNode root) {
        if (root.left != null) {
            if (root.left.val == -1) {
                root.left = null;
            } else {
                dfsRemoveFlag(root.left);
            }
        }
        if (root.right != null) {
            if (root.right.val == -1) {
                root.right = null;
            } else {
                dfsRemoveFlag(root.right);
            }
        }
    }

    public void show() {
        show(this, 0);
    }

    private void show(TreeNode node, int i) {
        if (node == null) return;
        show(node.left, i + 1);
        for (int j = 0; j < i; j++) {
            System.out.print("\t");
        }
        System.out.println(node.val);

        show(node.right, i + 1);
    }
}
