package 动态规划;

import java.lang.reflect.Array;
import java.util.Arrays;

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
     * 设当前已求出的最长上升子序列的长度为 len（初始时为 1），从前往后遍历数组 nums，在遍历到 nums[i] 时：
     *
     * 如果 nums[i]>d[len] ，则直接加入到 d 数组末尾，并更新 len=len+1；
     *
     * 否则，在 dd 数组中二分查找，找到第一个比 nums[i] 小的数 d[k] ，并更新 d[k + 1] = nums[i]
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
                    int l = 1, r = len, pos = 0; // 如果找不到说明所有的数都比 nums[i] 大，此时要更新 d[1]，所以这里将 pos 设为 0
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
