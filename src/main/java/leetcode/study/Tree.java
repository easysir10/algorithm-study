package leetcode.study;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author hwang
 * @data 2023/7/19
 * @description
 */
public class Tree {


    /**
     * 递归方式遍历二叉树
     *
     * @param head
     */
    public static void preOrderRecur(Node head) {
        if (null == head) {
            return;
        }
        // 先序
        System.out.println(head.value);
        preOrderRecur(head.left);
        // 中序
        //System.out.println(head.value);
        preOrderRecur(head.right);
        // 后序
        //System.out.println(head.value);
    }

    /**
     * 先序遍历二叉树（非递归）
     *
     * @param head
     */
    public static void preOrderNoRecur(Node head) {
        if (null == head) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.add(head);

        while (!stack.isEmpty()) {
            head = stack.pop();
            System.out.println(head.value);
            if (null != head.right) {
                stack.add(head.right);
            }
            if (null != head.left) {
                stack.add(head.left);
            }
        }
    }

    /**
     * 后序遍历二叉树（非递归）
     *
     * @param head
     */
    public static void posOrderNoRecur(Node head) {
        if (null == head) {
            return;
        }
        Stack<Node> stack1 = new Stack<>();
        stack1.add(head);
        Stack<Node> stack2 = new Stack<>();

        while (!stack1.isEmpty()) {
            head = stack1.pop();
            stack2.add(head);
            if (null != head.right) {
                stack1.add(head.right);
            }
            if (null != head.left) {
                stack1.add(head.left);
            }
        }

        while (!stack2.isEmpty()) {
            System.out.println(stack2.pop().value);
        }

    }

    /**
     * 中序遍历二叉树（非递归）
     *
     * @param head
     */
    public static void inOrderNoRecur(Node head) {
        if (null == head) {
            return;
        }

        Stack<Node> stack = new Stack<>();

        while (!stack.isEmpty() || null != head) {
            if (null != head) {
                stack.add(head);
                head = head.left;
            } else {
                head = stack.pop();
                System.out.println(head.value);
                head = head.right;
            }
        }

    }

    /**
     * 宽度优先遍历二叉树（非递归）
     *
     * @param head
     */
    public static void widthNoRecur(Node head) {
        if (null == head) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(head);

        Node curEnd = head;
        Node nextEnd = null;
        int curLevelNodes = 0;

        while (!queue.isEmpty()) {
            head = queue.poll();
            System.out.println(head.value);
            if (null != head.left) {
                queue.add(head.left);
            }
            if (null != head.right) {
                queue.add(head.right);
            }
        }
    }

    /**
     * 二叉树最大 宽度
     *
     * @param head
     */
    public static void maxWidth(Node head) {
        if (null == head) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(head);

        Node curEnd = head;
        Node nextEnd = null;
        int curLevelNodes = 0;

        int max = Integer.MIN_VALUE;

        while (!queue.isEmpty()) {
            head = queue.poll();
            System.out.println(head.value);
            if (null != head.left) {
                queue.add(head.left);
                nextEnd = head.left;
            }
            if (null != head.right) {
                queue.add(head.right);
                nextEnd = head.right;
            }
            curLevelNodes++;
            if (head == curEnd) {
                max = Math.max(max, curLevelNodes);

                curEnd = nextEnd;
                nextEnd = null;
                curLevelNodes = 0;
            }
        }
    }

    public class Node {
        public int value;
        public Node left;
        public Node right;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }
}
