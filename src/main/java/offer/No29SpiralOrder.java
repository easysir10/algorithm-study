package offer;

import java.util.Arrays;

/**
 * @author hwang
 * @data 2023/9/8
 * @description
 */
public class No29SpiralOrder {

    public static void main(String[] args) {
        No29SpiralOrder no29SpiralOrder = new No29SpiralOrder();

        int[][] matrix = {{2, 5, 8}, {4, 0, -1}};

        System.out.println(Arrays.toString(no29SpiralOrder.spiralOrder(matrix)));
    }

    /**
     * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
     *
     * @param matrix 矩阵
     * @return 打印结果
     */
    public int[] spiralOrder(int[][] matrix) {
        if (null == matrix || matrix.length == 0) return new int[0];

        // 计算打印圈数
        int circles = Math.min((matrix.length >> 1) + 1, (matrix[0].length >> 1) + 1);

        int rows = matrix.length;
        int columns = matrix[0].length;

        int[] res = new int[rows * columns];
        int index = 0;

        // 按圈循环
        for (int i = 0; i < circles; i++) {
            int x = i;
            int y = i;

            // 从左向右打印
            if (index < res.length) {
                while (y < columns - i) {
                    res[index++] = matrix[x][y++];
                }
                x++;
                y--;
            }

            // 从上到下打印
            if (index < res.length) {
                while (x < rows - i) {
                    res[index++] = matrix[x++][y];
                }
                y--;
                x--;
            }

            // 从右向左打印
            if (index < res.length) {
                while (y >= i) {
                    res[index++] = matrix[x][y--];
                }
                x--;
                y++;
            }

            // 从下向上打印
            if (index < res.length) {
                while (x > i) {
                    res[index++] = matrix[x--][y];
                }
            }
        }

        return res;
    }
}
