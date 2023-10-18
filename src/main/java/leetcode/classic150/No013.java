package leetcode.classic150;

/**
 * @author hwang
 * @data 2023/10/17
 * @description
 */
public class No013 {

    /**
     * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
     * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
     * （例如，"ace"是"abcde"的一个子序列，而"aec"不是）
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        if (t.length() < s.length()) return false;

        int i = 0, j = 0;

        while (i < t.length() && j < s.length()) {
            if (t.charAt(i) == s.charAt(j)) {
                j++;
            }
            i++;
        }
        return j >= s.length();
    }
}
