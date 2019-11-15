package ListNode;

/**
 * 删除排序链表中的重复元素
 */
public class DeleteDuplicates {
    /**
     * 排序链表去重复元素
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode node = head;
        while (node.next != null) {
            if (node.val == node.next.val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return head;
    }

    /**
     * 排序链表去重复元素(不保留重复的元素)
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode node = new ListNode(0);
        ListNode res = node;
        node.next = head;
        boolean hasSame=false;
        while (node.next != null &&node.next.next!=null) {
            if (node.next.next.val==node.next.val){
                hasSame=true;
                node.next.next=node.next.next.next;
            }else {
                if (hasSame){
                    node.next = node.next.next;
                    hasSame=false;
                }else {
                    node=node.next;
                }
            }
        }
        if (hasSame){
            node.next=null;
        }
        return res.next;
    }

    public static void main(String[] args) {
        System.out.println(deleteDuplicates(ListNode.createListNode(1, 1, 2, 3, 3)).toString());
        System.out.println(deleteDuplicates2(ListNode.createListNode(1, 1, 2, 3, 3)).toString());
        System.out.println(deleteDuplicates2(ListNode.createListNode(1,2,3,3,4,4,5)).toString());
        System.out.println(deleteDuplicates2(ListNode.createListNode(1,1,1,2,3)).toString());
    }
}
