package ��̬�滮;

import java.util.Arrays;

/**
 * ���������� n���ҵ����ɸ���ȫƽ���������� 1, 4, 9, 16, ...��ʹ�����ǵĺ͵��� n������Ҫ����ɺ͵���ȫƽ�����ĸ������١�
 *
 * ����һ������ n �����غ�Ϊ n ����ȫƽ������ �������� ��
 *
 * ��ȫƽ���� ��һ����������ֵ������һ��������ƽ�������仰˵����ֵ����һ�������Գ˵Ļ������磬1��4��9 �� 16 ������ȫƽ�������� 3 �� 11 ���ǡ�
 *
 *
 * */

public class perfectSquares {
    static class Solution {
        public int numSquares(int n) {
            int []dp = new int[n+1];
            Arrays.fill(dp,n+1);
            dp[1] = 1;dp[0] = 0;
            int m = (int)Math.sqrt(n);

            for(int i = 2;i<=n;i++){
                for(int j = m;j>0;j--){
                    if(i-j*j>=0){
                        dp[i] = Math.min(dp[i],dp[i-j*j]+1);
                    }
                }
            }

            return dp[n];
        }


    }

    public static void main(String args[]){
        Solution solution = new Solution();
        System.out.println(solution.numSquares(12));
    }

}
