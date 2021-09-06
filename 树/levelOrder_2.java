package 树;

import java.util.*;

/**
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。
 * 即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行
 * */

public class levelOrder_2 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            Queue<TreeNode> queue = new ArrayDeque<>();
            int flag = 1;
            if (root != null) {
                queue.add(root);

            }

            while(!queue.isEmpty()){
                int n = queue.size();
                List<Integer> level = new ArrayList<>();
                for(int i = 0;i<n;i++){
                    TreeNode node  = queue.poll();
                    level.add(node.val);

                    if(node.left!=null){
                        queue.add(node.left);
                    }
                    if(node.right!=null){
                        queue.add(node.right);
                    }

                }
                if ((flag % 2) != 1) {
                    Collections.reverse(level);
                }
                ans.add(level);
                flag++;

            }

            return ans;
        }
    }

}
