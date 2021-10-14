package ��̬�滮;

/**
 * 쳲���������ͨ���� F(n) ��ʾ���γɵ����г�Ϊ 쳲��������� ���������� 0 �� 1 ��ʼ�������ÿһ�����ֶ���ǰ���������ֵĺ͡�
 * ���� n ������� F(n) */

public class fib {
    class Solution {
        public int fib(int n) {
            if(n==1||n==2){
                return 1;
            }
            if(n==0){
                return 0;
            }
            int dp[] = new int[n+1];
            dp[1] = 1;
            dp[2] = 1;
            for(int i = 3;i<=n;i++){
                dp[i] = dp[i-1]+dp[i-2];
            }
            return dp[n];
        }
    }
}
