package 动态规划;

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
         * Note: 类名、方法名、参数名已经指定，请勿修改
         *
         *
         * 给予二叉树的头结点，请返回小偷依据上述原则，能偷到的最多的钱为何？
         * @param node TreeNode类 头结点
         * @return int整型
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
