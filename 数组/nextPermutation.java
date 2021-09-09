package 数组;

import java.util.Arrays;

/**
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列（即组合出下一个更大的整数）。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须 原地 修改，只允许使用额外常数空间。
 * */

public class nextPermutation {
    /**
     * 我们需要将一个左边的「较小数」与一个右边的「较大数」交换，以能够让当前排列变大，从而得到下一个排列。
     *
     * 同时我们要让这个「较小数」尽量靠右，而「较大数」尽可能小。当交换完成后，「较大数」右边的数需要按照升序重新排列。
     * 这样可以在保证新排列大于原来排列的情况下，使变大的幅度尽可能小。
     * */

    static class Solution {
        public void nextPermutation(int[] nums) {
            int len = nums.length; int a = -1,b = -1;
            for(int i=len-2;i>=0;i--){
                if(nums[i]<nums[i+1]){
                    a = i;
                    break;
                }
            }

            if(a>=0) {
                for (int i = nums.length - 1; i >= 0; i--) {
                    if (nums[i] > nums[a]) {
                        b = i;
                        break;
                    }
                }
                swap(nums,a,b);
            }

            reverse(nums,a+1);

        }

        public void swap(int[] nums,int i,int j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        public void reverse(int[] nums,int start){
            int right = nums.length-1;int left = start;

            while (left<right){
                swap(nums,left,right);
                left++;
                right--;
            }
        }
    }

    public static void main(String args[]){
        Solution solution = new Solution();
        int []nums = new int[]{2, 4, 62, 5, 1, 35, 2, 6, 3};
        solution.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
