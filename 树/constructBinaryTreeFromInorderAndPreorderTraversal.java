package 树;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一棵树的前序遍历 preorder 与中序遍历  inorder。请构造二叉树并返回其根节点。
 * */

public class constructBinaryTreeFromInorderAndPreorderTraversal {

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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            int n = preorder.length;
            HashMap indexMap = new HashMap<Integer,Integer>();
            for(int i = 0;i<n;i++){
                indexMap.put(inorder[i],i);
            }

            return null;
        }
    }

}
