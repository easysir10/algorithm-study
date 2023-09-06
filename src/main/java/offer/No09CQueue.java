package offer;

import java.util.Stack;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 * @author hwang
 * @data 2023/9/4
 * @description
 */
public class No09CQueue {

    private final Stack<Integer> stackA;
    private final Stack<Integer> stackB;

    public No09CQueue() {
        stackA = new Stack<>();
        stackB = new Stack<>();
    }

    public void appendTail(int value) {
        stackA.add(value);
    }

    public int deleteHead() {
        if (stackB.isEmpty()) {
            if (stackA.isEmpty()) {
                return -1;
            }
            while (!stackA.isEmpty()) {
                stackB.add(stackA.pop());
            }
        }
        return stackB.pop();
    }
}
