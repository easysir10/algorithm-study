package leetcode.classic150;

/**
 * @author hwang
 * @data 2023/11/13
 * @description
 */
public class No056 {

    /**
     * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
     * <p>
     * 你应当 保留 两个分区中每个节点的初始相对位置。
     *
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        ListNode smallHeadNode = new ListNode();
        ListNode bigHeadNode = new ListNode();

        ListNode smallNode = smallHeadNode;
        ListNode bigNode = bigHeadNode;

        while (head != null) {
            if (head.val < x) {
                smallNode.next = head;
                smallNode = smallNode.next;
            } else {
                bigNode.next = head;
                bigNode = bigNode.next;
            }
            head = head.next;
        }
        smallNode.next = bigHeadNode.next;
        bigNode.next = null;

        return smallHeadNode.next;
    }
}
