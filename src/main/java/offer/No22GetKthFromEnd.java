package offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hwang
 * @data 2023/9/7
 * @description
 */
public class No22GetKthFromEnd {


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 输入一个链表，输出该链表中倒数第k个节点。
     * 为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
     * (使用了哈希表，空间复杂度为O(N))
     *
     * @param head 头节点
     * @param k    倒数k
     * @return 倒数k节点
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (k <= 0 || null == head) return null;

        // <k,v> ==> <节点正数位置,节点>
        Map<Integer, ListNode> kMap = new HashMap<>();

        int i = 1;
        kMap.put(i, head);

        // 遍历链表，将链表节点放入哈希表
        while (null != head.next) {
            head = head.next;
            kMap.put(++i, head);
        }

        // 倒数大于链表总节点个数
        if (k > i) return null;

        return kMap.get(i - k + 1);
    }

    /**
     * 输入一个链表，输出该链表中倒数第k个节点。
     * 为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
     * (空间复杂度为O(1))
     *
     * @param head 头节点
     * @param k    倒数k
     * @return 倒数k节点
     */
    public ListNode getKthFromEnd2(ListNode head, int k) {
        if (k <= 0 || null == head) return null;

        ListNode node1 = head, node2 = head;

        // 第一次遍历，node1 走了 k 步
        for (int i = 0; i < k; i++) {
            if (null == node1) return null;
            node1 = node1.next;
        }

        // 第二次遍历，node1 和 node2 都走了 n-k 步
        while (null != node1) {
            node1 = node1.next;
            node2 = node2.next;
        }

        return node2;
    }

}
