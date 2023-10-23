package leetcode.classic150;

/**
 * @author hwang
 * @data 2023/10/18
 * @description
 */
public class No022 {

    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * 如果不存在公共前缀，返回空字符串 ""。
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (null == strs || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];

        String commonStr = strs[0];

        for (int i = 1; i < strs.length; i++) {

            String curStr = strs[i];
            int j = 0;

            for (; j < commonStr.length() && j < curStr.length(); j++) {
                if (commonStr.charAt(j) != curStr.charAt(j)) break;
            }

            commonStr = commonStr.substring(0, j);
            if (commonStr.equals("")) break;
        }

        return commonStr;
    }
}
