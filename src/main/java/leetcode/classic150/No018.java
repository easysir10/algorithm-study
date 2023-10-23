package leetcode.classic150;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hwang
 * @data 2023/10/18
 * @description
 */
public class No018 {
    public static void main(String[] args) {
        No018 no018 = new No018();

        System.out.println(no018.lengthOfLongestSubstring("pwwkew"));
    }

    /**
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (null == s || s.length() == 0) return 0;

        Map<Character, Integer> map = new HashMap<>();

        int left = -1;
        int res = 0;

        for (int right = 0; right < s.length(); right++) {
            if (map.containsKey(s.charAt(right))) {
                left = Math.max(left, map.get(s.charAt(right)));
            }

            map.put(s.charAt(right), right);
            res = Math.max(res, right - left);
        }

        return res;
    }
}
