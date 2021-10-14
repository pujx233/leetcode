package ��̬�滮;

/**
 * ����һ���������� prices �����ĵ� i ��Ԫ�� prices[i] ��һ֧�����Ĺ�Ʊ�ڵ� i ��ļ۸�
 *
 * ���һ���㷨�����������ܻ�ȡ�������������������� k �ʽ��ס�
 *
 * ע�⣺�㲻��ͬʱ�����ʽ��ף���������ٴι���ǰ���۵�֮ǰ�Ĺ�Ʊ����
 *
 *
 * */

public class maxProfit_4 {
    static public class Solution {

        // �����ڴ�����

        public int maxProfit(int k, int[] prices) {
            int len = prices.length;
            // �����ж�
            if (k == 0 || len < 2) {
                return 0;
            }
            // �����жϣ���Ϊ����һ����Ҫ 2 �죬��� k >= len / 2���൱��û������
            // ת��Ϊ�����ۡ��� 122 �⣬ʹ��̰���㷨
            if (k >= len / 2) {
                return greedy(prices, len);
            }

            // ״̬ת�Ʒ������±��� -1 ��ʱ��Ϊ�˷�ֹ�����±�Խ�磬�࿪һ�У���˵�һά�ĳ����� len + 1
            // �ڶ�ά��ʾ���״������� 0 ��ʼ����˵ڶ�ά�ĳ����� k + 1
            // ����ά��ʾ�Ƿ�ֹɣ�0�����ֹɣ�1���ֹ�
            int[][][] dp = new int[len + 1][k + 1][2];

            // ��ʼ�����ѳֹɵĲ��ֶ�����Ϊһ����С�ĸ�ֵ
            // ע�⣺���ʹ��Ĭ��ֵ 0��״̬ת�ƵĹ����л���������ľ���
            for (int i = 0; i <= len; i++) {
                for (int j = 0; j <= k; j++) {
                    dp[i][j][1] = Integer.MIN_VALUE;
                }
            }

            // ע�⣺i �� j ���� 1 ��λ�õ�ƫ��
            for (int i = 1; i <= len; i++) {
                for (int j = 1; j <= k; j++) {
                    dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i - 1]);
                    dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i - 1]);
                }
            }
            // ˵������һά�͵ڶ�ά״̬������ǰ׺���ʵģ�������һ��״̬����
            return dp[len][k][0];
        }

        private int greedy(int[] prices, int len) {
            // ת��Ϊ��Ʊϵ�еĵ� 2 �⣬ʹ��̰���㷨��ɣ�˼·��ֻҪ�����󣬾ͽ���
            int res = 0;
            for (int i = 1; i < len; i++) {
                if (prices[i] > prices[i - 1]) {
                    res += prices[i] - prices[i - 1];
                }
            }
            return res;
        }
    }

    public static void main(String args[]){
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(3,new int[]{2, 4, 62, 5, 1, 35, 2, 6, 3}));
    }

}
