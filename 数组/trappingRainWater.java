package 数组;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * */

public class trappingRainWater {

    /**
     * 双指针
     * */

    public static class Solution {
        public int trap(int[] height) {
            int ans = 0,minHeight = 0;
            int left = 0,right = height.length-1;

            int leftMax = 0, rightMax = 0;

            while (left<=right){
                leftMax = Math.max(leftMax, height[left]);
                rightMax = Math.max(rightMax, height[right]);
                if (height[left] < height[right]) {
                    ans += leftMax - height[left];
                    ++left;
                } else {
                    ans += rightMax - height[right];
                    --right;
                }
            }

            return ans;
        }
    }

    /**
     * 动态规划
     * */

    public static class Solution_1 {
        public int trap(int[] height) {
            int n = height.length;
            if (n == 0) {
                return 0;
            }

            int[] leftMax = new int[n];
            leftMax[0] = height[0];
            for (int i = 1; i < n; ++i) {
                leftMax[i] = Math.max(leftMax[i - 1], height[i]);
            }

            int[] rightMax = new int[n];
            rightMax[n - 1] = height[n - 1];
            for (int i = n - 2; i >= 0; --i) {
                rightMax[i] = Math.max(rightMax[i + 1], height[i]);
            }

            int ans = 0;
            for (int i = 0; i < n; ++i) {
                ans += Math.min(leftMax[i], rightMax[i]) - height[i];
            }
            return ans;
        }
    }

    /**
     * 单调栈
     * */

    public static class Solution_2 {
        public int trap(int[] height) {
            int ans = 0;
            Deque<Integer> stack = new LinkedList<Integer>();
            int n = height.length;
            for (int i = 0; i < n; ++i) {
                while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                    int top = stack.pop();
                    if (stack.isEmpty()) {
                        break;
                    }
                    int left = stack.peek();
                    int currWidth = i - left - 1;
                    int currHeight = Math.min(height[left], height[i]) - height[top];
                    ans += currWidth * currHeight;
                }
                stack.push(i);
            }
            return ans;
        }
    }

    public static void main(String[] args){
        int[] height = new int[]{0,1,0,2,1,0,1,0,2,1,2,1};
        Solution solution = new Solution();
        System.out.println(solution.trap(height));

    }

}
