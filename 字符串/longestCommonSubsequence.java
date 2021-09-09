package 字符串;

public class longestCommonSubsequence {

    public static class Solution {
        public int longestCommonSubsequence(String a, String b) {
            int ans = 0;
            if(a.equals("")||b.equals("")){
                return 0;
            }
            else {
                int[][] dp = new int[a.length()+1][b.length()+1];

                for(int i = 1;i<=a.length();i++){
                    for(int j = 1;j<=b.length();j++){
                        if(a.charAt(i-1)==b.charAt(j-1)){
                            dp[i][j] = dp[i-1][j-1]+1;
                        }
                        else if(dp[i][j-1]>dp[i-1][j]){
                            dp[i][j] = dp[i][j-1];
                        }
                        else {
                            dp[i][j] = dp[i-1][j];
                        }
                    }
                }

                return dp[a.length()][b.length()];
            }
        }
    }


    public static void main(String []args){
        Solution solution = new Solution();
        System.out.println(solution.longestCommonSubsequence("abcde","ace"));
    }
}
