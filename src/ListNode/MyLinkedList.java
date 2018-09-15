package ListNode;

/**
 * 设计链表
 */
public class MyLinkedList {

    Node node;
    int length;

    public MyLinkedList() {
        length = 0;
        node = null;
    }

    public int get(int index) {
        if (length > index && index > -1) {
            Node a = node;
            int counter = 0;
            while (counter != index) {
                a = a.next;
                counter++;
            }
            return a.val;
        } else {
            return -1;
        }
    }

    public void addAtHead(int val) {
        Node a = new Node(val);
        a.next = node;
        node = a;
        length++;
    }

    /**
     * 将值为 val 的节点追加到链表的最后一个元素
     *
     * @param val
     */
    public void addAtTail(int val) {
        if (length == 0) {
            addAtHead(val);
            return;
        }
        Node a = node;
        int counter = 0;
        while (a.next != null) {
            a = a.next;
        }
        a.next = new Node(val);
        length++;
    }

    public void addAtIndex(int index, int val) {
        if (index==0){
            addAtHead(val);
            return;
        }
        if (index ==length){
            addAtTail(val);
            return;
        }
        if (index>0&&index<length){
            int counter =0;
            Node a = node;
            while (counter!=index-1){
                a=a.next;
                counter++;
            }
            Node b = new Node(val);
            b.next = a.next;
            a.next = b;
            length++;
        }
    }

    public void deleteAtIndex(int index) {
        if (length > index && index > 0) {
            Node a = node;
            int counter =0;
            while (counter!=index-1){
                a =a.next;
                counter++;
            }
            a.next = a.next.next;
            length--;
        } else if (index == 0) {
            node = node.next;
            length--;
        }
    }

    public class Node {
        int val;
        Node next;

        Node(int x) {
            val = x;
        }
    }
}
