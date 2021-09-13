package 数组;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * */

public class subsets {

    class Solution {

        List<Integer> res = new ArrayList<Integer>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        public List<List<Integer>> subsets(int[] nums) {
            backtrack(0,nums);

            return ans;
        }

        public void backtrack(int len,int[] nums){
            if(len == nums.length){
                ans.add(new ArrayList<Integer>(res));
            }

            res.add(nums[len]);
            backtrack(len+1,nums);
            res.remove(res.size()-1);
            backtrack(len+1,nums);
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
}
