package offer;

/**
 * @author hwang
 * @data 2023/8/31
 * @description
 */
public class No04FindNumberIn2DArray {

    public static void main(String[] args) {

    }

    /**
     * 在一个 n * m 的二维数组中，每一行都按照从左到右 非递减 的顺序排序，
     * 每一列都按照从上到下 非递减 的顺序排序。请完成一个高效的函数，
     * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     *
     * @param matrix 数组
     * @param target 目标数
     * @return 结果
     */
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {

        int n = matrix.length - 1, m = 0;

        while (n > 0 && m < matrix[0].length) {
            if (matrix[n][m] > target) {
                n--;
            } else if (matrix[n][m] < target) {
                m++;
            } else {
                return true;
            }
        }

        return false;
    }
}
