package ListNode;

/**
 * @author maple on 2019/11/6 10:14.
 * @version v1.0
 * @see 1040441325@qq.com
 * 147. 对链表进行插入排序
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head==null)return null;
        ListNode res = new ListNode(0);
        res.next = head;

        int c = 0;
        head = head.next;
        for (; ; ) {

            ListNode sour = head;
            if (sour == null) break;
            head=head.next;
            c++;
            ListNode tmp = res;


            for (int i = 0; i < c; i++) {
                if (sour.val <= tmp.next.val) {
                    ListNode tmp1 = tmp.next;
                    tmp.next = sour;
                    sour.next = tmp1;
                    break;
                }
                if (i == c - 1) {
                    tmp.next.next = sour;
                    break;
                }
                tmp = tmp.next;
            }
        }
        ListNode rest = res;
        for (int i = 0; i <= c; i++) {
            rest = rest.next;
        }
        rest.next = null;
        return res.next;
    }

    public static void main(String[] args) {
        System.out.println(new InsertionSortList().insertionSortList(ListNode.createListNode(4, 2, 1, 3)));
        System.out.println(new InsertionSortList().insertionSortList(ListNode.createListNode(3,2,4)));

    }
}
