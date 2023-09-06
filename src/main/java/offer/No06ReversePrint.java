package offer;

import java.util.ArrayList;
import java.util.Stack;
import java.util.List;

/**
 * @author hwang
 * @data 2023/8/31
 * @description
 */
public class No06ReversePrint {

    /**
     * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
     *
     * @param head 头节点
     * @return 数组
     */
    public int[] reversePrint(ListNode head) {
        if (null == head) {
            return new int[0];
        }
        Stack<Integer> stack = new Stack<>();
        stack.add(head.val);
        while (null != head.next) {
            head = head.next;
            stack.add(head.val);
        }

        int[] result = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            result[i++] = stack.pop();
        }
        return result;
    }

    /**
     * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
     *
     * @param head 头节点
     * @return 数组
     */
    public int[] reversePrint2(ListNode head) {
        if (null == head) {
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        list.add(head.val);
        while (null != head.next) {
            head = head.next;
            list.add(head.val);
        }

        int[] result = new int[list.size()];
        int i = list.size() - 1;
        int j = 0;
        while (i >= 0) {
            result[j++] = list.get(i--);
        }
        return result;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }
}
