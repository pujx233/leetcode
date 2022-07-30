package ��;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * ����������ĸ��ڵ� root ��һ����ʾĿ��͵����� targetSum ���жϸ������Ƿ���� ���ڵ㵽Ҷ�ӽڵ� ��·����
 * ����·�������нڵ�ֵ��ӵ���Ŀ��� targetSum ��
 *
 * Ҷ�ӽڵ� ��ָû���ӽڵ�Ľڵ㡣
 *
 *
 * */

public class pathSum {

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

    /**
     * �ݹ�
     * */

    class Solution {
        public boolean hasPathSum(TreeNode root, int sum) {
            if (root == null) {
                return false;
            }
            if (root.left == null && root.right == null) {
                return sum == root.val;
            }
            return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
        }
    }

    /**
     * ������ȱ���
     * */

    class Solution_1 {
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if(root==null){
                return false;
            }

            Deque<TreeNode> deque = new ArrayDeque<TreeNode>();
            Deque<Integer> numDeque = new ArrayDeque<Integer>();

            deque.offer(root); numDeque.offer(root.val);
            while(!deque.isEmpty()){
                TreeNode node = deque.poll();
                int num = numDeque.poll();

                if(node.left == null && node.right==null){
                    if(num == targetSum){
                        return true;
                    }
                    continue;
                }

                if(node.left!=null){
                    deque.offer(node.left);
                    numDeque.offer(num+node.left.val);
                }

                if(node.right!=null){
                    deque.offer(node.right);
                    numDeque.offer(num+node.right.val);
                }
            }
            return false;

        }
    }

}
