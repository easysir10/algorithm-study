package offer;

import java.util.Stack;

/**
 * @author hwang
 * @data 2023/9/18
 * @description
 */
public class No31ValidateStackSequences {

    public static void main(String[] args) {
        No31ValidateStackSequences no31ValidateStackSequences = new No31ValidateStackSequences();
        int[] pushed = new int[]{0, 1};
        int[] popped = new int[]{0, 1};
        System.out.println(no31ValidateStackSequences.validateStackSequences(pushed, popped));
    }


    /**
     * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
     * 例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，
     * 但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
     *
     * @param pushed 压入
     * @param popped 弹出
     * @return 判断结果
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (null == pushed || null == popped || pushed.length != popped.length) return false;
        if (pushed.length == 0) return true;

        Stack<Integer> stack = new Stack<>();

        int index = 0;
        for (int num : pushed) {
            stack.push(num);

            while (!stack.isEmpty() && stack.peek() == popped[index]) {
                stack.pop();
                index++;
            }
        }

        return stack.isEmpty();
    }
}
