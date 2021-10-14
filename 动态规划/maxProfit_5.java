package ��̬�滮;

/**
 * ����һ���������飬���е� i ��Ԫ�ش����˵� i ��Ĺ�Ʊ�۸� ��
 *
 * ���һ���㷨����������������������Լ�������£�����Ծ����ܵ���ɸ���Ľ��ף��������һ֧��Ʊ��:
 *
 * �㲻��ͬʱ�����ʽ��ף���������ٴι���ǰ���۵�֮ǰ�Ĺ�Ʊ����
 * ������Ʊ�����޷��ڵڶ��������Ʊ (���䶳��Ϊ 1 ��)��
 * */

public class maxProfit_5 {
    static public class Solution {

        public int maxProfit(int[] prices) {
            int len = prices.length;
            if (len < 2) {
                return 0;
            }

            // 0��û�й�Ʊʱ���������
            // 1�����й�Ʊʱ���������
            // 2��������Ʊʱ���������
            // ״̬ת�ƣ�0 �� 1 �� 2 �� 0 �� 1 �� 2 �� 0 �� 1 �� 2 �� 0
            int[][] dp = new int[len][3];

            dp[0][0] = 0;
            dp[0][1] = -prices[0];
            dp[0][2] = 0;
            for (int i = 1; i < len; i++) {
                // �����е���˳��Ҳ�ǿ��Ե�
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
