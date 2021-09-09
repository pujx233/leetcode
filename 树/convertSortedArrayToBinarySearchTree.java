package 树;

/**
 * 深度优先搜索递归
 * */

public class convertSortedArrayToBinarySearchTree {

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
        public TreeNode sortedArrayToBST(int[] nums) {

            return dfs(nums,0,nums.length-1);

        }

        public TreeNode dfs(int []nums,int left,int right){
            if(left>right){
                return null;
            }

            int mid = (left+right)/2;

            TreeNode root = new TreeNode(nums[mid]);
            root.left = dfs(nums,left,mid-1);
            root.right = dfs(nums,mid+1,right);

            return root;
        }
    }
}
