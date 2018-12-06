package nTreenode;

import java.util.List;

/**
 * @author maple on 2018/12/6 9:12.
 * @version v1.0
 * @see 1040441325@qq.com
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
}
