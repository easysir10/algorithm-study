package leetcode.classic150;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author hwang
 * @data 2023/10/24
 * @description
 */
public class No035 {

    private static final Map<Character, Character> map = new HashMap<Character, Character>() {{
        put('(', ')');
        put('{', '}');
        put('[', ']');
    }};

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     * <p>
     * 有效字符串需满足：
     * <p>
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 每个右括号都有一个对应的相同类型的左括号。
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();

        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                stack.addLast(c);
            } else if (stack.size() == 0 || c != map.get(stack.removeLast())) {
                return false;
            }
        }
        return stack.size() == 0;
    }
}
