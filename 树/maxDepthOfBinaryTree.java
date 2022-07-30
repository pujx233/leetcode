package ��;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ����һ�����������ҳ��������ȡ�
 *
 * �����������Ϊ���ڵ㵽��ԶҶ�ӽڵ���·���ϵĽڵ�����
 *
 * ˵��: Ҷ�ӽڵ���ָû���ӽڵ�Ľڵ㡣
 * */

public class maxDepthOfBinaryTree {

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

        public int maxDepth(TreeNode root) {
            if(root == null){
                return 0;
            }
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }

    }

    class Solution_1 {

        public int maxDepth(TreeNode root) {
            if(root == null){
                return 0;
            }
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.offer(root);
            int ans = 0;
            while(!queue.isEmpty()){
                int size = queue.size();

                while (size>0){
                    TreeNode node = queue.poll();
                    if(node.left!=null){
                        queue.offer(node.left);
                    }
                    if(node.right!=null){
                        queue.offer(node.right);
                    }

                    size--;
                }
                ans++;
            }

            return ans;
        }

    }
}
