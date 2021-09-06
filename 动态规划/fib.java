package 动态规划;

/**
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。
 * 给你 n ，请计算 F(n) */

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
