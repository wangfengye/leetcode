package treenode;

import ListNode.ListNode;

/**
 * @author maple on 2019/11/26 10:09.
 * @version v1.0
 * @see 1040441325@qq.com
 * 109. 有序链表转换二叉搜索树
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * <p>
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * <p>
 * 示例:
 * <p>
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 * <p>
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 */
public class SortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode mid = findMid(head);
        TreeNode node = new TreeNode(mid.val);
        if (head == mid) return node;
        node.left = sortedListToBST(head);
        node.right = sortedListToBST(mid.next);
        return node;
    }

    // 该方法会分割链表;
    private ListNode findMid(ListNode head) {
        ListNode pre = null;//中点偏左
        ListNode slow = head;//中点偏右
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (pre != null) {//分割成两条链表.
            pre.next = null;
        }
        return slow;
    }
}
