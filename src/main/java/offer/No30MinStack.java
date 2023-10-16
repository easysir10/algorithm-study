package offer;

import java.util.Stack;

/**
 * @author hwang
 * @data 2023/9/8
 * @description
 */
public class No30MinStack {

    public static void main(String[] args) {
        No30MinStack no30MinStack = new No30MinStack();
        no30MinStack.push(-2);
        no30MinStack.push(0);
        no30MinStack.push(-1);
        System.out.println(no30MinStack.min());
        System.out.println(no30MinStack.top());
        no30MinStack.pop();
        System.out.println(no30MinStack.min());
    }

    Stack<Integer> dataStack;
    Stack<Integer> minStack;

    public No30MinStack() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        dataStack.push(x);

        if (minStack.isEmpty()) {
            minStack.push(x);
        } else {
            minStack.push(Math.min(minStack.peek(), x));
        }
    }

    public void pop() {
        if (!dataStack.isEmpty()) {
            dataStack.pop();
            minStack.pop();
        }
    }

    public int top() {
        return dataStack.peek();
    }

    public int min() {
        if (minStack.isEmpty()) {
            return Integer.MIN_VALUE;
        }
        return minStack.peek();
    }
}
