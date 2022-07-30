package ��;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * ��תһ�ö�������
 * */

public class invertBinaryTree {

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

    /**
     * ���¶��ϵݹ�(�����������)
     * */

    class Solution {
        public TreeNode invertTree(TreeNode root) {
            if(root == null){
                return null;
            }

            TreeNode left = invertTree(root.left);
            TreeNode right = invertTree(root.right);
            root.left = right;
            root.right = left;

            return root;
        }
    }

    /**
     * �����������
     * */

    class Solution_1 {
        public TreeNode invertTree(TreeNode root) {
            if(root == null){
                return null;
            }

            Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
            queue.offer(root);

            while (!queue.isEmpty()){
                TreeNode node = queue.poll();
                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;

                if(node.left!=null){
                    queue.offer(node.left);
                }

                if(node.right!=null){
                    queue.offer(node.right);
                }
            }


            return root;
        }
    }
}
