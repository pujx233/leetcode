package 数组;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * */

public class subsets {

    public static class Solution {

        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        public List<List<Integer>> subsets(int[] nums) {
            if(nums.length == 0){
                return ans;
            }
            backtrack(0,nums,new ArrayList<Integer>());

            return ans;
        }

        public void backtrack(int begin,int[] nums,ArrayList<Integer> tmp){
            ans.add(new ArrayList<>(tmp));
            for(int i = begin;i<nums.length;i++){
                tmp.add(nums[i]);
                backtrack(i+1,nums,tmp);
                tmp.remove(tmp.size()-1);

            }
        }
    }


    /**
     * 子集类型题目可以使用位运算
     * */

    class Solution_1 {
        List<Integer> t = new ArrayList<Integer>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        public List<List<Integer>> subsets(int[] nums) {
            int n = nums.length;
            for (int mask = 0; mask < (1 << n); ++mask) {
                t.clear();
                for (int i = 0; i < n; ++i) {
                    if ((mask & (1 << i)) != 0) {
                        t.add(nums[i]);
                    }
                }
                ans.add(new ArrayList<Integer>(t));
            }
            return ans;
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.subsets(new int[] {1,2,3}));
    }
}
