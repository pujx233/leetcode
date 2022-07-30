package 数组;

import java.util.*;

/**
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * */

public class permutations_2 {

    class Solution {

        boolean[] vis;
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        public List<List<Integer>> permuteUnique(int[] nums) {
            List<Integer> perm = new ArrayList<Integer>();
            vis = new boolean[nums.length];
            Arrays.sort(nums);
            backtrack(nums, 0, perm);
            return ans;
        }

        public void backtrack(int[] nums, int idx, List<Integer> perm) {
            if (idx == nums.length) {
                ans.add(new ArrayList<Integer>(perm));
                return;
            }
            for (int i = 0; i < nums.length; ++i) {
                if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                    continue;
                }
                perm.add(nums[i]);
                vis[i] = true;
                backtrack(nums, idx + 1, perm);
                vis[i] = false;
                perm.remove(idx);
            }
        }
    }
}
