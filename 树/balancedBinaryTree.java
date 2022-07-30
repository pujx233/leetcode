package ��;

/**
 * ����һ�����������ж����Ƿ��Ǹ߶�ƽ��Ķ�������
 *
 * �����У�һ�ø߶�ƽ�����������Ϊ��
 * һ��������ÿ���ڵ� ���������������ĸ߶Ȳ�ľ���ֵ������ 1
 * */

public class balancedBinaryTree {

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

        public boolean isBalanced(TreeNode root) {
            if(root==null){
                return true;
            }
            else {
                return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
            }

        }

        public int height(TreeNode root){
            if(root==null){
                return 0;
            }
            return 1+Math.max(height(root.left),height(root.right));
        }
    }


    class Solution_1 {

        public boolean isBalanced(TreeNode root) {
            return height(root)>=0;

        }

        public int height(TreeNode root){
            if(root==null){
                return 0;
            }

            int left = height(root.left);
            int right = height(root.right);

            if(left==-1||right==-1||Math.abs(left-right)>1){
                return -1;
            }

            return 1+Math.max(height(root.left),height(root.right));
        }
    }
}
