package leetcode.everyday;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 双队列实现栈
 *
 * @author hu.wang
 * @date 2025-11-18
 */
public class No225 {

}

class MyStack {

    Queue<Integer> q1;
    Queue<Integer> q2;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        q2.offer(x);
        while (!q1.isEmpty()) {
            q2.offer(q1.poll());
        }

        Queue<Integer> tmp = q1;
        q1 = q2;
        q2 = tmp;

    }

    public int pop() {
        return q1.poll();
    }

    public int top() {
        return q1.peek();
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}

