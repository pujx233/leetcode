package ��̬�滮;

/**
 * ����һ���������� nums ���ҵ�һ���������͵����������飨���������ٰ���һ��Ԫ�أ������������͡�
 * */

public class maxSubArray {
    class Solution {
        public int maxSubArray(int[] nums) {
            int dp[] = new int[nums.length];
            int len = nums.length;
            if(len == 1){
                return nums[0];
            }
            int max = nums[0];
            dp[0] = nums[0];
            for(int i = 1;i<len;i++){
                dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
                if(dp[i]>max){
                    max = dp[i];
                }
            }

            return max;
        }
    }

}
