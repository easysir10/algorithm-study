package offer;

/**
 * @author hwang
 * @data 2023/9/7
 * @description
 */
public class No24ReverseList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
     *
     * @param head 头节点
     * @return 反转后头节点
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode next;

        while (null != head) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;
    }
}
