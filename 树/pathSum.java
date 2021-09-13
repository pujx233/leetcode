package 树;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum ，判断该树中是否存在 根节点到叶子节点 的路径，
 * 这条路径上所有节点值相加等于目标和 targetSum 。
 *
 * 叶子节点 是指没有子节点的节点。
 *
 *
 * */

public class pathSum {

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

    /**
     * 递归
     * */

    class Solution {
        public boolean hasPathSum(TreeNode root, int sum) {
            if (root == null) {
                return false;
            }
            if (root.left == null && root.right == null) {
                return sum == root.val;
            }
            return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
        }
    }

    /**
     * 广度优先遍历
     * */

    class Solution_1 {
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if(root==null){
                return false;
            }

            Deque<TreeNode> deque = new ArrayDeque<TreeNode>();
            Deque<Integer> numDeque = new ArrayDeque<Integer>();

            deque.offer(root); numDeque.offer(root.val);
            while(!deque.isEmpty()){
                TreeNode node = deque.poll();
                int num = numDeque.poll();

                if(node.left == null && node.right==null){
                    if(num == targetSum){
                        return true;
                    }
                    continue;
                }

                if(node.left!=null){
                    deque.offer(node.left);
                    numDeque.offer(num+node.left.val);
                }

                if(node.right!=null){
                    deque.offer(node.right);
                    numDeque.offer(num+node.right.val);
                }
            }
            return false;

        }
    }

}
