package 树;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 翻转一棵二叉树。
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
     * 自下而上递归(深度优先搜索)
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
     * 广度优先搜索
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
