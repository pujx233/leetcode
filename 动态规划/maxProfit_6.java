package ��̬�滮;

/**
 * ����һ���������� prices�����е� i ��Ԫ�ش����˵� i ��Ĺ�Ʊ�۸� ������ fee �����˽��׹�Ʊ���������á�
 *
 * ��������޴ε���ɽ��ף�������ÿ�ʽ��׶���Ҫ�������ѡ�������Ѿ�������һ����Ʊ����������֮ǰ��Ͳ����ټ��������Ʊ�ˡ�
 *
 * ���ػ����������ֵ��
 *
 * ע�⣺�����һ�ʽ���ָ������в�������Ʊ���������̣�ÿ�ʽ�����ֻ��ҪΪ֧��һ�������ѡ�
 * */

public class maxProfit_6 {
    static public class Solution {

        public int maxProfit(int[] prices, int fee) {
            int len = prices.length;
            if (len < 2) {
                return 0;
            }

            // dp[i][j] ��ʾ [0, i] �����ڣ����� i �죨�� 0 ��ʼ��״̬Ϊ j ʱ���������'
            // j = 0 ��ʾ���ֹɣ�j = 1 ��ʾ�ֹ�
            // ���ҹ涨�������Ʊ��ʱ�򣬿۳�������
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
