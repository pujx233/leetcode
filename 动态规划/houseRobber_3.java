package ��̬�滮;

import java.util.*;

public class houseRobber_3 {


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


    public class Solution {
        /**
         * Note: ���������������������Ѿ�ָ���������޸�
         *
         *
         * �����������ͷ��㣬�뷵��С͵��������ԭ����͵��������ǮΪ�Σ�
         * @param node TreeNode�� ͷ���
         * @return int����
         */

        Map<TreeNode,Integer> f = new HashMap<>();
        Map<TreeNode,Integer> g = new HashMap<>();

        public int getMaxMoney(TreeNode node) {
            dfs(node);
            return Math.max(f.getOrDefault(node,0),g.getOrDefault(node,0));
        }

        public void dfs(TreeNode node){
            if(node==null){
                return;
            }
            dfs(node.left);
            dfs(node.right);
            f.put(node,node.val+g.getOrDefault(node.left,0)+g.getOrDefault(node.right,0));
            g.put(node,Math.max(f.getOrDefault(node.left,0),g.getOrDefault(node.left,0))+Math.max(f.getOrDefault(node.right,0),g.getOrDefault(node.right,0)));
        }
    }

}
