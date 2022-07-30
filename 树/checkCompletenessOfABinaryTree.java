package 树;

import java.util.*;

/**
 * 给定一个二叉树，确定它是否是一个完全二叉树。
 *
 * 百度百科中对完全二叉树的定义如下：
 *
 * 若设二叉树的深度为 h，除第 h 层外，其它各层 (1～h-1) 的结点数都达到最大个数
 * 第 h 层所有的结点都连续集中在最左边，这就是完全二叉树。(注：第 h 层可能包含 1~ 2h 个节点。)
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
     * Queue可以，Deque报空指针错误
     * Deque应该是不允许null值
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
