package ListNode;

/**
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 */
public class DetectCycle {
    /**
     * 双循环, 步子分别为,1,2,若为环,循环n次后,到达相同元素
     * 取相同的元素,和头元素,再次循环,到达相同元素为入环节点
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode a = head.next;
        ListNode b = head.next.next;
        while (a != null && b != null && a != b) {
            a = a.next;
            if (b.next == null) return null;
            b = b.next.next;
        }
        if (b != null) {
            b = head;
            while (a != b) {
                a = a.next;
                b = b.next.next;
            }
        }
        return b;
    }
    /**
     * 证明
     * 起点至入环点 S1, 入环点至初次相遇点 S2, 环长度 L, 未知圈数n;
     * 初次相遇可得公式: (S1 + S2) * 2 = S1 + S2 + n * L =>  S1 + S2 = n * L
     *  可知,相遇点再移动 S1 距离到达环起点
     *
     */
}
