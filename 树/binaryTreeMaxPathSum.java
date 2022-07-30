package ��;

/**
 * ·��������Ϊһ������������ڵ�������ظ��ڵ�-�ӽڵ����ӣ��ﵽ����ڵ�����С�ͬһ���ڵ���һ��·���������������һ�� ��
 * ��·�����ٰ���һ�� �ڵ㣬�Ҳ�һ���������ڵ㡣
 *
 * ·������·���и��ڵ�ֵ���ܺ͡�
 *
 * ����һ���������ĸ��ڵ� root �������� ���·���� ��
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
