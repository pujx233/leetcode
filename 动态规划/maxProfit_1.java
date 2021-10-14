package ��̬�滮;

/**
 * ����һ������ prices �����ĵ� i ��Ԫ�� prices[i] ��ʾһ֧������Ʊ�� i ��ļ۸�
 *
 * ��ֻ��ѡ�� ĳһ�� ������ֻ��Ʊ����ѡ���� δ����ĳһ����ͬ������ �����ù�Ʊ�����һ���㷨�����������ܻ�ȡ���������
 *
 * ��������Դ���ʽ����л�ȡ�������������㲻�ܻ�ȡ�κ����󣬷��� 0 ��
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
     * ���Կ���һ�ֶ�̬�滮��ֻ�����Կռ临�ӶȽ������Ż�������ÿ����λ�ȡ������棿��i����������ֻ��Ҫ֪��ǰi��
     * ����͵�Ϳ���������ˡ�����i����ǰ��������i�죩����͵��i-1�����͵��йأ��������ǵĶ�̬���̾ͳ����ˡ�
     *
     * dp[i] = min(d[i-1],prices[i])
     * ����dp[0]=prices[0],Ȼ��̬����֮��ľͿ����ˡ� �õ���ǰi�����͵��Ժ�ֻ��Ҫά��һ��max������
     * ���������Ϳ����ˡ� ���ʱ���ǿռ临�Ӷ�O��n���Ķ�̬�滮���������£�
     *
     * */


    class Solution_2 {
        public int maxProfit(int[] prices) {
            //dp[i]��ʾ��ֹ��i���۸����͵��Ƕ���   dp[i]=min(dp[i-1],nums[i])
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
