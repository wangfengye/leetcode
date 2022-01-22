package leetcode;

/**
 * 19. 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 * <p>
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 */
public class J19 {
    public static void main(String[] args){
        ListNode a = create(1,2,3,4,5);
        a=removeNthFromEnd(a,2);
        show(a);

        ListNode b = create(1);
        b=removeNthFromEnd(b,1);
        show(b);

        ListNode c = create(1,2);
        c=removeNthFromEnd(c,1);
        show(c);
    }
    public static ListNode create(int... data){
        ListNode tmp = null;
        for (int i = data.length-1; i>=0 ; i--) {
            tmp=new ListNode(data[i],tmp);
        }
        return tmp;
    }
    public static void show(ListNode a){
        while (a!=null){
            System.out.print(a.val);
            a=a.next;
        }
        System.out.println();
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tmpHead = new ListNode();
        tmpHead.next = head;
        ListNode logHead = tmpHead;
        int size = 0;
        while (tmpHead.next!=null){
            tmpHead=tmpHead.next;
            size++;
        }
        int index = size-n;
        tmpHead=logHead;
        for (int i = 0; i < index; i++) {
            tmpHead=tmpHead.next;
        }

        tmpHead.next =(tmpHead.next==null?null:tmpHead.next.next);
        return logHead.next;
    }
  public static class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
}
