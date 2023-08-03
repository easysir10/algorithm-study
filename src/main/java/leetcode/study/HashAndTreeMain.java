package leetcode.study;

import javafx.beans.binding.When;

import java.util.Stack;
import java.util.TreeSet;

/**
 * @author hwang
 * @data 2023/7/13
 * @description 哈希表和有序表
 */
public class HashAndTreeMain {
    public static void main(String[] args) {

        Node node1 = new Node();
        node1.setValue(1);

        Node node2 = new Node();
        node2.setValue(2);
        node1.setNext(node2);

        Node node3 = new Node();
        node3.setValue(3);
        node2.setNext(node3);

        Node tmpNode = node1;
        System.out.println(tmpNode.value);
        while (null != tmpNode.next) {
            tmpNode = tmpNode.next;
            System.out.println(tmpNode.value);
        }

        tmpNode = reverseLinkedList(node1);
        System.out.println(tmpNode.value);
        while (null != tmpNode.next) {
            tmpNode = tmpNode.next;
            System.out.println(tmpNode.value);
        }

    }

    /**
     * 反转单链表
     *
     * @param head
     * @return
     */
    public static Node reverseLinkedList(Node head) {
        Node pre = null;
        Node next;

        while (null != head) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;
    }

    /**
     * 反转双链表
     *
     * @param head
     * @return
     */
    public static DoubleNode reverseDoubleList(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next = null;

        while (null != head) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }

        return pre;
    }

    /**
     * 判断单链表是否为回文结构
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome(Node head) {
        if (null == head || null == head.next) {
            return true;
        }
        Stack<Node> stack = new Stack<>();

        Node tmpNode = head;
        while (null != tmpNode) {
            stack.push(tmpNode);
            tmpNode = tmpNode.next;
        }

        while (null != head) {
            if (head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    /**
     * 判断单链表是否为回文结构
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome2(Node head) {
        if (null == head || null == head.next) {
            return true;
        }
        // 慢指针
        Node n1 = head;
        // 快指针
        Node n2 = head;

        // 使用快慢指针，找到链表中点
        while (null != n2.next && null != n2.next.next) {
            n1 = n1.next;
            n2 = n2.next.next;
        }

        // 将链表后半部分逆序
        n2 = n1.next;
        n1.next = null;
        Node n3 = null;
        while (null != n2) {
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }

        // 比较链表的前后部分
        n3 = n1;
        n2 = head;
        boolean res = true;
        while (null != n1 && null != n2) {
            if (n1.value != n2.value) {
                res = false;
                break;
            }
            n1 = n1.next;
            n2 = n2.next;
        }

        // 将链表后半部分恢复顺序
        n1 = n3.next;
        n3.next = null;
        while (null != n1) {
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }

        return res;
    }

    public static Node listPartition(Node head, int num) {
        Node sh = null, st = null;
        Node eh = null, et = null;
        Node bh = null, bt = null;
        Node next = null;

        while (null != head) {
            next = head.next;
            head.next = null;
            if (head.value < num) {
                if (null == sh) {
                    sh = head;
                    st = head;
                } else {
                    st.next = head;
                    st = head;
                }
            } else if (head.value == num) {
                if (null == eh) {
                    eh = head;
                    et = head;
                } else {
                    et.next = head;
                    et = head;
                }
            } else {
                if (null == bh) {
                    bh = head;
                    bt = head;
                } else {
                    bt.next = head;
                    bt = head;
                }
            }
            head = next;
        }

        if (null != st) {
            st.next = eh;
            et = et == null ? st : et;
        }

        if (et != null) {
            et.next = bh;
        }

        return sh != null ? sh : (eh != null ? eh : bh);
    }

    /**
     * 查找两个单链表的相交节点
     *
     * @param head1 链表1头节点
     * @param head2 链表2头节点
     * @return
     */
    private static Node getIntersectNode(Node head1, Node head2) {
        if (null == head1 || null == head2) {
            return null;
        }
        // 链表1的入环节点
        Node loop1 = getLoopNode(head1);
        // 链表2的入环节点
        Node loop2 = getLoopNode(head2);

        // 一个链表有环，另一个链表无环，必不相交
        // 两个链表都没有环
        if (null == loop1 && null == loop2) {
            return noLoop(head1, head2);
        }
        // 两个链表都有环
        if (null != loop1 && null != loop2) {
            return boothLoop(head1, loop1, head2, loop2);
        }
        return null;
    }

    /**
     * 找到链表第一个入环节点，如果无环，返回null
     *
     * @param head 链表头指针
     * @return 入环节点
     */
    private static Node getLoopNode(Node head) {
        if (null == head || null == head.next || null == head.next.next) {
            return null;
        }
        // 慢指针一次走一步
        Node s = head.next;
        // 快指针一次走两步
        Node f = head.next.next;

        // 第一次循环，快慢指针一定在环上相遇（如果有环）
        while (s != f) {
            s = s.next;
            f = f.next.next;
        }

        // 相遇后，将快指针指向头节点
        f = head;

        // 第二次循环，两个指针每次走一步，一定在入环处相遇
        while (s != f) {
            s = s.next;
            f = f.next;
        }

        return s;
    }

    /**
     * 如果两个链表都无环，返回第一个相交节点，不相交返回null
     *
     * @param head1
     * @param head2
     * @return
     */
    private static Node noLoop(Node head1, Node head2) {
        if (null == head1 || null == head2) {
            return null;
        }

        Node cur1 = head1;
        Node cur2 = head2;
        int n = 0;

        while (null != cur1.next) {
            n++;
            cur1 = cur1.next;
        }

        while (null != cur2.next) {
            n--;
            cur2 = cur2.next;
        }

        if (cur1 != cur2) {
            return null;
        }

        cur1 = n > 0 ? head1 : head2;
        cur2 = cur1 == head1 ? head2 : head1;

        n = Math.abs(n);

        while (n != 0) {
            n--;
            cur1 = cur1.next;
        }

        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        return cur1;

    }

    /**
     * 两个有环链表，返回第一个相交节点，不相交返回null
     *
     * @param head1 链表1头节点
     * @param loop1 链表1入环节点
     * @param head2 链表2头节点
     * @param loop2 链表2入环节点
     * @return 相交节点
     */
    private static Node boothLoop(Node head1, Node loop1, Node head2, Node loop2) {
        Node cur1 = null;
        Node cur2 = null;
        if (loop1 == loop2) {
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            while (cur1 != loop1) {
                n++;
                cur1 = cur1.next;
            }
            while (cur2 != loop2) {
                n--;
                cur2 = cur2.next;
            }

            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            n = Math.abs(n);
            while (n > 0) {
                n--;
                cur1 = cur1.next;
            }

            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }

            return cur1;
        } else {
            cur1 = loop1.next;
            while (cur1 != loop1) {
                if (cur1 == loop2) {
                    return cur1;
                }
                cur1 = cur1.next;
            }
            return null;
        }
    }

    public static class Node {
        public int value;
        public Node next;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public static class DoubleNode {
        public int value;
        public DoubleNode last;
        public DoubleNode next;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public DoubleNode getLast() {
            return last;
        }

        public void setLast(DoubleNode last) {
            this.last = last;
        }

        public DoubleNode getNext() {
            return next;
        }

        public void setNext(DoubleNode next) {
            this.next = next;
        }
    }
}
