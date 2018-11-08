package ListNode;

import java.util.HashMap;

/**
 * 复制带随机指针的链表
 * <p>
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 * 要求返回这个链表的深度拷贝。
 */
public class CopyRandomList {
    public RandomListNode copyRandomList(RandomListNode head) {
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode temp = head;
        while (temp != null) {
            RandomListNode node = new RandomListNode(temp.label);
            map.put(temp, node);
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            if (temp.next != null) {
                map.get(temp).next = map.get(temp.next);
            }
            if (temp.random != null) {
                map.get(temp).random = map.get(temp.random);
            }
            temp = temp.next;
        }
        return map.get(head);
    }
}

class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }
}