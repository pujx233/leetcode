package 树;

/**
 * 路径被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中至多出现一次 。
 * 该路径至少包含一个 节点，且不一定经过根节点。
 *
 * 路径和是路径中各节点值的总和。
 *
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 * */

public class binaryTreeMaxPathSum {

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

    class Solution {

        int max = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {

            dfs(root);

            return max;
        }

        public int dfs(TreeNode root){
            if(root==null){
                return 0;
            }

            int left = dfs(root.left);
            int right = dfs(root.right);

            int heightMax = Math.max(root.val,root.val+Math.max(left,right));
            max = Math.max(max,Math.max(heightMax,left+right+ root.val));

            return heightMax;
        }
    }
}
