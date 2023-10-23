package leetcode.classic150;

/**
 * @author hwang
 * @data 2023/10/23
 * @description
 */
public class No023 {
    /**
     * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
     * 如果 needle 不是 haystack 的一部分，则返回  -1 。
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        int len = needle.length();

        String tmpStr;
        for (int i = 0; i < haystack.length(); i++) {
            if (i + len > haystack.length()) break;

            tmpStr = haystack.substring(i, i + len);
            if (tmpStr.equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
