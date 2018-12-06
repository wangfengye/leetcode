package nTreenode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author maple on 2018/12/6 9:13.
 * @version v1.0
 * @see 1040441325@qq.com
 * N-ary Tree Preorder Traversal
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 */
public class Preporder {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        pre(root,list);
        return list;
    }

    private void pre(Node root, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        for (Node node : root.children) {
            preorder(node);
        }

    }
}
