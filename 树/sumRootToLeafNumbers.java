package 树;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 *
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 *
 * 叶节点 是指没有子节点的节点。
 * */



public class sumRootToLeafNumbers {

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
     * 深度优先
     * 注意要传值
     * */

    class Solution {
        int ans = 0;

        public int sumNumbers(TreeNode root) {
            if(root==null){
                return 0;
            }

            ans = dfs(root,0);

            return ans;
        }

        public int dfs(TreeNode root,int prev){
            if(root==null){
                return 0;
            }

            int sum = prev*10+root.val;
            if(root.left==null && root.right==null){
                return sum;
            }

            return dfs(root.left,sum)+dfs(root.right,sum);
        }
    }


    /**
     * 广度优先搜索
     * */

    class Solution_1 {

        public int sumNumbers(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int sum = 0;
            Deque<TreeNode> deque = new ArrayDeque<TreeNode>();
            Deque<Integer> numDeque = new ArrayDeque<Integer>();

            deque.offer(root);
            numDeque.offer(root.val);
            while(!deque.isEmpty()){
                TreeNode node = deque.poll();
                int temp = numDeque.poll();

                TreeNode left = node.left;TreeNode right = node.right;

                if(left==null&&right==null){
                    sum+=temp;
                }
                else{
                    if(left!=null){
                        deque.offer(node.left);
                        numDeque.offer(temp*10+node.left.val);
                    }
                    if(right!=null){
                        deque.offer(node.right);
                        numDeque.offer(temp*10+right.val);
                    }
                }
            }

            return sum;
        }
    }
}

