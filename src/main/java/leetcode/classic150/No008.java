package leetcode.classic150;

/**
 * @author hwang
 * @data 2023/10/17
 * @description
 */
public class No008 {

    /**
     * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
     * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
     * 返回 你能获得的 最大 利润 。
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        // 当天卖出的利润
        int profit = 0;
        // 当天买入剩余利润
        int consume = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            profit = Math.max(profit, prices[i] + consume);
            consume = Math.max(consume, profit - prices[i]);
        }

        return profit;
    }
}
