package ListNode;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

/**
 * @author maple on 2019/6/24 9:21.
 * @version v1.0
 * @see 1040441325@qq.com
 * 4. 两两交换链表中的节点
 * 定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SwapPairs {
    public static ListNode swapPairs(ListNode head) {
        if (head==null)return null;
        ListNode tmp = new ListNode(0);
        tmp.next = head;

        if (head.next != null) head = head.next;
        while (tmp.next != null && tmp.next.next != null) {
            ListNode node = tmp.next;
            ListNode next = tmp.next.next;
            ListNode tmp1 = next.next;
            next.next = node;
            node.next = tmp1;
            tmp.next = next;
            tmp = node;
        }
        return head;
    }

    public static void main(String[] args) {
        System.out.println(ListNode.createListNode(1, 2, 3, 4).toString());
        System.out.println(swapPairs(ListNode.createListNode(1, 2, 3, 4)).toString());
    }
}
