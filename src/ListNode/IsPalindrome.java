package ListNode;

/**
 * 回文链表
 * 请判断一个链表是否为回文链表。
 */
public class IsPalindrome {
    /**
     * 奇数链表 1 ->2->3->2 ->1
     * 求中点  3->2
     * 反转链表q:  3->1->2  p: 1->2->3->2
     * 比较 q.next 和 p 至 q为空
     *
     * 偶数链表 1->2->2->1
     * 求中点 2->2
     * 反转链表 q: 2->1->2   p:1->2->2
     * 比较 q.next 和 p 至 q为空
     */
    public boolean isPalindrome(ListNode head) {
        if (head==null||head.next==null)return true;
        ListNode middle = findMiddle(head);
        middle.next = reverseList(middle.next);
        ListNode p = head;
        ListNode q = middle.next;
        while (p != null && q != null && p.val == q.val) {
            p = p.next;
            q = q.next;
        }
        return q == null;
    }

    @SuppressWarnings("All")
    public ListNode reverseList(ListNode head) {
        if (head == null) return head;
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

    /**
     * 中点或偏左侧
     * @param head
     * @return
     */
    public ListNode findMiddle(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null&&fast.next!=null&&fast.next.next!=null && slow != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public static void main(String[] args){
        new IsPalindrome().isPalindrome(ListNode.createListNode(1,2));
    }
}
