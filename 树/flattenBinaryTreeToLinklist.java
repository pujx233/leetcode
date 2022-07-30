package ��;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * ����������ĸ���� root �����㽫��չ��Ϊһ��������
 *
 * չ����ĵ�����Ӧ��ͬ��ʹ�� TreeNode ������ right ��ָ��ָ����������һ����㣬������ָ��ʼ��Ϊ null ��
 * չ����ĵ�����Ӧ��������� ������� ˳����ͬ��
 * */

public class flattenBinaryTreeToLinklist {

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
     * ǰ�����
     * */

    class Solution {
        List<TreeNode> list = new ArrayList<TreeNode>();
        public void flatten(TreeNode root) {
            preorder(root);
            int size = list.size();

            for(int i = 1;i < size;i++){
                TreeNode prev = list.get(i-1);
                TreeNode curr = list.get(i);
                prev.left = null;
                prev.right = curr;
            }
        }

        private void preorder(TreeNode root){
            if(root==null){
                return;
            }

            list.add(root);
            preorder(root.left);
            preorder(root.right);
        }
    }

    /**
     * ǰ������������棩
     * */

    class Solution_1 {
        public void flatten(TreeNode root) {
            List<TreeNode> list = new ArrayList<TreeNode>();
            Deque<TreeNode> stack = new LinkedList<TreeNode>();
            TreeNode node = root;
            while (node != null || !stack.isEmpty()) {
                while (node != null) {
                    list.add(node);
                    stack.push(node);
                    node = node.left;
                }
                node = stack.pop();
                node = node.right;
            }
            int size = list.size();
            for (int i = 1; i < size; i++) {
                TreeNode prev = list.get(i - 1), curr = list.get(i);
                prev.left = null;
                prev.right = curr;
            }
        }
    }

    /**
     * �����ⷨ
     * */

    class Solution_2{

        public void flatten(TreeNode root) {
            while (root != null) {
                //������Ϊ null��ֱ�ӿ�����һ���ڵ�
                if (root.left == null) {
                    root = root.right;
                } else {
                    // �����������ұߵĽڵ�
                    TreeNode pre = root.left;
                    while (pre.right != null) {
                        pre = pre.right;
                    }
                    //��ԭ�����������ӵ������������ұ߽ڵ�
                    pre.right = root.right;
                    // �����������뵽�������ĵط�
                    root.right = root.left;
                    root.left = null;
                    // ������һ���ڵ�
                    root = root.right;
                }
            }
        }
    }


}
