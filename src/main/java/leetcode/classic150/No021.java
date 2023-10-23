package leetcode.classic150;

/**
 * @author hwang
 * @data 2023/10/18
 * @description
 */
public class No021 {

    /**
     * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
     * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
     *
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        if (null == s || s.length() == 0) return 0;

        s = s.trim();
        String[] words = s.split(" ");

        return words[words.length-1].length();
    }
}
