package leetcode.classic150;

import java.util.LinkedList;

/**
 * @author hwang
 * @data 2023/10/24
 * @description
 */
public class No036 {

    public static void main(String[] args) {
        No036 no036 = new No036();

        System.out.println(no036.simplifyPath("/a//b////c/d//././/.."));
    }

    /**
     * 给你一个字符串 path ，表示指向某一文件或目录的 Unix 风格 绝对路径 （以 '/' 开头），请你将其转化为更加简洁的规范路径。
     * <p>
     * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。任意多个连续的斜杠（即，'//'）都被视为单个斜杠 '/' 。 对于此问题，任何其他格式的点（例如，'...'）均被视为文件/目录名称。
     * <p>
     * 请注意，返回的 规范路径 必须遵循下述格式：
     * <p>
     * 始终以斜杠 '/' 开头。
     * 两个目录名之间必须只有一个斜杠 '/' 。
     * 最后一个目录名（如果存在）不能 以 '/' 结尾。
     * 此外，路径仅包含从根目录到目标文件或目录的路径上的目录（即，不含 '.' 或 '..'）。
     * 返回简化后得到的 规范路径 。
     *
     * @param path
     * @return
     */
    public String simplifyPath(String path) {
        LinkedList<String> stack = new LinkedList<>();

        String[] pathArray = path.split("/");

        for (String p : pathArray) {
            if (p.equals("") || p.equals(".") || (p.equals("..") && stack.isEmpty())) continue;

            if (p.equals("..")) {
                stack.pop();
            } else {
                stack.push(p);
            }
        }

        if (stack.isEmpty()) return "/";

        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append("/").append(stack.removeLast());
        }
        return res.toString();
    }
}
