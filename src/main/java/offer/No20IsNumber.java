package offer;

/**
 * @author hwang
 * @data 2023/9/7
 * @description
 */
public class No20IsNumber {

    public static void main(String[] args) {
        No20IsNumber no20IsNumber = new No20IsNumber();
        System.out.println(no20IsNumber.isNumber("    1."));
    }

    /**
     * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
     * 数字的格式可以用 A[.[B]][e|EC] 表示，A为整数部分，B为小数部分，C为指数部分
     * A和C为整数（可以有正负号，也可以无），B是一个无符号整数
     * 可能存在0~9、小数点、正负号、e、E
     *
     * @param s 字符串
     * @return 是否表示数值
     */
    public boolean isNumber(String s) {
        // 字符串为null或长度为0，直接返回false
        if (null == s || s.length() == 0) return false;

        char[] sArray = s.trim().toCharArray();

        // 是否为数字
        boolean isNum = false;

        // 是否为小数点（可出现0次或1次）
        boolean isDot = false;

        // 是否为e或E
        boolean isE = false;

        for (int i = 0; i < sArray.length; i++) {
            // 数字
            if (sArray[i] >= '0' && sArray[i] <= '9') {
                isNum = true;
            }
            // 小数点
            else if (sArray[i] == '.') {
                // 小数点最多出现一次，且小数点前不能有e或E
                if (isDot || isE) return false;
                // 标记出现小数点
                isDot = true;
            }
            // e或E
            else if (sArray[i] == 'e' || sArray[i] == 'E') {
                // e或E只能出现一次
                // e或E之前要有数字
                if (isE || !isNum) return false;
                // 标记出现e或E
                isE = true;
                // e或E出现后继续判定数字，将isNum置false
                isNum = false;
            }
            // 正负号
            else if (sArray[i] == '+' || sArray[i] == '-') {
                // 正负号可出现0~2次，且只能出现在第一个字符或e|E后第一个字符
                if (i != 0 && sArray[i - 1] != 'e' && sArray[i - 1] != 'E') return false;
            } else {
                return false;
            }
        }

        return isNum;
    }

}
