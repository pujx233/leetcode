package ��;

import java.util.*;

/**
 * ����һ����������ȷ�����Ƿ���һ����ȫ��������
 *
 * �ٶȰٿ��ж���ȫ�������Ķ������£�
 *
 * ��������������Ϊ h������ h ���⣬�������� (1��h-1) �Ľ�������ﵽ������
 * �� h �����еĽ�㶼��������������ߣ��������ȫ��������(ע���� h ����ܰ��� 1~ 2h ���ڵ㡣)
 *
 * */

public class checkCompletenessOfABinaryTree {

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
     * Queue���ԣ�Deque����ָ�����
     * DequeӦ���ǲ�����nullֵ
     * */

    class Solution {
        public boolean isCompleteTree(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            TreeNode prev = root;
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (prev == null && node != null)
                    return false;
                if (node != null) {
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
                prev = node;
            }
            return true;
        }
    }
}
