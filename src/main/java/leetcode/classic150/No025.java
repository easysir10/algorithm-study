package leetcode.classic150;

import java.util.Arrays;

/**
 * @author hwang
 * @data 2023/10/23
 * @description
 */
public class No025 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString("a good   example".split(" ")));
    }

    /**
     * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
     * <p>
     * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
     * <p>
     * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
     * <p>
     * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        if (null == s || s.length() == 0) return "";

        StringBuilder res = new StringBuilder();
        s = s.trim();

        int i = s.length() - 1;
        int j = i;

        while (i >= 0) {
            // 当前单词
            while (i >= 0 && s.charAt(i) != ' ') i--;
            // 截取当前单词
            res.append(s, i + 1, j + 1).append(" ");
            // 过滤单词间多余空格
            while (i >= 0 && s.charAt(i) == ' ') i--;
            // 重置下一个单词结束位置
            j = i;
        }

        return res.toString().trim();
    }
}
