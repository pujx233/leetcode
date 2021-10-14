package ��̬�滮;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * ����һ��רҵ��С͵���ƻ�͵���ؽֵķ��ݡ�ÿ�䷿�ڶ�����һ�����ֽ�
 * Ӱ����͵�Ե�Ψһ��Լ���ؾ������ڵķ���װ���໥��ͨ�ķ���ϵͳ������������ڵķ�����ͬһ���ϱ�С͵���룬ϵͳ���Զ�������
 *
 * ����һ������ÿ�����ݴ�Ž��ķǸ��������飬������ ����������װ�õ������ ��һҹ֮���ܹ�͵�Ե�����߽�
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
