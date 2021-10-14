package 动态规划;

/**
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 *
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 *
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * */

public class maxProfit_1 {
    class Solution {
        public int maxProfit(int[] prices) {
            if(prices.length == 0 ) return 0;
            int max = 0 ,min = prices[0];
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > min){
                    max = Math.max(max,prices[i]-min);//f(i)=max(f(i-1),f(i))
                }else{
                    min = prices[i];
                }
            }
            return max;
        }
    }

    /**
     * 可以看做一种动态规划，只不过对空间复杂度进行了优化。考虑每次如何获取最大收益？第i天的最大收益只需要知道前i天
     * 的最低点就可以算出来了。而第i天以前（包括第i天）的最低点和i-1天的最低点有关，至此我们的动态方程就出来了。
     *
     * dp[i] = min(d[i-1],prices[i])
     * 其中dp[0]=prices[0],然后动态计算之后的就可以了。 得到了前i天的最低点以后，只需要维护一个max用来保
     * 存最大收益就可以了。 这个时候是空间复杂度O（n）的动态规划，代码如下：
     *
     * */


    class Solution_2 {
        public int maxProfit(int[] prices) {
            //dp[i]表示截止到i，价格的最低点是多少   dp[i]=min(dp[i-1],nums[i])
            int max = 0;
            int[] dp = new int[prices.length];
            dp[0] = prices[0];
            for (int i = 1; i < prices.length; i++) {
                dp[i] = Math.min(dp[i - 1], prices[i]);
                max = Math.max((prices[i] - dp[i]), max);
            }
            return max;
        }
    }


}
