package ListNode;
/**
 * 删除链表中的节点
 */
public class RemoveElements {
    public ListNode removeElements2(ListNode head, int val) {
        ListNode node = new ListNode(0);
        ListNode res = node;
        node.next =head;
        while (node!=null&&node.next !=null){
            if (node.next.val ==val){
                node.next = node.next.next;
            }else {
                node = node.next;
            }

        }
        return res.next;
    }
    public ListNode removeElements(ListNode head, int val) {
       if (head==null)return null;
       //递归,若该元素需要删除,返回.next;
       head.next=removeElements(head.next,val);
       return head.val==val?head.next:head;
    }
}
