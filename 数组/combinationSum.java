package 数组;

import java.util.*;

/**
 * 给定一个无重复元素的正整数数组 candidates 和一个正整数 target
 * 找出 candidates 中所有可以使数字和为目标数 target 的唯一组合。
 *
 * candidates 中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。
 *
 * 对于给定的输入，保证和为 target 的唯一组合数少于 150 个。
 *
 * */

public class combinationSum {

    class Solution {
        List<List<Integer>> res = new ArrayList<>(); //记录答案
        List<Integer> path = new ArrayList<>();  //记录路径

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            dfs(candidates,0, target);
            return res;
        }
        public void dfs(int[] c, int u, int target) {
            if(target < 0) return ;
            if(target == 0)
            {
                res.add(new ArrayList(path));
                return ;
            }
            for(int i = u; i < c.length; i++){
                if( c[i] <= target)
                {
                    path.add(c[i]);
                    dfs(c,i,target -  c[i]); // 因为可以重复使用，所以还是i
                    path.remove(path.size()-1); //回溯，恢复现场
                }
            }
        }
    }
}
