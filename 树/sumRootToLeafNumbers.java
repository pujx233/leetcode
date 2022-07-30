package ��;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * ����һ���������ĸ��ڵ� root ������ÿ���ڵ㶼�����һ�� 0 �� 9 ֮������֡�
 * ÿ���Ӹ��ڵ㵽Ҷ�ڵ��·��������һ�����֣�
 *
 * ���磬�Ӹ��ڵ㵽Ҷ�ڵ��·�� 1 -> 2 -> 3 ��ʾ���� 123 ��
 * ����Ӹ��ڵ㵽Ҷ�ڵ����ɵ� ��������֮�� ��
 *
 * Ҷ�ڵ� ��ָû���ӽڵ�Ľڵ㡣
 * */



public class sumRootToLeafNumbers {

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
     * �������
     * ע��Ҫ��ֵ
     * */

    class Solution {
        int ans = 0;

        public int sumNumbers(TreeNode root) {
            if(root==null){
                return 0;
            }

            ans = dfs(root,0);

            return ans;
        }

        public int dfs(TreeNode root,int prev){
            if(root==null){
                return 0;
            }

            int sum = prev*10+root.val;
            if(root.left==null && root.right==null){
                return sum;
            }

            return dfs(root.left,sum)+dfs(root.right,sum);
        }
    }


    /**
     * �����������
     * */

    class Solution_1 {

        public int sumNumbers(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int sum = 0;
            Deque<TreeNode> deque = new ArrayDeque<TreeNode>();
            Deque<Integer> numDeque = new ArrayDeque<Integer>();

            deque.offer(root);
            numDeque.offer(root.val);
            while(!deque.isEmpty()){
                TreeNode node = deque.poll();
                int temp = numDeque.poll();

                TreeNode left = node.left;TreeNode right = node.right;

                if(left==null&&right==null){
                    sum+=temp;
                }
                else{
                    if(left!=null){
                        deque.offer(node.left);
                        numDeque.offer(temp*10+node.left.val);
                    }
                    if(right!=null){
                        deque.offer(node.right);
                        numDeque.offer(temp*10+right.val);
                    }
                }
            }

            return sum;
        }
    }
}

