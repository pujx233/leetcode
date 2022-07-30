package ��;

import java.util.*;

/**
 * ����һ����������������ڵ�ֵ�Ե����ϵĲ�������� ��������Ҷ�ӽڵ����ڲ㵽���ڵ����ڵĲ㣬���������ұ�����
 * */

public class levelOrder_3 {
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
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            Queue<TreeNode> queue = new ArrayDeque<>();

            if (root != null) {
                queue.add(root);
            }

            while(!queue.isEmpty()){
                int n = queue.size();
                List<Integer> level = new ArrayList<>();
                for(int i = 0;i<n;i++){
                    TreeNode node  = queue.poll();
                    level.add(node.val);
                    if(node.left!=null){
                        queue.add(node.left);
                    }
                    if(node.right!=null){
                        queue.add(node.right);
                    }
                }
                ans.add(0,level);
            }

            return ans;
        }
    }
}
