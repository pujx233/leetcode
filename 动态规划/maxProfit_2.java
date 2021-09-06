/**
 * 给定一个数组 prices ，其中 prices[i] 是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * */



public class maxProfit_2 {
    static public class Solution {

        public int maxProfit(int[] prices) {
            int len = prices.length;
            if (len < 2) {
                return 0;
            }

            // 0：没有股票时的最大利润
            // 1：持有股票时的最大利润
            // 状态转移：0 → 1 → 0 → 1 → 0 → 1 → 0
            int[][] dp = new int[len][2];

            dp[0][0] = 0;
            dp[0][1] = -prices[0];

            for (int i = 1; i < len; i++) {
                // 这两行调换顺序也是可以的
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            }
            return dp[len - 1][0];
        }
    }

    public static void main(String args[]){
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(new int[]{2, 4, 62, 5, 1, 35, 2, 6, 3}));
    }
}
