package leetcode.classic150;

/**
 * @author hwang
 * @data 2023/11/13
 * @description
 */
public class No051 {

    public static void main(String[] args) {
        ListNode n1 = new ListNode();
        n1.val = 3;
        ListNode n2 = new ListNode();
        n2.val = 5;

        n1.next = n2;
        No051 no051 = new No051();
        ListNode res = no051.reverseBetween(n1, 1, 2);

        while (null != res) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    /**
     * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
     *
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int i = 1;
        ListNode l = null;
        ListNode r = null;
        ListNode leftNode = null;
        ListNode rightNode = null;
        ListNode resNode = head;
        while (head != null) {
            if (i == left - 1) l = head;
            if (i == left) leftNode = head;
            if (i == right) rightNode = head;
            if (i == right + 1) r = head;
            head = head.next;
            i++;
        }

        if (l != null) l.next = rightNode;
        ListNode pre = null;
        ListNode next;
        if (r != null) pre = r;

        while (leftNode != r) {
            next = leftNode.next;
            leftNode.next = pre;
            pre = leftNode;
            leftNode = next;
        }

        return l == null ? rightNode : resNode;
    }
}
