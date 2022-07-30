package 树;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 * */

public class averageOfLevelsInBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     *
     * */

    class Solution {
        public List<Double> averageOfLevels(TreeNode root) {
            List<Double> ans = new ArrayList<>();
            if(root==null){
                return ans;
            }

            Deque<TreeNode> res = new ArrayDeque<TreeNode>();
            res.offer(root);

            while(!res.isEmpty()){
                int size = res.size();
                double cnt = 0;

                for(int i=0;i<size;i++){
                    root = res.poll();
                    cnt+=root.val;
                    if(root.left!=null){
                        res.offer(root.left);
                    }
                    if(root.right!=null){
                        res.offer(root.right);
                    }

                }
                ans.add(cnt/size);
            }

            return ans;
        }
    }


    /**
     * 深度优先搜索
     * 要求维护层数和总数
     * */

    class Solution_2 {
        public List<Double> averageOfLevels(TreeNode root) {
            List<Integer> counts = new ArrayList<Integer>();
            List<Double> sums = new ArrayList<Double>();
            dfs(root, 0, counts, sums);
            List<Double> averages = new ArrayList<Double>();
            int size = sums.size();
            for (int i = 0; i < size; i++) {
                averages.add(sums.get(i) / counts.get(i));
            }
            return averages;
        }

        public void dfs(TreeNode root, int level, List<Integer> counts, List<Double> sums) {
            if (root == null) {
                return;
            }
            if (level < sums.size()) {
                sums.set(level, sums.get(level) + root.val);
                counts.set(level, counts.get(level) + 1);
            } else {
                sums.add(1.0 * root.val);
                counts.add(1);
            }
            dfs(root.left, level + 1, counts, sums);
            dfs(root.right, level + 1, counts, sums);
        }
    }
}
