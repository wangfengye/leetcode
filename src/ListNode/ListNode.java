package ListNode;

import java.util.Objects;

/**
 * 链表元素类
 */

public class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; }
    /**
     * 链表创建
     * @param data 顺序链表值
     * @return
     */
    public static ListNode createListNode(int... data) {
        ListNode node = new ListNode(0);
       ListNode res = node;
        for (int i = 0; i < data.length; i++) {
            ListNode node1 = new ListNode(data[i]);
            node.next=node1;
            node =node1;
        }
        return  res.next;
    }
    /**
     * 有环链
     * @param data 顺序链表值
     * @return
     */
    public static ListNode createListloopNode(int... data) {
        ListNode node = new ListNode(0);
        ListNode res = node;
        for (int i = 0; i < data.length; i++) {
            ListNode node1 = new ListNode(data[i]);
            node.next=node1;
            node =node1;
        }
        node.next=res.next;
        return  res.next;
    }
    public static boolean isSame(ListNode a,ListNode b){
        if (a==null&&b==null)return true;
        if (a!=null&&a.equals(b))return true;
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode node = (ListNode) o;
        return val == node.val &&
                Objects.equals(next, node.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        ListNode node =new ListNode(0);node.next=this;
        while (node.next!=null){
            node = node.next;
            builder.append(node.val).append("->");
        }
        builder.setLength(builder.length()-2);
        return builder.toString();
    }
}
