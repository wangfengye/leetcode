package competition.week130;


import bytedance.Pair;

import java.util.Stack;

/**
 * @author maple on 2019/4/1 9:17.
 * @version v1.0
 * @see 1040441325@qq.com
 * 链表中的下一个更大节点  显示英文描述
 * 用户通过次数 194
 * 用户尝试次数 349
 * 通过次数 196
 * 提交次数 810
 * 题目难度 Medium
 * 给出一个以头节点 head 作为第一个节点的链表。链表中的节点分别编号为：node_1, node_2, node_3, ... 。
 * <p>
 * 每个节点都可能有下一个更大值（next larger value）：对于 node_i，如果其 next_larger(node_i) 是 node_j.val，那么就有 j > i 且  node_j.val > node_i.val，而 j 是可能的选项中最小的那个。如果不存在这样的 j，那么下一个更大值为 0 。
 * <p>
 * 返回整数答案数组 answer，其中 answer[i] = next_larger(node_{i+1}) 。
 * <p>
 * 注意：在下面的示例中，诸如 [2,1,5] 这样的输入（不是输出）是链表的序列化表示，其头节点的值为 2，第二个节点值为 1，第三个节点值为 5
 */
public class NextLargerNodes {
    public static int[] nextLargerNodes(ListNode head) {

        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        ListNode node = head;
        int len = 0;
        while (node != null) {
            node = node.next;
            len++;
        }
        int[] res = new int[len];
        node = head;
        for (int i = 0; i < len - 1; i++) {
            if (node.next.val <= node.val) {
                stack.add(new Pair<>(i, node.val));
            } else {
                //设置更大 节点
                res[i] = node.next.val;
                while (!stack.isEmpty()) {
                    Pair<Integer, Integer> tmp = stack.pop();
                    if (tmp.getValue() < node.next.val) {
                        res[tmp.getKey()] = node.next.val;
                    } else {
                        stack.add(tmp);break;
                    }
                }
            }
            node = node.next;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        ListNode a = new ListNode(7);
        ListNode b = new ListNode(4);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(5);
        head.next = a;
        a.next = b;
        b.next = c;
        c.next = d;
        nextLargerNodes(head);
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


}
