package leetcode.classic150;

import java.util.Stack;

/**
 * @author hwang
 * @data 2023/11/9
 * @description
 */
public class No046 {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public No046() {
        stack = new Stack<>();
        minStack = new Stack<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.push(val);
        minStack.push(Math.min(val, minStack.peek()));
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
