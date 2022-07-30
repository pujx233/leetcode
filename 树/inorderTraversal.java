package ��;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Deque;

/**
 * ����һ���������ĸ��ڵ�root,���������������
 * */

public class inorderTraversal {

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
     * ����һ:��������ݹ����
     * ��������������������������
     * */
    class Solution_1 {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<Integer>();
            inOrder(root,res);
            return res;
        }

        public void inOrder(TreeNode temp,List<Integer> res){
            if(temp == null){
                return ;
            }
            inOrder(temp.left,res);
            res.add(temp.val);
            inOrder(temp.right,res);
        }
    }

    /**
     * ������:���������
     * ����һ�ĵݹ麯������Ҳ�����õ����ķ�ʽʵ�֣����ַ�ʽ�ǵȼ۵ġ�
     * �������ڵݹ��ʱ����ʽ��ά����һ��ջ���������ڵ�����ʱ����Ҫ��ʽ�ؽ����ջģ�����
     * */

    class Solution_2 {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<Integer>();
            Deque<TreeNode> stk = new LinkedList<TreeNode>();
            while(root!=null || !stk.isEmpty()){
                while(root!=null){
                    stk.push(root);
                    root = root.left;
                }
                root = stk.pop();
                res.add(root.val);
                root = root.right;
            }

            return res;
        }
    }
}
