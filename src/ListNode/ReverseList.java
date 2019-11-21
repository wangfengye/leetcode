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
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode res= new ListNode(0);
        res.next=head;
        ListNode reHead= res;
        for (int i = 0; i < m-1; i++) {
            reHead=reHead.next;
        }
        int i=m;
        head = reHead.next;
        while (i<n){
            ListNode node = head.next;
            head.next = node.next;
            node.next = reHead.next;
            reHead.next = node;
            i++;
        }
        return res.next;
    }
    public static void main(String[] args){
        System.out.println(reverseBetween(ListNode.createListNode(1,2,3,4,5),2,4).toString());
    }
}
