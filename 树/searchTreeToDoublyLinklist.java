package ��;

import java.util.*;

/**
 * ����һ�ö��������������ö���������ת����һ�������ѭ��˫������
 * Ҫ���ܴ����κ��µĽڵ㣬ֻ�ܵ������нڵ�ָ���ָ��
 * */

public class searchTreeToDoublyLinklist {

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

        TreeNode pre, head;

        public TreeNode treeToDoublyList(TreeNode root) {
            if(root == null) return null;
            dfs(root);
            head.left = pre;
            pre.right = head;
            return head;
        }

        public void dfs(TreeNode cur) {
            if(cur == null) return;
            dfs(cur.left);
            if(pre != null) pre.right = cur;
            else head = cur;
            cur.left = pre;
            pre = cur;
            dfs(cur.right);
        }
    }
}
