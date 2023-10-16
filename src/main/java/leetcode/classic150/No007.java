package leetcode.classic150;

/**
 * @author hwang
 * @data 2023/10/16
 * @description
 */
public class No007 {


    /**
     * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
     * <p>
     * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
     * <p>
     * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        // 当天卖出的利润
        int profit = 0;
        // 当天买入的花销
        int consume = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            profit = Math.max(profit, prices[i] + consume);
            consume = Math.max(consume, -prices[i]);
        }

        return profit;
    }
}
