package ListNode;

/**
 * 扁平化多级双向链表
 * todo: 未完成
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
        flat(head);
        return head;
    }
    private Node flat(Node head){
        if (head ==null) return null;
        if (head.child==null){
            if (head.next==null)return head;
            return flat(head);
        }else {
            Node child =head.child;
            Node next =head.next;
            head.next =child;
            child.prev =head;
            head.child = null;
            Node childtail = flat(child);
            if (next!=null){
                childtail.next =next;
                next.prev =childtail;
                return flat(next);
            }
            return childtail;
        }
    }
}
