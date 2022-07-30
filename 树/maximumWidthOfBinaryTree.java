package 树;

import java.util.*;

/**
 * 给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。
 * 这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。
 *
 * 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
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
            root.val = 0; //将所有节点都存上他在这一层的编号
            queue.offer(root);
            while (!queue.isEmpty()) {
                int levelSize = queue.size();
                for (int i = 0; i < levelSize; i++) {
                    TreeNode node = queue.poll();
                    //找到最左的节点记录值
                    if (i == 0) {
                        left= node.val;
                    }
                    //找到最右的节点，开始算与最左的节点直接的宽度
                    if (i == levelSize - 1) {
                        res = Math.max(res, node.val - left + 1);
                    }
                    //在层序遍历固定框架上稍作修改
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
