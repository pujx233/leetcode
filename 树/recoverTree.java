package ��;

import java.util.ArrayList;
import java.util.List;

/**
 * ��������������ĸ��ڵ� root �������е������ڵ㱻����ؽ��������ڲ��ı���ṹ������£��ָ������*/

public class recoverTree {
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
     * ����������
     * */
    class Solution {
        public void recoverTree(TreeNode root) {
            List<TreeNode> res= new ArrayList<TreeNode>();
            TreeNode e_1 = null;
            TreeNode e_2 = null;
            inorder(root,res);
            for(int i = 0;i<res.size()-1;i++){
                if(res.get(i).val>res.get(i+1).val){
                    e_2 = res.get(i+1);
                    if(e_1==null) {
                        e_1 = res.get(i);
                    }
                }
            }
            if(e_1!=null && e_2!=null){
                int tmp = e_1.val;
                e_1.val = e_2.val;
                e_2.val = tmp;

            }
        }

        public void inorder(TreeNode root,List<TreeNode> res){
            if(root == null){
                return;
            }
            inorder(root.left,res);
            res.add(root);
            inorder(root.right,res);
        }
    }
}
