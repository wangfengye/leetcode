package ListNode;

/**
 * 反转链表
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if(head==null)return head;
        ListNode res = new ListNode(0);
        res.next = head;
        while (head.next != null) {
            ListNode node = head.next;
            head.next = node.next;
            node.next = res.next;
            res.next = node;
        }
        return res.next;
    }
}
