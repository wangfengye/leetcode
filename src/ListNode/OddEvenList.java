package ListNode;

/**
 * 奇偶链表
 * <p>
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，
 * 而不是节点的值的奇偶性。
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 */
public class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode odd = head;//记录奇数
        ListNode even = head.next;//记录偶数
        while (even != null && even.next != null) {
            ListNode node = even.next;
            even.next =node.next;//移除偶数后的奇数
            even = node.next;//移至下一个偶数
            node.next =odd.next;
            odd.next =node;//插入下一位奇数
            odd = node;
        }
        return head;
    }
    public static void main(String[] args){
        new OddEvenList().oddEvenList(ListNode.createListNode(1,2,3,4,5));
    }
}
