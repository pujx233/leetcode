package 笔试.完美世界;

public class maxProfit {

    /**
     * 考虑到扣费和冻结状态的变种
     * */

    public int maxProfit (int k, int[] prices, int fee) {

        int len = prices.length;

        if (k == 0 || len < 2) {
            return 0;
        }

        boolean bug = true;
        int[][][] dp = new int[len + 1][k + 1][3];

        for (int i = 0; i <= len; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j][1] = Integer.MIN_VALUE;
                dp[i][j][2] = 0;
            }
        }


        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= k; j++) {

                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][2] - prices[i - 1] - fee);
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i - 1]);
                dp[i][j][2] = Math.max(dp[i - 1][j][2], dp[i - 1][j][0]);
            }
        }

        return Math.max(dp[len][k][0],dp[len][k][2]);
    }

}
