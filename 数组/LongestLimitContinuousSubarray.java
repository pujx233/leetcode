package ����;

import java.util.*;

/**
 * ����һ���������� nums ����һ����ʾ���Ƶ����� limit�����㷵�������������ĳ���
 * ���������е���������Ԫ��֮��ľ��Բ����С�ڻ��ߵ��� limit ��
 *
 * ������������������������飬�򷵻� 0 ��
 *
 *
 * */

public class LongestLimitContinuousSubarray {

    /**
     * �������� + ���򼯺�
     * */

    class Solution {
        public int longestSubarray(int[] nums, int limit) {
            TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
            int n = nums.length;
            int left = 0, right = 0;
            int ret = 0;
            while (right < n) {
                map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
                while (map.lastKey() - map.firstKey() > limit) {
                    map.put(nums[left], map.get(nums[left]) - 1);
                    if (map.get(nums[left]) == 0) {
                        map.remove(nums[left]);
                    }
                    left++;
                }
                ret = Math.max(ret, right - left + 1);
                right++;
            }
            return ret;
        }
    }

    /**
     * �������� + ��������
     * */

    class Solution_2 {
        public int longestSubarray(int[] nums, int limit) {
            Deque<Integer> queMax = new LinkedList<Integer>();
            Deque<Integer> queMin = new LinkedList<Integer>();
            int n = nums.length;
            int left = 0, right = 0;
            int ret = 0;
            while (right < n) {
                while (!queMax.isEmpty() && queMax.peekLast() < nums[right]) {
                    queMax.pollLast();
                }
                while (!queMin.isEmpty() && queMin.peekLast() > nums[right]) {
                    queMin.pollLast();
                }
                queMax.offerLast(nums[right]);
                queMin.offerLast(nums[right]);
                while (!queMax.isEmpty() && !queMin.isEmpty() && queMax.peekFirst() - queMin.peekFirst() > limit) {
                    if (nums[left] == queMin.peekFirst()) {
                        queMin.pollFirst();
                    }
                    if (nums[left] == queMax.peekFirst()) {
                        queMax.pollFirst();
                    }
                    left++;
                }
                ret = Math.max(ret, right - left + 1);
                right++;
            }
            return ret;
        }
    }

}
