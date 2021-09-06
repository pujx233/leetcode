package 数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 **/

public class threeSum {

    /**
     * 特判，对于数组长度 n，如果数组为 null 或者数组长度小于 3，返回 []。
     * 对数组进行排序。
     * 遍历排序后数组：
     * 若 nums[i]>0：因为已经排序好，所以后面不可能有三个数加和等于 0，直接返回结果。
     * 对于重复元素：跳过，避免出现重复解
     * 令左指针 L=i+1，右指针 R=n-1，当 L<R时，执行循环：
     * 当 nums[i]+nums[L]+nums[R]==0，执行循环，判断左界和右界是否和下一位置重复，去除重复解。并同时将 L,RL,R 移到下一位置，寻找新的解
     * 若和大于 0，说明 nums[R] 太大，R 左移
     * 若和小于 0，说明 nums[L] 太小，L 右移
     * **/

    static class Solution {
        public static List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();

            if(nums == null || nums.length<3){
                return res;
            }
            int len = nums.length;

            Arrays.sort(nums);

            for(int i = 0;i<len-2;i++){
                if(nums[i]>0){
                    System.out.println(res);
                    return res;
                }
                if(i!=0 && nums[i] == nums[i-1]) {
                    continue;
                }

                int cur = nums[i];
                int left = i+1;
                int right = len-1;

                while (left<right){

                    if(cur+nums[left]+nums[right]<0){
                        left +=1;
                    }else if(cur+nums[left]+nums[right]>0){
                        right -=1;
                    }else {
                        List<Integer> list = new ArrayList<>();
                        list.add(cur);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        res.add(list);

                        while(left < right && nums[left+1] == nums[left]) ++left;
                        while (left < right && nums[right-1] == nums[right]) --right;
                        ++left;
                        --right;
                    }
                }


            }
            System.out.println(res);
            return res;
        }


        public static void main(String args[]){
            threeSum(new int[]{0, 0, 0, 1, 0});
        }
    }
}
