package leetcode.classic150;

/**
 * @author hwang
 * @data 2023/11/13
 * @description
 */
public class No054 {

    /**
     * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode curNode = new ListNode();
        curNode.next = head;

        ListNode l = curNode;

        while (l.next != null && l.next.next != null) {
            ListNode l1 = l.next;
            ListNode l2 = l.next.next;

            if (l1.val == l2.val) {
                while (l2 != null && l1.val == l2.val) {
                    l2 = l2.next;
                }
                l.next = l2;
            } else {
                l = l.next;
            }
        }

        return curNode.next;
    }
}
