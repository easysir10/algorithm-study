package leetcode.classic150;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hwang
 * @data 2023/11/23
 * @description
 */
public class No063 {

    public Node connect(Node root) {
        if (root == null) return null;

        Node tmpRoot = root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(tmpRoot);

        while (!queue.isEmpty()) {
            Node last = null;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                tmpRoot = queue.poll();
                if (tmpRoot.left != null) {
                    queue.add(tmpRoot.left);
                }
                if (tmpRoot.right != null) {
                    queue.add(tmpRoot.right);
                }
                if (i != 0) last.next = tmpRoot;
                last = tmpRoot;
            }
        }
        return root;
    }


    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
