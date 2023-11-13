package leetcode.classic150;

/**
 * @author hwang
 * @data 2023/11/9
 * @description
 */
public class No048 {


    /**
     * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
     * <p>
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     * <p>
     * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (null == l1) return l2;
        if (null == l2) return l1;

        ListNode resListNode = new ListNode();
        int sum = l1.val + l2.val;
        int next = sum / 10;
        resListNode.val = sum % 10;

        ListNode tmpListNode = resListNode;

        while (l1.next != null && l2.next != null) {
            l1 = l1.next;
            l2 = l2.next;
            sum = l1.val + l2.val + next;
            next = sum / 10;
            ListNode nextNode = new ListNode();
            nextNode.val = sum % 10;
            tmpListNode.next = nextNode;
            tmpListNode = nextNode;
        }

        while (l1.next != null) {
            l1 = l1.next;
            sum = l1.val + next;
            next = sum / 10;
            l1.val = sum % 10;
            tmpListNode.next = l1;
            tmpListNode = l1;
        }

        while (l2.next != null) {
            l2 = l2.next;
            sum = l2.val + next;
            next = sum / 10;
            l2.val = sum % 10;
            tmpListNode.next = l2;
            tmpListNode = l2;
        }

        if (next > 0) {
            ListNode nextNode = new ListNode();
            nextNode.val = next;
            tmpListNode.next = nextNode;
        }

        return resListNode;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}


