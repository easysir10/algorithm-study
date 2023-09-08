package offer;

/**
 * @author hwang
 * @data 2023/9/6
 * @description
 */
public class No19IsMatch {

    /**
     * 请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
     * 而'*'表示它前面的字符可以出现任意次（含0次）。
     * 在本题中，匹配是指字符串的所有字符匹配整个模式。
     * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。
     * (动态规划)
     *
     * @param s 字符串
     * @param p 模式
     * @return 是否匹配
     */
    public boolean isMatch(String s, String p) {

        if (s == null && p == null) return true;
        if (s != null && p == null) return false;

        int m = s == null ? 1 : 1 + s.length();
        int n = p.length() + 1;

        // 二维数组来保存当s和p从空字符串到依次各添加一个字符时的匹配结果
        boolean[][] matchArray = new boolean[m][n];
        matchArray[0][0] = true;

        // 对于第0行，字符串s为空，只有当模式p的奇数位（从0开始）上为*时，才满足情况
        for (int k = 2; k < n; k += 2) {
            matchArray[0][k] = matchArray[0][k - 2] && (p.charAt(k - 1) == '*');
        }

        // 循环遍历，分情况判断
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {

                // 当前判断的模式p字符为*
                if (p.charAt(j - 1) == '*' &&
                        ((matchArray[i][j - 2])
                                || (matchArray[i - 1][j] && s.charAt(i - 1) == p.charAt(j - 2))
                                || (matchArray[i - 1][j] && p.charAt(j - 2) == '.'))) {
                    matchArray[i][j] = true;
                }
                // 当前判断的模式p字符不为*
                else if (matchArray[i - 1][j - 1] &&
                        (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')) {
                    matchArray[i][j] = true;
                }
            }
        }

        return matchArray[m - 1][n - 1];
    }
}
