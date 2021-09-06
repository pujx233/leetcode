package 动态规划;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
 * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * */

public class houseRobber {
    class Solution {
        public int rob(int[] nums) {
            int len = nums.length; int ans =0;
            if(len==0){
                return 0;
            }
            if(len==1){
                return nums[0];
            }

            int []dp = new int[len+1];
            Arrays.fill(dp,0);
            dp[1] = nums[0];dp[2] = Math.max(dp[1],nums[1]);
            ans = Math.max(dp[1],dp[2]);
            for(int i = 3;i<=len;i++){
                dp[i] = Math.max((dp[i-2]+nums[i-1]),dp[i-1]);
                if(dp[i]>ans){
                    ans = dp[i];
                }
            }

            return ans;
        }
    }

}
