package ��;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * ����������ĸ��ڵ� root ���������ڵ�ֵ�� ǰ�� ������
 * */

public class preorderTraversal {

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
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<Integer>();
            preorder(root, res);
            return res;
        }

        public void preorder(TreeNode root, List<Integer> res) {
            if (root == null) {
                return;
            }
            res.add(root.val);
            preorder(root.left, res);
            preorder(root.right, res);
        }
    }

    class Solution_2 {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<Integer>();
            if (root == null) {
                return res;
            }

            Deque<TreeNode> stack = new LinkedList<TreeNode>();
            TreeNode node = root;
            while (!stack.isEmpty() || node != null) {
                while (node != null) {
                    res.add(node.val);
                    stack.push(node);
                    node = node.left;
                }
                node = stack.pop();
                node = node.right;
            }
            return res;
        }
    }
}
