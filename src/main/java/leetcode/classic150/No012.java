package leetcode.classic150;

import java.util.Locale;

/**
 * @author hwang
 * @data 2023/10/17
 * @description
 */
public class No012 {

    /**
     * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
     * 字母和数字都属于字母数字字符。
     * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
     *
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        char[] chars = s.trim().toLowerCase().toCharArray();

        int left = 0;
        int right = chars.length - 1;

        while (left <= right) {

            if (!Character.isLetterOrDigit(chars[left])) {
                left++;
                continue;
            }

            if (!Character.isLetterOrDigit(chars[right])) {
                right--;
                continue;
            }

            if (chars[left] != chars[right]) return false;
            left++;
            right--;
        }
        return true;
    }
}
