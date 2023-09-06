package offer;

/**
 * @author hwang
 * @data 2023/9/5
 * @description
 */
public class No13MovingCount {

    public static void main(String[] args) {
        No13MovingCount no13MovingCount = new No13MovingCount();
        System.out.println(no13MovingCount.movingCount(3, 1, 0));
    }


    /**
     * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
     * 它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
     * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。
     * 请问该机器人能够到达多少个格子？
     * (回溯法)
     *
     * @param m 行数
     * @param n 列数
     * @param k 阈值
     * @return 到达格子数量
     */
    public int movingCount(int m, int n, int k) {
        if (m <= 0 || n <= 0 || k < 0) {
            return 0;
        }

        // 标记已经访问的格子
        boolean[][] visited = new boolean[m][n];

        return movingCountJudge(m, n, k, visited, 0, 0);

    }

    public int movingCountJudge(int m, int n, int k, boolean[][] visited, int i, int j) {
        int count = 0;

        // 判断格子的有效性
        // 行i未越界，列j未越界，i、j各位之和小于等于阈值k，当前格子未被访问
        if (i >= 0 && i < m
                && j >= 0 && j < n
                && (getDigitSum(i) + getDigitSum(j)) <= k
                && !visited[i][j]) {

            // 标记当前格子为已经访问过
            visited[i][j] = true;

            // 计算当前格子上下左右的格子是否满足要求
            count = 1 + movingCountJudge(m, n, k, visited, i - 1, j)
                    + movingCountJudge(m, n, k, visited, i + 1, j)
                    + movingCountJudge(m, n, k, visited, i, j - 1)
                    + movingCountJudge(m, n, k, visited, i, j + 1);
        }


        return count;
    }

    /**
     * 获取数字各位数字之和
     *
     * @param num 数字
     * @return 各位数字之和
     */
    public int getDigitSum(int num) {
        int sum = 0;

        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
