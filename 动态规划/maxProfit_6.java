package 动态规划;

/**
 * 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；整数 fee 代表了交易股票的手续费用。
 *
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 *
 * 返回获得利润的最大值。
 *
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 * */

public class maxProfit_6 {
    static public class Solution {

        public int maxProfit(int[] prices, int fee) {
            int len = prices.length;
            if (len < 2) {
                return 0;
            }

            // dp[i][j] 表示 [0, i] 区间内，到第 i 天（从 0 开始）状态为 j 时的最大收益'
            // j = 0 表示不持股，j = 1 表示持股
            // 并且规定在买入股票的时候，扣除手续费
            int[][] dp = new int[len][2];
            dp[0][0] = 0;
            dp[0][1] = -prices[0] - fee;
            for (int i = 1; i < len; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i] - fee);
            }
            return dp[len - 1][0];
        }
    }

    public static void main(String args[]){
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(new int[]{2, 4, 62, 5, 1, 35, 2, 6, 3},5));
    }
}
