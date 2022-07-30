package ��;

/**
 * ��һ�ö�����������Ҫ��������ֱ�����ȡ�һ�ö�������ֱ�������������������·�������е����ֵ������·�����ܴ���Ҳ���ܲ���������㡣
 * */

public class diameterOfBinaryTree {

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

        int ans;

        public int diameterOfBinaryTree(TreeNode root) {
            ans = 1;
            depth(root);
            return ans - 1;
        }

        public int depth(TreeNode node) {
            if (node == null) {
                return 0; // ���ʵ��սڵ��ˣ�����0
            }
            int L = depth(node.left); // �����Ϊ�������������
            int R = depth(node.right); // �Ҷ���Ϊ�������������
            ans = Math.max(ans, L+R+1); // ����d_node��L+R+1 ������ans
            return Math.max(L, R) + 1; // ���ظýڵ�Ϊ�������������
        }
    }
}
