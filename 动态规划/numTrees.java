package 动态规划;

/**
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的二叉搜索树有多少种？
 * 返回满足题意的二叉搜索树的种数。*/


public class numTrees {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
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
     * 其实建立表/数学方法求解都挺方便的……
     * 当然本题考察的还是动态规划
     * */

    class Solution {
        public int numTrees(int n) {
            int []G = new int[n+1];
            G[0] = 1;
            G[1] = 1;
            for(int i=2;i<=n;i++){
                for (int j = 1; j <= i; ++j) {
                    G[i] += G[j - 1] * G[i - j];
                }

            }
            return G[n];
        }
    }
}
