package 树;

public class KthNodeOfTree {

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

        int ans, k;

        public int kthLargest(TreeNode root, int k) {
            this.k = k;
            dfs(root);
            return ans;
        }

        public void dfs(TreeNode root) {
            if(root == null) {
                return;
            }

            dfs(root.right);

            if(k == 0) {
                return;
            }

            k = k - 1;

            if(k == 0) {
                ans = root.val;
            }
            dfs(root.left);
        }
    }

}
