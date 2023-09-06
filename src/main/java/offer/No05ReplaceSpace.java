package offer;

/**
 * @author hwang
 * @data 2023/8/31
 * @description
 */
public class No05ReplaceSpace {
    /**
     * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
     *
     * @param s 输入字符串
     * @return 替换后字符串
     */
    public static String replaceSpace(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                stringBuilder.append("%20");
            } else {
                stringBuilder.append(c);
            }
        }

        return stringBuilder.toString();
    }
}
