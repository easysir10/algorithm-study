package offer;

import java.util.logging.Level;

/**
 * @author hwang
 * @data 2023/9/5
 * @description
 */
public class No14_1CuttingRope {

    public static void main(String[] args) {
        No14_1CuttingRope no14_1CuttingRope = new No14_1CuttingRope();
        System.out.println(no14_1CuttingRope.cuttingRope3(120));
    }

    /**
     * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
     * 每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
     * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
     * (动态规划)
     *
     * @param n 绳子长度
     * @return 最大乘积
     */
    public int cuttingRope(int n) {

        // 1、2、3时为特殊情况
        if (n < 2) return 0;
        if (n == 2) return 1;
        if (n == 3) return 2;

        // 存储当绳子长度为1……n时，对应最大的乘积
        int[] maxArray = new int[n + 1];
        maxArray[1] = 1;
        maxArray[2] = 2;
        maxArray[3] = 3;

        int max;

        // 自下而上计算f(i)
        for (int i = 4; i <= n; i++) {
            max = 0;
            // 拆分f(i)为计算f(j)*f(i-j)
            for (int j = 1; j <= i >> 1; j++) {
                int tmp = maxArray[j] * maxArray[i - j];
                if (max < tmp) {
                    max = tmp;
                }
            }
            maxArray[i] = max;
        }

        return maxArray[n];

    }

    /**
     * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
     * 每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
     * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
     * (贪婪算法)
     *
     * @param n 绳子长度
     * @return 最大乘积
     */
    public int cuttingRope2(int n) {
        // 1、2、3时为特殊情况
        if (n < 2) return 0;
        if (n == 2) return 1;
        if (n == 3) return 2;

        // 尽可能多的剪长度为3的绳子
        int ropeThreeCount = n / 3;

        // 剩下最后一个长度为4的绳子不能剪成3和1，要剪成2和2
        if (n - ropeThreeCount * 3 == 1) {
            ropeThreeCount -= 1;
        }

        int ropeTwoCount = (n - ropeThreeCount * 3) / 2;

        return (int) Math.pow(3, ropeThreeCount) * (int) Math.pow(2, ropeTwoCount);
    }

    /**
     * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
     * 每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
     * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
     * (贪婪算法)
     *
     * @param n 绳子长度
     * @return 最大乘积
     */
    public int cuttingRope3(int n) {
        // 1、2、3时为特殊情况
        if (n < 2) return 0;
        if (n == 2) return 1;
        if (n == 3) return 2;
        if (n == 4) return 4;

        long res = 1;

        // 尽可能多的剪长度为3的绳子
        while (n > 4) {
            n -= 3;
            res = res * 3 % 1000000007;
        }

        return (int) (res * n % 1000000007);
    }
}
