package ListNode;

/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 */
public class RotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        if (head ==null)return null;
        ListNode res = head;
        int len =1;
        while (head.next!=null){
            len++;
            head = head.next;
        }
        k= k%len;
        if (k ==0)return res;
        head.next = res;
        for (int i = 0; i < len-k-1; i++) {
            res = res.next;
        }
        ListNode result = res.next;
        res.next =null;
        return result;

    }
}
