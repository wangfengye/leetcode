package ListNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author maple on 2019/6/24 9:42.
 * @version v1.0
 * @see 1040441325@qq.com
 * 5. K 个一组翻转链表
 * 你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 示例 :
 * <p>
 * 给定这个链表：1->2->3->4->5
 * <p>
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * <p>
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        int len = getLen(head);
        if (len < k) return head;
        ListNode node = new ListNode(0);
        ListNode tmp = node;
        int reverse[] = new int[len];
        for (int i = 0; i < len; i++) {//构建下标
            reverse[i] = i;
        }
        // 下标按规则翻转
        for (int i = 0; i <= len - k; i += k) {
            for (int j = 0; j < k / 2; j++) {
                int t = reverse[i + j];
                reverse[i + j] = reverse[i + k - 1 - j];
                reverse[i + k - 1 - j] = t;
            }
        }
        ListNode[] data = new ListNode[len];//存新顺序的链表

        for (int i = 0; i < len; i++) {
            data[reverse[i]] = head;
            head = head.next;
        }
        for (int i = 0; i < len; i++) {
            tmp.next = data[i];
            tmp = tmp.next;
        }
        tmp.next = null;
        return node.next;
    }

    private int getLen(ListNode node) {
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        return len;
    }
    public ListNode reverseKGroup2(ListNode head, int k) {
        ListNode t=head;
        int i=0;
        while(t!=null){
            i++;
            if(i==k)break;
            t=t.next;
        }
        if(t==null)return head;
        ListNode h=reverseKGroup(t.next,k);
        ListNode tmp;
        while(head!=t){//一个翻转范围内,依次将第一个翻转到最后,
            tmp=head.next;
            head.next=h;
            h=head;
            head=tmp;
        }
        head.next=h;
        return head;
    }
    public static void main(String[] args) {
        System.out.println(new ReverseKGroup().reverseKGroup(ListNode.createListNode(1, 2, 3, 4, 5), 2).toString());
        System.out.println(new ReverseKGroup().reverseKGroup(ListNode.createListNode(1, 2, 3, 4, 5), 3).toString());
        System.out.println(new ReverseKGroup().reverseKGroup(ListNode.createListNode(1, 2), 2).toString());
    }
}
