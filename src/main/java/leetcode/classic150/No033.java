package leetcode.classic150;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hwang
 * @data 2023/10/24
 * @description
 */
public class No033 {

    public static void main(String[] args) {
        No033 no033 = new No033();
        System.out.println(no033.wordPattern("abba", "dog cat cat dog"));
    }

    /**
     * 给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。
     * <p>
     * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 s 中的每个非空单词之间存在着双向连接的对应规律。
     *
     * @param pattern
     * @param s
     * @return
     */
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) return false;
        Map<Character, String> mapPattern = new HashMap<>();
        Map<String, Character> mapS = new HashMap<>();

        Character c;
        String word;
        for (int i = 0; i < pattern.length(); i++) {
            c = pattern.charAt(i);
            word = words[i];
            if ((mapPattern.containsKey(c) && !word.equals(mapPattern.get(c)))
                    || (mapS.containsKey(word) && c != mapS.get(word))) {
                return false;
            }
            mapPattern.put(c, word);
            mapS.put(word, c);
        }

        return true;
    }
}
