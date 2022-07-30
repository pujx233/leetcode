package ��;

import java.util.*;

/**
 * ����һ������������дһ����������ȡ�����������ȡ����Ŀ�������в��е�����ȡ�
 * ���������������������full binary tree���ṹ��ͬ����һЩ�ڵ�Ϊ�ա�
 *
 * ÿһ��Ŀ�ȱ�����Ϊ�����˵㣨�ò���������ҵķǿսڵ㣬���˵���null�ڵ�Ҳ���볤�ȣ�֮��ĳ��ȡ�
 * */

public class maximumWidthOfBinaryTree {

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
        public int widthOfBinaryTree(TreeNode root) {
            if (root == null) return 0;
            int res = 0, left = 0;
            Queue<TreeNode> queue = new LinkedList<>();
            root.val = 0; //�����нڵ㶼����������һ��ı��
            queue.offer(root);
            while (!queue.isEmpty()) {
                int levelSize = queue.size();
                for (int i = 0; i < levelSize; i++) {
                    TreeNode node = queue.poll();
                    //�ҵ�����Ľڵ��¼ֵ
                    if (i == 0) {
                        left= node.val;
                    }
                    //�ҵ����ҵĽڵ㣬��ʼ��������Ľڵ�ֱ�ӵĿ��
                    if (i == levelSize - 1) {
                        res = Math.max(res, node.val - left + 1);
                    }
                    //�ڲ�������̶�����������޸�
                    if (node.left != null) {
                        node.left.val = node.val << 1;
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        node.right.val = (node.val << 1) + 1;
                        queue.offer(node.right);
                    }
                }
            }
            return res;
        }
    }
}
