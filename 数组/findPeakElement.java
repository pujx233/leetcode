package 数组;

/**
 * 峰值元素是指其值严格大于左右相邻值的元素。
 *
 * 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 *
 * 你可以假设 nums[-1] = nums[n] = -∞ 。
 *
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 *
 *
 * */

public class findPeakElement {

    /**
     * 寻找最大值
     * */

    class Solution {
        public int findPeakElement(int[] nums) {
            int idx = 0;
            for (int i = 1; i < nums.length; ++i) {
                if (nums[i] > nums[idx]) {
                    idx = i;
                }
            }
            return idx;
        }
    }

    /**
     * 线性搜索
     * */

    class Solution_1 {
        public int findPeakElement(int[] nums) {
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                boolean ok = true;
                if (i - 1 >= 0) {
                    if (nums[i - 1] >= nums[i]) ok = false;
                }
                if (i + 1 < n) {
                    if (nums[i + 1] >= nums[i]) ok = false;
                }
                if (ok) return i;
            }
            return -1;
        }
    }


    /**
     * 二分搜索
     * */

    class Solution_2 {
        public int findPeakElement(int[] nums) {
            int left = 0, right = nums.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] > nums[mid + 1]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }
    }

}
