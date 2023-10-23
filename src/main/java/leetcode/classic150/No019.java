package leetcode.classic150;

import java.util.*;

/**
 * @author hwang
 * @data 2023/10/18
 * @description
 */
public class No019 {

    public static void main(String[] args) {
        No019 no019 = new No019();

        System.out.println(no019.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
    }

    /**
     * 给定一个字符串 s 和一个字符串数组 words。 words 中所有字符串 长度相同。
     * <p>
     * s 中的 串联子串 是指一个包含  words 中所有字符串以任意顺序排列连接起来的子串。
     * <p>
     * 例如，如果 words = ["ab","cd","ef"]， 那么 "abcdef"， "abefcd"，"cdabef"， "cdefab"，"efabcd"， 和 "efcdab" 都是串联子串。
     * "acdbef" 不是串联子串，因为他不是任何 words 排列的连接。
     * 返回所有串联子串在 s 中的开始索引。你可以以 任意顺序 返回答案。
     *
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();

        Map<String, Integer> wordMap = new HashMap<>();
        Map<String, Integer> tmpMap = new HashMap<>();

        int len = words.length * words[0].length();
        int wordLen = words[0].length();
        int left = 0;
        int right = len - 1;
        String tmpS;

        for (String w : words) {
            wordMap.put(w, wordMap.getOrDefault(w, 0) + 1);
        }

        while (right < s.length()) {
            tmpS = s.substring(left, right + 1);
            tmpMap = new HashMap<>();

            for (int i = 0, j = wordLen - 1; j < tmpS.length(); i = i + wordLen, j = j + wordLen) {
                String w = tmpS.substring(i, j + 1);
                tmpMap.put(w, tmpMap.getOrDefault(w, 0) + 1);
            }

            boolean flag = true;
            for (String k : tmpMap.keySet()) {
                if (!wordMap.containsKey(k) || !Objects.equals(tmpMap.get(k), wordMap.get(k))) {
                    flag = false;
                    break;
                }
            }
            if (tmpMap.size() == wordMap.size() && flag) res.add(left);

            left++;
            right++;
        }

        return res;
    }
}
