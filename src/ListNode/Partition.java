package ListNode;

/**
 * @author maple on 2019/11/5 16:04.
 * @version v1.0
 * @see 1040441325@qq.com
 * 86. 分隔链表
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 */
public class Partition {
    public ListNode partition(ListNode head, int x) {
        ListNode left=new ListNode(0),right=new ListNode(0);
        ListNode leftS=left,rightS=right;
        for(;;){
            if (head==null)break;
            if (head.val<x){
                left.next=head;
                left=left.next;
            }else {
                right.next=head;
                right=right.next;
            }
            head=head.next;
        }
        right.next=null;
        left.next=rightS.next;
        return leftS.next;
    }
    public static void main(String[] args){
        System.out.println(
                new Partition().partition(ListNode.createListNode(1,4,3,2,5,2),3).toString());
    }
}
