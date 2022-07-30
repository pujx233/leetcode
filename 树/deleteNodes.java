package ��;

/**
 * ����һ�������������ĸ��ڵ� root ��һ��ֵ key��ɾ�������������е� key ��Ӧ�Ľڵ㣬����֤���������������ʲ��䡣���ض������������п��ܱ����£��ĸ��ڵ�����á�
 *
 * һ����˵��ɾ���ڵ�ɷ�Ϊ�������裺
 *
 * �����ҵ���Ҫɾ���Ľڵ㣻
 * ����ҵ��ˣ�ɾ������
 *
 * */

public class deleteNodes {

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
        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null) {
                return null;
            }
            if (root.val > key) {
                root.left = deleteNode(root.left, key);
                return root;
            }
            if (root.val < key) {
                root.right = deleteNode(root.right, key);
                return root;
            }
            if (root.val == key) {
                if (root.left == null && root.right == null) {
                    return null;
                }
                if (root.right == null) {
                    return root.left;
                }
                if (root.left == null) {
                    return root.right;
                }
                TreeNode successor = root.right;
                while (successor.left != null) {
                    successor = successor.left;
                }
                root.right = deleteNode(root.right, successor.val);
                successor.right = root.right;
                successor.left = root.left;
                return successor;
            }
            return root;
        }
    }
}
