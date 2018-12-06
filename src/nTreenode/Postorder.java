package nTreenode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author maple on 2018/12/6 9:20.
 * @version v1.0
 * @see 1040441325@qq.
 * N-ary Tree Postorder Traversal
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 */
public class Postorder {
    public List<Integer> postorder(Node root) {
        if (root == null) return new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        post(root, list);
        return list;
    }

    private void post(Node root, ArrayList<Integer> list) {
        for (Node node :
                root.children) {
            post(node, list);
        }
        list.add(root.val);
    }
}
