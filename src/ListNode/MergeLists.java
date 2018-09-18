package ListNode;

/**
 * 合并K个排序链表,返回合并后的排序链表。请分析和描述算法的复杂度。
 */
public class MergeLists {
    /**
     * 时间复杂度n*n
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0);
        while (true) {
            int i = getMin(lists);
            if (i == -1) break;
            head.next = lists[i];
            lists[i] = lists[i].next;
            head = head.next;
        }
        return head.next;
    }

    private int getMin(ListNode[] lists) {
        int max = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null && lists[i].val < max) {
                max = lists[i].val;
                index = i;
            }
        }
        return index;
    }

    /**
     * 两两合并,时间复杂度 nlog(2,n)
     * @param listNodes
     * @return
     */
    public ListNode mergeKLists1(ListNode[] listNodes) {
        if (listNodes == null || listNodes.length == 0) {
            return null;
        }
        int n = listNodes.length;
        int aftern = n;
        while (aftern > 1) {

            for (int i = 0; i < aftern / 2; i++) {
                listNodes[i] = mergeTwoLists(listNodes[i], listNodes[aftern-1-i]);
            }
            aftern = (aftern + 1) / 2;
        }
        return listNodes[0];
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode listNode;
        ListNode itr = new ListNode(0);
        listNode = itr;

        while (l1 != null || l2 != null) {
            if (l1 == null) {
                itr.next = l2;
                l2 = l2.next;
            } else if (l2 == null) {
                itr.next = l1;
                l1 = l1.next;
            } else {
                if (l1.val < l2.val) {
                    itr.next = l1;
                    l1 = l1.next;
                } else {
                    itr.next = l2;
                    l2 = l2.next;
                }
            }
            itr = itr.next;
        }
        return listNode.next;
    }

    public static void main(String[] args) {
        new MergeLists().mergeKLists1(new ListNode[]{ListNode.createListNode(1, 4, 5), ListNode.createListNode(1, 3, 4), ListNode.createListNode(2, 6)});
    }
}
