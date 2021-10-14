package ��̬�滮;

/**
 * ����һ������ prices ������ prices[i] ��һ֧������Ʊ�� i ��ļ۸�
 *
 * ���һ���㷨�����������ܻ�ȡ�������������Ծ����ܵ���ɸ���Ľ��ף��������һ֧��Ʊ����
 *
 * ע�⣺�㲻��ͬʱ�����ʽ��ף���������ٴι���ǰ���۵�֮ǰ�Ĺ�Ʊ����
 * */



public class maxProfit_2 {
    static public class Solution {

        public int maxProfit(int[] prices) {
            int len = prices.length;
            if (len < 2) {
                return 0;
            }

            // 0��û�й�Ʊʱ���������
            // 1�����й�Ʊʱ���������
            // ״̬ת�ƣ�0 �� 1 �� 0 �� 1 �� 0 �� 1 �� 0
            int[][] dp = new int[len][2];

            dp[0][0] = 0;
            dp[0][1] = -prices[0];

            for (int i = 1; i < len; i++) {
                // �����е���˳��Ҳ�ǿ��Ե�
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
