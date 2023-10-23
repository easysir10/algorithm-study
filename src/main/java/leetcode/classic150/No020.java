package leetcode.classic150;

/**
 * @author hwang
 * @data 2023/10/18
 * @description
 */
public class No020 {

    public static void main(String[] args) {
        No020 no020 = new No020();
        System.out.println(no020.romanToInt("MMMDCCCLXXIX"));
        System.out.println('\0');
    }

    /**
     * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
     * <p>
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * 例如， 罗马数字 2 写做 II ，即为两个并列的 1 。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
     * <p>
     * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，
     * 所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
     * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
     * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     * 给定一个罗马数字，将其转换成整数。
     *
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        if (null == s || s.length() == 0) return 0;

        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            int num1 = charToInt(s.charAt(i));

            if (i + 1 < s.length()) {
                int num2 = charToInt(s.charAt(i + 1));
                if (num1 < num2) {
                    res += num2 - num1;
                    i++;
                    continue;
                }
            }

            res += num1;
        }

        return res;
    }

    private int charToInt(char c) {
        int res = 0;
        switch (c) {
            case 'I':
                res = 1;
                break;
            case 'V':
                res = 5;
                break;
            case 'X':
                res = 10;
                break;
            case 'L':
                res = 50;
                break;
            case 'C':
                res = 100;
                break;
            case 'D':
                res = 500;
                break;
            case 'M':
                res = 1000;
                break;
        }

        return res;
    }
}
