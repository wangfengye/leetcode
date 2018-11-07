package ListNode;

public class MyDoubleLinkedList {
    DoubleListNode head;
    DoubleListNode tail;

    public MyDoubleLinkedList() {
        this.head = new DoubleListNode(0);
        this.tail = new DoubleListNode(0);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int index) {
        DoubleListNode node = getNodeAtIndex(index);
        return (node == null || node == tail) ? -1 : node.val;
    }

    public DoubleListNode getNodeAtIndex(int index) {
        if (index < 0) return null;
        DoubleListNode temp = head;
        for (int i = 0; i <= index; i++) {
            temp = temp.next;
            if (temp == null) return null;
        }
        return temp;
    }

    public void addAtHead(int val) {
        DoubleListNode node = new DoubleListNode(val);
        node.pre = head;
        node.next = head.next;
        node.next.pre = node;
        head.next = node;
    }

    public void addAtTail(int val) {
        DoubleListNode node = new DoubleListNode(val);
        node.pre = tail.pre;
        node.next = tail;
        node.pre.next = node;
        tail.pre = node;
    }

    public void addAtIndex(int index, int val) {
        DoubleListNode node = getNodeAtIndex(index);
        if (node == null) return;
        if (node == tail) {
            addAtTail(val);
            return;
        }
        DoubleListNode newNode = new DoubleListNode(val);
        newNode.next = node;
        newNode.pre = node.pre;
        node.pre.next = newNode;
        node.pre = newNode;
    }

    public void deleteAtIndex(int index) {
        DoubleListNode node = getNodeAtIndex(index);
        if (node == null || node == tail) return;
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
    public static void main(String[] args){
        MyDoubleLinkedList nodes = new MyDoubleLinkedList();
        nodes.addAtHead(1);
        nodes.addAtTail(3);
        nodes.addAtIndex(1,2);
        System.out.println(nodes.get(1));
        nodes.deleteAtIndex(1);
        System.out.println(nodes.get(1));
    }
}


class DoubleListNode {
    int val;
    DoubleListNode pre;
    DoubleListNode next;

    public DoubleListNode(int val) {
        this.val = val;
    }
}