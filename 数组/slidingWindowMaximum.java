package ����;

import java.util.*;

/**
 * ����һ���������� nums����һ����СΪ k �Ļ������ڴ������������ƶ�����������Ҳࡣ
 * ��ֻ���Կ����ڻ��������ڵ� k �����֡���������ÿ��ֻ�����ƶ�һλ��
 *
 * ���ػ��������е����ֵ��
 * */

public class slidingWindowMaximum {

    public static class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0]!=o2[0]?o2[0]-o1[0]:o2[1]-o1[1];
                }
            });

            for (int i = 0; i < k; ++i) {
                pq.offer(new int[]{nums[i], i});
            }
            int[] ans = new int[n - k + 1];
            ans[0] = pq.peek()[0];
            for (int i = k; i < n; ++i) {
                pq.offer(new int[]{nums[i], i});
                while (pq.peek()[1] <= i - k) {
                    pq.poll();
                }
                ans[i - k + 1] = pq.peek()[0];
            }
            return ans;
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();

        int[] nums = new int[] {1,3,-1,-3,5,3,6,7};
        int k = 3;

        System.out.println(Arrays.toString(solution.maxSlidingWindow(nums, k)));
    }

}
