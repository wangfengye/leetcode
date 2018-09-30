package ListNode;

public class SortList {
    public ListNode sortList(ListNode head) {
        ListNode node = new ListNode(0);
       node.next = head;
        sort(node, null);
        return node.next;
    }

    //3 1 2 5 4 6 9 7 10 8
    // (from,to)左开,右开区间
    //二分法
    private void sort(ListNode from, ListNode to) {
        if (from == null || from == to || from.next == to || from.next.next == to) return;
        int v = from.next.val;
        ListNode mid = from;
        ListNode equal = from.next;
        ListNode node = from.next;
        while (node.next != to) {
            if (node.next.val < v) {//交互位置
                ListNode currentNext = node.next.next;
                ListNode midNext = mid.next;
                mid.next = node.next;
                node.next.next = midNext;
                node.next = currentNext;
                mid = mid.next;
            } else if (node.next.val == v) {
                if (equal == node) {
                    equal = node.next;
                    node = node.next;
                } else {
                    ListNode nodeNext = node.next.next;
                    ListNode equalNext = equal.next;
                    equal.next = node.next;
                    node.next.next = equalNext;
                    node.next = nodeNext;
                    equal = equal.next;

                }
            } else {
                node = node.next;
            }
        }
        sort(from, mid.next);
        sort(equal, to);
    }

    public static void main(String[] args) {
        new SortList().sortList(ListNode.createListNode(4, 1, 3, 2));
    }
}
