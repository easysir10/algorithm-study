package leetcode.everyday;

/**
 * @author hwang
 * @date 2021/11/18
 * @description 买卖股票的最佳时机II
 */
public class No122MaxProfit {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1, 2, 3, 4, 5}));
    }

    /**
     * 给定一个数组 prices ，其中prices[i] 是一支给定股票第 i 天的价格。
     * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     *
     * @param prices 每天的价格
     * @return 最大的利润
     */
    public static int maxProfit(int[] prices) {
        int[] dp = new int[2];
        dp[0] = 0;  // 不持股
        dp[1] = -prices[0]; // 持股
        for (int i = 1; i < prices.length; i++) {
            dp[0] = Math.max(dp[0], dp[1] + prices[i]); // 不持股：昨天没持股 或者 昨天持股今天卖掉
            dp[1] = Math.max(dp[1], dp[0] - prices[i]); // 持股：昨天持股 或者 今天买入
        }
        return dp[0];
    }
}
