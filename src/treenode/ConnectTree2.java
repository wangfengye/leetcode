package treenode;

/**
 * 每个节点的右向指针 II
 */
public class ConnectTree2 {
    public void connect(TreeNode root) {
        if (root == null) return;
        TreeNode q = null;
        TreeNode p = root;
        // 遍历处理root下一层的节点,为其添加next
        while (root != null) {
            if (root.left != null) {
                q = next(q, root.left);
            }
            if (root.right != null) {
                q = next(q, root.right);
            }
            root = root.next;
        }
        // 寻找下一层的第一个元素
        while (p != null) {
            if (p.left != null) {
                connect(p.left);
                break;
            } else if (p.right != null) {
                connect(p.right);
                break;
            } else {
                p = p.next;
            }
        }
    }

    private TreeNode next(TreeNode q, TreeNode r) {
        if (q == null) {
            q = r;
        } else if (q.next == null) {
            q.next = r;
            q = q.next;
        }
        return q;
    }
}
