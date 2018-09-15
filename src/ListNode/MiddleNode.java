package ListNode;

/**
 * 链表的中间结点
 *
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 *
 * 如果有两个中间结点，则返回第二个中间结点。
 */
public class MiddleNode {
    public static   ListNode middleNode(ListNode head) {
        ListNode one = head;
        ListNode two = head;
        while (true){
            if (two.next==null){
                break;
            }
            if (two.next.next==null){
                one =one.next;
                break;
            }
            one =one.next;
            two =two.next.next;
        }
        return one;
    }



  public static void main(String[] args){

      System.out.print(middleNode(ListNode.createListNode(1,2,3,4,5)).val);
  }
}
