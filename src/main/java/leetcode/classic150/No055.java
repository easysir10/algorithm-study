package leetcode.classic150;

/**
 * @author hwang
 * @data 2023/11/13
 * @description
 */
public class No055 {

    /**
     * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        int len = 1;
        ListNode h = head;
        ListNode t = head;
        while (t.next != null) {
            len++;
            t = t.next;
        }

        k %= len;
        if (k == 0) return head;

        t.next = h;
        int i = 1;
        while (i < len - k) {
            h = h.next;
            i++;
        }

        ListNode resNode = h.next;
        h.next = null;
        return resNode;
    }

}
