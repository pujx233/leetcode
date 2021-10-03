package 数组;

import java.util.*;

/**
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * */

public class longestConsecutiveSequence {

    public static class Solution {
        public int longestConsecutive(int[] nums) {
            Set<Integer> numSet = new HashSet<>();

            for(int num:nums){
                numSet.add(num);
            }

            int ans = 0;
            for (int num : numSet) {
                if (!numSet.contains(num - 1)) {
                    int res = num;
                    int cnt = 1;

                    while (numSet.contains(res + 1)) {
                        res += 1;
                        cnt += 1;
                    }

                    ans = Math.max(ans, cnt);
                }
            }
            return ans;
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        solution.longestConsecutive(new int[]{100,4,200,1,3,2});
    }
}
