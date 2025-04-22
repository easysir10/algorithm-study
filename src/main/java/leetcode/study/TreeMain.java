package leetcode.study;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author hwang
 * @data 2023/7/19
 * @description
 */
public class TreeMain {


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
     * 判断是否完全二叉树
     * 1. 宽度优先遍历，任一节点，有右无左，返回false
     * 2. 在1不违规情况下，遇到第一个左右子节点不全，后续节点均为叶节点
     *
     * @param head
     * @return
     */
    public static boolean isCbt(Node head) {
        if (null == head) {
            return true;
        }

        LinkedList<Node> queue = new LinkedList<>();
        queue.add(head);

        boolean leaf = false;
        Node left = null;
        Node right = null;

        while (!queue.isEmpty()) {
            head = queue.poll();
            left = head.left;
            right = head.right;

            if ((leaf && (null != left || null != right))
                    || (null == left && null != right)) {
                return false;
            }

            if (null != left) {
                queue.add(left);
            }

            if (null != right) {
                queue.add(right);
            }

            if (null == left || null == right) {
                leaf = true;
            }
        }

        return true;
    }

    /**
     * 二叉树最大宽度
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

    /**
     * 判断是否平衡二叉树
     *
     * @return
     */
    public static boolean isBalanced(Node head) {
        return isBalancedProcess(head).isBalanced;
    }

    public static ReturnType isBalancedProcess(Node head) {
        if (null == head) {
            return new ReturnType(true, 0);
        }

        ReturnType leftFlag = isBalancedProcess(head.left);
        ReturnType rightFlag = isBalancedProcess(head.right);

        int height = Math.max(leftFlag.height, rightFlag.height) + 1;
        // 满足左子树、右子树为平衡二叉树，且左右子树高度差小于等于1
        boolean isBalanced = leftFlag.isBalanced && rightFlag.isBalanced
                && (Math.abs(leftFlag.height) - rightFlag.height) <= 1;
        return new ReturnType(isBalanced, height);
    }

    /**
     * 找两个节点最低公共祖先
     *
     * @param head
     * @param o1
     * @param o2
     * @return
     */
    public static Node lowestAncestor(Node head, Node o1, Node o2) {
        if (null == head || head == o1 || head == o2) {
            return head;
        }

        Node left = lowestAncestor(head.left, o1, o2);
        Node right = lowestAncestor(head.right, o1, o2);

        if (left != null && right != null) {
            return head;
        }
        return left != null ? left : right;
    }

    /**
     * 纸条对折次，一从上到下打印凹凸
     *
     * @param n 折纸次数
     */
    public static void printAllFolds(int n) {
        printProcess(n, 1, true);
    }

    /**
     * @param n    总共折n次
     * @param i    从上到下第i个折痕
     * @param down 凹或者凸，t凹，f凸
     */
    public static void printProcess(int n, int i, boolean down) {
        if (i > n) {
            return;
        }
        printProcess(n, i + 1, true);
        System.out.println(down ? "凸" : "凹");
        printProcess(n, i + 1, false);
    }

    public static void main(String[] args) {
        printAllFolds(3);
    }


    public static class Node {
        public int value;
        public Node left;
        public Node right;
    }

    public static class ReturnType {
        public boolean isBalanced;
        public int height;

        public ReturnType(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }
}
