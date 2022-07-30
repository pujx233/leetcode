package ��;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ����һ�� ��ȫ������ �ĸ��ڵ� root ����������Ľڵ������
 * */

public class countNodes {
    public class TreeNode {
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
     * �ݹ����
     * */
    class Solution_1 {
        public int countNodes(TreeNode root) {
            if(root==null){
                return 0;
            }
            return 1+countNodes(root.left)+countNodes(root.right);
        }
    }

    /**
     * ��ȫ��������һ�ÿ�����������Ҷ�ӽڵ�ֻ����������㣬�����һ�㲻����Ҷ�ӽڵ�ֻ�������
     *
     * */

    class Solution_2 {
        public int countNodes(TreeNode root) {
            if(root==null){
                return 0;
            }
            int left = countLever(root.left);
            int right = countLever(root.right);
            if(left==right){
                return countNodes(root.right)+(1<<left);
            }else {
                return countNodes(root.left)+(1<<right);
            }

        }

        public int countLever(TreeNode root){
            int lever = 0;
            while (root!=null){
                lever+=1;
                root = root.left;
            }
            return lever;
        }
    }

    /**
     * BFS����ÿһ����
     * (��ʱ)
     * */

    class Solution_3 {
        public int countNodes(TreeNode root) {
            if(root == null){
                return 0;
            }
            int count = 0;
            Queue<TreeNode> res = new LinkedList<TreeNode>();
            res.add(root);
            while (!res.isEmpty()){
                TreeNode node = res.poll();
                count++;
                if(node.left!=null){
                    res.add(root.left);
                }
                if(node.right!=null){
                    res.add(root.right);
                }
            }
            return count;
        }
    }
}
