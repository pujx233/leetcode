package 数组;

import java.util.*;

public class combinationSum_2 {

    public static class Solution {
        List<List<Integer>> res = new ArrayList<>(); //记录答案
        HashSet<List<Integer>> temp = new HashSet<List<Integer>>();
        List<Integer> path = new ArrayList<>();  //记录路径

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            dfs(candidates,0, target);
            return res;
        }
        public void dfs(int[] nums, int len, int target) {
            if(target < 0) return ;
            if(target == 0)
            {
                if(!temp.contains(path)){
                    res.add(new ArrayList(path));
                    temp.add(new ArrayList<>(path));
                }

                return ;
            }
            for(int i = len; i < nums.length; i++){
                if(i > len && nums[i] == nums[i-1]) continue;
                if( nums[i] <= target)
                {
                    path.add(nums[i]);
                    dfs(nums,i+1,target - nums[i]);
                    path.remove(path.size()-1); //回溯，恢复现场
                }
            }
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        solution.combinationSum2(new int[]{10,1,2,7,6,1,5},8);

    }
}
