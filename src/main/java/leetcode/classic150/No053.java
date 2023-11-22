package leetcode.classic150;

/**
 * @author hwang
 * @data 2023/11/13
 * @description
 */
public class No053 {

    /**
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;

        ListNode tmpNode = new ListNode();
        tmpNode.next = head;
        ListNode h1 = tmpNode;
        ListNode h2 = tmpNode;

        for (int i = 0; i < n && h1 != null; i++) {
            h1 = h1.next;
        }

        while (h1.next != null) {
            h1 = h1.next;
            h2 = h2.next;
        }

        h2.next = h2.next.next;

        return tmpNode.next;
    }
}
