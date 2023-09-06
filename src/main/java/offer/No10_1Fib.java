package offer;

/**
 * @author hwang
 * @data 2023/9/4
 * @description
 */
public class No10_1Fib {

    public static void main(String[] args) {
        No10_1Fib no10_1Fib = new No10_1Fib();

        System.out.println(no10_1Fib.fib(5));
    }

    /**
     * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）
     * F(0) = 0,   F(1) = 1
     * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
     *
     * @param n 第n项
     * @return 第n项的值
     */
    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int a = 0, b = 1, sum;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }

        return a;
    }
}
