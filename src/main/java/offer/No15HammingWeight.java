package offer;

/**
 * @author hwang
 * @data 2023/9/5
 * @description
 */
public class No15HammingWeight {

    /**
     * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为 汉明重量).）。
     * (位运算)
     * n &= (n - 1) ==》 1100 & 1011= 1000   通过此方法把最右边的1取反，取反的次数就是1的个数
     *
     * @param n 给定证书
     * @return 1的个数
     */
    public int hammingWeight(int n) {
        int count = 0;

        while (n != 0) {
            n &= (n - 1);
            count++;
        }

        return count;
    }
}
