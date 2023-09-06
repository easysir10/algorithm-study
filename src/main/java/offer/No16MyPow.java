package offer;

/**
 * @author hwang
 * @data 2023/9/6
 * @description
 */
public class No16MyPow {

    public static void main(String[] args) {
        No16MyPow no16MyPow = new No16MyPow();
        System.out.println(no16MyPow.myPow(2.00000, -2147483648));
    }

    /**
     * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
     *
     * @param x x
     * @param n n
     * @return pow(x, n)
     */
    public double myPow(double x, int n) {

        if (x == 0) return 0;

        long N = n;
        double res = 1.0;

        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        while (N > 0) {
            if ((N & 1) == 1) res *= x;
            x *= x;
            N >>= 1;
        }

        return res;
    }
}
