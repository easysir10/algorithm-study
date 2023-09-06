package offer;

import java.util.Arrays;

/**
 * @author hwang
 * @data 2023/9/6
 * @description
 */
public class No17PrintNumbers {

    // 数字位数
    int n;
    // 存储打印结果
    int[] res;
    // 数字常量
    char[] chars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    // 数组表示大数
    char[] num;
    // res下标
    int count = 0;
    // 标记当前数字9的个数
    int nineCount = 0;
    // 标记截取num的起始下标（将前面无意义的0去除）
    int startIndex;

    public static void main(String[] args) {
        No17PrintNumbers no17PrintNumbers = new No17PrintNumbers();
        //System.out.println(Integer.valueOf(String.valueOf(no17PrintNumbers.chars)));
        System.out.println(Arrays.toString(no17PrintNumbers.printNumbers(1)));
    }

    /**
     * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。
     * 比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
     *
     * @param n n
     * @return 输出
     */
    public int[] printNumbers(int n) {
        if (n <= 0) {
            return new int[0];
        }
        this.n = n;
        this.res = new int[(int) Math.pow(10, n) - 1];
        this.num = new char[n];
        this.startIndex = n - 1;

        // 从第0位开始递归
        printNumbersCore(0);

        return res;
    }

    public void printNumbersCore(int x) {
        // x==n，说明num最后一位已经填充，可以打印
        if (x == n) {
            // 截取num的有效位，将前边的0去除
            String tmpStr = String.valueOf(num).substring(startIndex);
            if (!tmpStr.equals("0")) res[count++] = Integer.parseInt(tmpStr);
            // 当有效位个数=9的个数时，说明下一个数字需要向高位进1，有效位下标左移一位
            if (n - startIndex == nineCount) startIndex--;
            return;
        }

        // n位数，每一位上0~9进行排列组合
        for (char c : chars) {
            // x位是9，则下一个数字会向高位进1，记录当前9的个数
            if (c == '9') nineCount++;

            // 在x位上放数字c
            num[x] = c;
            // 在x+1位上放0~9排列组合
            printNumbersCore(x + 1);
        }

        nineCount--;
    }
}
