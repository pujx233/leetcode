package 数组;

/**
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 * */

public class maxOfRepeatedSubarray {

    /**
     * 动态规划
     * */

    class Solution {
        public int findLength(int[] A, int[] B) {
            int n = A.length, m = B.length;
            int[][] dp = new int[n + 1][m + 1];
            int ans = 0;
            for (int i = n - 1; i >= 0; i--) {
                for (int j = m - 1; j >= 0; j--) {
                    dp[i][j] = A[i] == B[j] ? dp[i + 1][j + 1] + 1 : 0;
                    ans = Math.max(ans, dp[i][j]);
                }
            }
            return ans;
        }
    }

    /**
     * 滑动窗口
     * */

    class Solution_1 {
        public int findLength(int[] nums1, int[] nums2) {
            int n =nums1.length,m = nums2.length;
            int ans = 0;
            for(int i = 0;i<n;i++){
                int len = Math.min(m,n-i);
                int max = maxLen(nums1,nums2,0,i,len);
                ans = Math.max(ans,max);
            }

            for(int i = 0;i<m;i++){
                int len = Math.min(n,m-i);
                int max = maxLen(nums1,nums2,0,i,len);
                ans = Math.max(ans,max);
            }

            return ans;
        }

        public int maxLen(int[] nums1,int[] nums2,int add1,int add2,int len){
            int ans = 0,k = 0;
            for(int i = 0;i<len;i++){
                if(nums1[add1+i]==nums2[add2+i]){
                    k++;
                }else {
                    k = 0;
                }
                ans = Math.max(ans,k);
            }

            return ans;
        }


    }
}
