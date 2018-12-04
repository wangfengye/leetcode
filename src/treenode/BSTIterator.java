package treenode;

import java.util.Stack;

/**
 * @author maple on 2018/12/3 9:07.
 * @version v1.0
 * @see 1040441325@qq.com
 * 二叉搜索树迭代器
 *
 * 实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
 * 调用 next() 将返回二叉搜索树中的下一个最小的数。
 * 注意: next() 和hasNext() 操作的时间复杂度是O(1)，并使用 O(h) 内存，其中 h 是树的高度
 */
public class BSTIterator {
    Stack<TreeNode> tree = new Stack<>();
    public BSTIterator(TreeNode root) {
        while (root!=null){
            tree.push(root);
            root =root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !tree.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode result = tree.pop();
        TreeNode current = result;
        //存储取出的节点的右子树
        if(current.right != null){
            current = current.right;
            while(current != null){
                tree.push(current);
                current = current.left;
            }
        }
        return result.val;
    }


}
