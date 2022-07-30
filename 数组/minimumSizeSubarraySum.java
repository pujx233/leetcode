package ����;

import java.util.*;

/**
 * ����һ������ n ���������������һ�������� target ��
 *
 * �ҳ���������������� �� target �ĳ�����С�� ���������� [nums l, nums l+1, ..., nums r-1, nums r] ���������䳤�ȡ�
 * ��������ڷ��������������飬���� 0 ��
 * */

public class minimumSizeSubarraySum {

    /**
     * ��������
     * */

    class Solution {
        public int minSubArrayLen(int s, int[] nums) {
            int n = nums.length;
            if (n == 0) {
                return 0;
            }
            int ans = Integer.MAX_VALUE;
            int start = 0, end = 0;
            int sum = 0;
            while (end < n) {
                sum += nums[end];
                while (sum >= s) {
                    ans = Math.min(ans, end - start + 1);
                    sum -= nums[start];
                    start++;
                }
                end++;
            }
            return ans == Integer.MAX_VALUE ? 0 : ans;
        }
    }

    /**
     * ǰ׺�� + ���ֲ���
     * */

    class Solution_1 {
        public int minSubArrayLen(int s, int[] nums) {
            int n = nums.length;
            if (n == 0) {
                return 0;
            }
            int ans = Integer.MAX_VALUE;
            int[] sums = new int[n + 1];
            // Ϊ�˷�����㣬�� size = n + 1
            // sums[0] = 0 ��ζ��ǰ 0 ��Ԫ�ص�ǰ׺��Ϊ 0
            // sums[1] = A[0] ǰ 1 ��Ԫ�ص�ǰ׺��Ϊ A[0]
            // �Դ�����
            for (int i = 1; i <= n; i++) {
                sums[i] = sums[i - 1] + nums[i - 1];
            }
            for (int i = 1; i <= n; i++) {
                int target = s + sums[i - 1];
                int bound = Arrays.binarySearch(sums, target);
                if (bound < 0) {
                    bound = -bound - 1;
                }
                if (bound <= n) {
                    ans = Math.min(ans, bound - (i - 1));
                }
            }
            return ans == Integer.MAX_VALUE ? 0 : ans;
        }
    }
}
