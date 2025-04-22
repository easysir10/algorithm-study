package leetcode.classic150;


import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author hwang
 * @data 2023/11/9
 * @description
 */
public class No047 {

    /**
     * 给你一个字符串数组 tokens ，表示一个根据 逆波兰表示法 表示的算术表达式。
     * 请你计算该表达式。返回一个表示表达式值的整数。
     * 注意：
     * 有效算符为 '+'、'-'、'*' 和 '/' 。
     * 每个操作数（运算对象）都可以是一个整数或者另一个表达式。
     * 两个整数之间的除法总是 向零截断 。
     * 表达式中不含除零运算。
     * 输入是一个根据逆波兰表示法表示的算术表达式。
     * 答案及所有中间计算结果可以用 32 位 整数表示。
     *
     * @param tokens
     * @return
     */
    public int evalRPN(String[] tokens) {
        Set<String> set = new HashSet<String>() {{
            add("+");
            add("-");
            add("*");
            add("/");
        }};
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (set.contains(token)) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(num1 + num2);
                        break;
                    case "-":
                        stack.push(num1 - num2);
                        break;
                    case "*":
                        stack.push(num1 * num2);
                        break;
                    case "/":
                        stack.push(num1 / num2);
                        break;
                }
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
