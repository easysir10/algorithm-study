package offer;

/**
 * @author hwang
 * @data 2023/9/6
 * @description
 */
public class No18DeleteNode {


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
     * 返回删除后的链表的头节点。
     *
     * @param head 链表头节点
     * @param val  删除的节点值
     * @return 删除后的链表头节点
     */
    public ListNode deleteNode(ListNode head, int val) {
        // 头节点为null，返回null
        if (null == head) return null;
        // 头节点为待删除的节点，将头节点置为head.next
        if (head.val == val) return head.next;

        ListNode cur = head;

        // 遍历查找值为val的节点
        while (cur.next != null && cur.next.val != val) {
            cur = cur.next;
        }

        if (cur.next != null) cur.next = cur.next.next;

        return head;
    }
}
