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
        Map<Integer,Integer> indexMap = new HashMap<Integer, Integer>();

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            int n = preorder.length;
            for(int i = 0;i<n;i++){
                indexMap.put(inorder[i],i);
            }

            return myBuildTree(preorder,inorder,0,n-1,0,n-1);
        }

        public TreeNode myBuildTree(int[] pre,int[] in,int pre_l,int pre_r,int in_l,int in_r){
            if(pre_l>pre_r){
                return null;
            }
            int pre_root = pre_l;
            int in_root = indexMap.get(pre[pre_root]);

            TreeNode root = new TreeNode((pre[pre_root]));

            int size_left_subtree = in_root - in_l;

            root.left = myBuildTree(pre,in,pre_l+1,pre_l+size_left_subtree,in_l,in_root-1);
            root.right = myBuildTree(pre,in,pre_l+size_left_subtree+1,pre_r,in_root+1,in_r);
            return root;
        }
    }

}
