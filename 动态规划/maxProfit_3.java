package ��̬�滮;

/**
 * ����һ�����飬���ĵ� i ��Ԫ����һ֧�����Ĺ�Ʊ�ڵ� i ��ļ۸�
 *
 * ���һ���㷨�����������ܻ�ȡ�������������������� ���� ���ס�
 *
 * ע�⣺�㲻��ͬʱ�����ʽ��ף���������ٴι���ǰ���۵�֮ǰ�Ĺ�Ʊ����
 * */
public class maxProfit_3 {

    static class Solution {
        public int maxProfit(int[] prices) {
            if(prices==null || prices.length==0){
                return 0;
            }
            int len = prices.length;

            int[][][] dp = new int[len][3][2];

            dp[0][1][0] = 0;
            dp[0][1][1] = -prices[0];
            dp[0][2][0] = 0;
            dp[0][2][1] = Integer.MIN_VALUE;

            for (int i = 1; i < len; i++) {


                dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][1][1] + prices[i]);
                dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i - 1][0][0] - prices[i]);

                dp[i][2][0] = Math.max(dp[i - 1][2][0], dp[i - 1][2][1] + prices[i]);
                dp[i][2][1] = Math.max(dp[i - 1][2][1], dp[i - 1][1][0] - prices[i]);
            }


            return dp[len - 1][2][0];
        }
    }

    public static void main(String args[]){
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(new int[]{2, 4, 62, 5, 1, 35, 2, 6, 3}));
    }

}
