package ListNode;

/**
 * 相交链表
 * <p>
 * 找到两个单链表相交的起始节点
 */
public class GetIntersectionNode {
    /**
     * 先将a,b变为等长链表
     * 时间复杂度O(n) 空间复杂度O(4)
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode a = headA;
        ListNode b = headB;

        int aCount = 0;
        while (a != null) {
            a = a.next;
            aCount++;
        }
        int bCount = 0;
        while (b != null) {
            b = b.next;
            bCount++;
        }
        a = headA;
        b = headB;
        if (aCount > bCount) {
            for (int i = 0; i < aCount - bCount; i++) {
                a = a.next;
            }
        }
        if (aCount < bCount) {
            for (int i = 0; i < bCount - aCount; i++) {
                b = b.next;
            }
        }

        while (a != null && b != null) {
            if (a.val == b.val &&((a.next==null&&b.next==null)||(a.next!=null&&b.next!=null)&& a.next.val == b.next.val)) {
                return a;
            } else {
                a = a.next;
                b = b.next;
            }
        }
        return null;
    }

    /**
     * 双链循环判断
     * demo
     * a: a1,a2,c1,c2
     * b:b1,b2,b3,c1,c2;
     * 第一条 a+b   a1,a2,c1,c2,b:b1,b2,b3,c1,c2
     * 第二条 b+a   b:b1,b2,b3,c1,c2,a1,a2,c1,c2
     * 循环到第一个相同元素为 c1,
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode1(ListNode headA, ListNode headB){
        if (headA == null || headB == null) return null;
        ListNode a = headA;
        ListNode b = headB;
        while (!ListNode.isSame(a,b)){
            if(a==null)a=headB;else a=a.next;
            if (b==null)b=headA;else b=b.next;
        }
        return a;
    }
    public static void main(String[] args){
        System.out.println(getIntersectionNode(ListNode.createListNode(3),ListNode.createListNode(2,3)).val);
        System.out.print(getIntersectionNode1(ListNode.createListNode(3),ListNode.createListNode(2,3)).val);
    }
}
