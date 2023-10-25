package leetcode.classic150;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hwang
 * @data 2023/10/24
 * @description
 */
public class No032 {

    /**
     * 给定两个字符串 s 和 t ，判断它们是否是同构的。
     * <p>
     * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
     * <p>
     * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Character> mapS = new HashMap<>();
        Map<Character, Character> mapT = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if ((mapS.containsKey(s.charAt(i)) && t.charAt(i) != mapS.get(s.charAt(i)))
                    || (mapT.containsKey(t.charAt(i)) && s.charAt(i) != mapT.get(t.charAt(i)))) {
                return false;
            }
            mapS.put(s.charAt(i), t.charAt(i));
            mapT.put(t.charAt(i), s.charAt(i));
        }

        return true;
    }
}
