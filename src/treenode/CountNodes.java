package treenode;

import wbCompany.Tree;

/**
 * 222. 完全二叉树的节点个数
 * 给出一个完全二叉树，求出该树的节点个数。
 * <p>
 * 说明：
 * <p>
 * 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * 1
 * / \
 * 2   3
 * / \  /
 * 4  5 6
 * <p>
 * 输出: 6
 */
public class CountNodes {
    public static void main(String[] args) {
        System.out.println(Math.pow(2,3));
        System.out.println(1<<3);
        System.out.println(new CountNodes().countNodes(TreeNode.create(1, 2, 3, 4, 5, 6)));
        System.out.println(new CountNodes().countNodes2(TreeNode.create(1, 2, 3, 4, 5, 6)));
    }

    public int countNodes(TreeNode root) {
        size = 0;
        bfs(root);
        return size;
    }

    int size = 0;

    private void bfs(TreeNode root) {
        if (root == null) {
            return;
        }
        size++;
        bfs(root.left);
        bfs(root.right);
    }

    /**
     * 二分
     *
     * @param root
     * @return
     */
    public int countNodes2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lDepth = getDepth(root.left);
        int rDepth = getDepth(root.right);
        if (lDepth == rDepth) {
            //右侧空
            return (1 << lDepth) + countNodes2(root.right);
        } else {
            return (1 << rDepth) + countNodes2(root.left);
        }

    }



    int getDepth(TreeNode root) {
        int Depth = 0;
        while (root != null) {
            Depth += 1;
            root = root.left;
        }
        return Depth;
    }

}
