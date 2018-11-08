package ListNode;

import java.util.Stack;

/**
 * 扁平化多级双向链表
 *
 */
public class Flatten {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {
        }

        public Node(int _val, Node _prev, Node _next, Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }

    public Node flatten(Node head) {
        if (head == null) return null;
        Node p = head;
        Stack<Node> s = new Stack<>();
        while (p != null) {
            if (p.child != null) {
                if (p.next!=null)s.push(p.next);
                p.next = p.child;
                if (p.next != null) p.next.prev = p;
                p.child = null;
            } else if (p.next == null && s.empty()) {
                p.next = s.pop();
                if (p.next != null) p.next.prev = p;
            }
            p = p.next;
        }
        return head;
    }
}
