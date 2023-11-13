package leetcode.classic150;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hwang
 * @data 2023/11/13
 * @description
 */
public class No052 {

    /**
     * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
     * <p>
     * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
     * <p>
     * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (null == head) return null;

        ListNode tmpNode = new ListNode();
        tmpNode.next = head;

        ListNode left = tmpNode;
        ListNode right = tmpNode;

        while (right.next != null) {
            for (int i = 0; i < k && right != null; i++) {
                right = right.next;
            }
            if (right == null) break;

            ListNode next = right.next;
            right.next = null;
            ListNode start = left.next;
            reverseListNode(start);

            left.next = right;
            start.next = next;

            left = start;
            right = start;
        }

        return tmpNode.next;
    }

    private void reverseListNode(ListNode start) {
        ListNode pre = null;
        ListNode next;
        ListNode head = start;

        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
    }

}
