package offer;

import entity.ListNode;

/**
 * @author hwang
 * @data 2023/9/7
 * @description
 */
public class No25MergeTwoLists {

    /**
     * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
     *
     * @param l1 l1
     * @param l2 l2
     * @return 合并后链表头节点
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (null == l1 && null == l2) return null;
        if (null == l1) return l2;
        if (null == l2) return l1;

        ListNode head = new ListNode(0);
        ListNode cur = head;

        // 遍历两个链表并比较
        while (null != l1 && null != l2) {
            if (l1.val > l2.val) {
                cur.next = l2;
                l2 = l2.next;
            } else {
                cur.next = l1;
                l1 = l1.next;
            }
            cur = cur.next;
        }

        // 较长链表的剩余部分
        cur.next = l1 != null ? l1 : l2;

        return head.next;
    }
}
