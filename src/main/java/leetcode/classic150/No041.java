package leetcode.classic150;

import java.util.*;

/**
 * @author hwang
 * @data 2023/10/25
 * @description
 */
public class No041 {

    /**
     * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
     * <p>
     * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (null == strs || strs.length == 0) return new ArrayList<>();

        int len = strs.length;
        List<List<String>> resList = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            String s1 = strs[i];
            if (null == s1) continue;

            List<String> tmpList = new ArrayList<>();
            tmpList.add(s1);
            for (int j = i + 1; j < len; j++) {
                String s2 = strs[j];
                if (null == s2) continue;
                if (judgeFunc(s1, s2)) {
                    tmpList.add(s2);
                    strs[j] = null;
                }
            }
            resList.add(tmpList);
        }

        return resList;
    }

    private boolean judgeFunc(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : s2.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) - 1);
            if (map.get(c) < 0) return false;
        }

        return true;
    }
}
