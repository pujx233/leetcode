package 动态规划;

import java.util.Arrays;

/**
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 *
 * 给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。
 *
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
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
