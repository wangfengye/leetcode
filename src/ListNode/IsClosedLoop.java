package ListNode;

import java.util.List;

/**
 * @author maple on 2019/6/21 16:25.
 * @version v1.0
 * @see 1040441325@qq.com
 *  判断单链是否闭环
 */
public class IsClosedLoop {
    public static boolean isLoop(ListNode node){
        ListNode a =node;
        ListNode b= node;
        while (a!=null&&b!=null){
            if (a.next==null)return false;
            a= a.next.next;
            b=b.next;
            if (a==b){
                System.out.println("环起点"+ a.val);
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args){
        System.out.println(isLoop(ListNode.createListNode(1,2,3)));
        System.out.println(isLoop(ListNode.createListNode(1,2,3,324,23,342,3)));
        System.out.println(isLoop(ListNode.createListNode(2,2,3,4)));
        System.out.println(isLoop(ListNode.createListloopNode(1,2,3)));
        System.out.println(isLoop(ListNode.createListloopNode(1,2,3,324,23,342,3)));
        System.out.println(isLoop(ListNode.createListloopNode(2,2,3,4)));

    }
}
