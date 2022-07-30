package 树;

/**
 * 给你一个二叉树的根节点 root。设根节点位于二叉树的第 1 层，而根节点的子节点位于第 2 层，依此类推。
 *
 * 请返回层内元素之和 最大 的那几层（可能只有一层）的层号，并返回其中 最小 的那个。
 * */

public class maxLevelSum {

    public static class TreeNode {
        int val;
        pathSum.TreeNode left;
        pathSum.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, pathSum.TreeNode left, pathSum.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public int maxLevelSum(TreeNode root) {
            return 0;
        }
    }
}
