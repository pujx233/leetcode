package 动态规划;

/**
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。
 *
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * */

public class maxProfit_5 {
    static public class Solution {

        public int maxProfit(int[] prices) {
            int len = prices.length;
            if (len < 2) {
                return 0;
            }

            // 0：没有股票时的最大利润
            // 1：持有股票时的最大利润
            // 2：卖出股票时的最大利润
            // 状态转移：0 → 1 → 2 → 0 → 1 → 2 → 0 → 1 → 2 → 0
            int[][] dp = new int[len][3];

            dp[0][0] = 0;
            dp[0][1] = -prices[0];
            dp[0][2] = 0;
            for (int i = 1; i < len; i++) {
                // 这两行调换顺序也是可以的
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
                dp[i][2] = dp[i-1][1]+prices[i];
            }
            return Math.max(dp[len - 1][0],dp[len-1][2]);
        }
    }

    public static void main(String args[]){
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(new int[]{2, 4, 62, 5, 1, 35, 2, 6, 3}));
    }

}
