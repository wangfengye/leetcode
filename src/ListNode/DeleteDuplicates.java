package ListNode;

/**
 * 删除排序链表中的重复元素
 */
public class DeleteDuplicates {
    public static ListNode deleteDuplicates(ListNode head){
        if (head==null||head.next==null)return head;
        ListNode node =head;
        while (node.next!=null){
            if (node.val ==node.next.val){
                node.next =node.next.next;
            }else {
                node =node.next;
            }
        }
        return head;
    }
    public static void main(String[] args){
        System.out.print(deleteDuplicates(ListNode.createListNode(1,1,2,3,3)).val);
    }
}
