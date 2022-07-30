package ��̬�滮;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * ����һ���������� nums ���ҵ�������ϸ���������еĳ��ȡ�
 *
 * ���������������������������У�ɾ������ɾ���������е�Ԫ�ض����ı�����Ԫ�ص�˳��
 * ���磬[3,6,2,7] ������ [0,3,1,6,2,2,7] �������С�
 * */

public class longestIncreasingSubsequence {
    static class Solution {
        public int lengthOfLIS(int[] nums) {
            int len = nums.length;int ans = 1;
            if(len==1){
                return 1;
            }
            int []dp = new int[len];
            Arrays.fill(dp,1);

            for(int i=1;i<len;i++){
                for(int j = 0;j<i;j++){
                    if(nums[i]>nums[j]){
                        dp[i] = Math.max(dp[i],dp[j]+1);
                    }
                }
                if(dp[i]>ans){
                    ans = dp[i];
                }
            }
            return ans;
        }
    }

    /**
     * �赱ǰ�����������������еĳ���Ϊ len����ʼʱΪ 1������ǰ����������� nums���ڱ����� nums[i] ʱ��
     *
     * ��� nums[i]>d[len] ����ֱ�Ӽ��뵽 d ����ĩβ�������� len=len+1��
     *
     * ������ dd �����ж��ֲ��ң��ҵ���һ���� nums[i] С���� d[k] �������� d[k + 1] = nums[i]
     * */

    class Solution_1 {
        public int lengthOfLIS(int[] nums) {
            int len = 1, n = nums.length;
            if (n == 0) {
                return 0;
            }
            int[] d = new int[n + 1];
            d[len] = nums[0];
            for (int i = 1; i < n; ++i) {
                if (nums[i] > d[len]) {
                    d[len] = nums[i];
                    len++;
                } else {
                    int l = 1, r = len, pos = 0; // ����Ҳ���˵�����е������� nums[i] �󣬴�ʱҪ���� d[1]���������ｫ pos ��Ϊ 0
                    while (l <= r) {
                        int mid = (l + r) >> 1;
                        if (d[mid] < nums[i]) {
                            pos = mid;
                            l = mid + 1;
                        } else {
                            r = mid - 1;
                        }
                    }
                    d[pos + 1] = nums[i];
                }
            }
            return len;
        }
    }


    public static void main(String []args){
        Solution solution = new Solution();
        solution.lengthOfLIS(new int[]{0,1,0,3,2,3});
    }
}
