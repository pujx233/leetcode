package 树;

import java.util.*;

/**
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 *
 * 叶子节点 是指没有子节点的节点。
 *
 * */

public class pathSum_2 {

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

        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        List<Integer> path = new ArrayList<>();
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

            dfs(root,targetSum);

            return ans;
        }

        public void dfs(TreeNode root,int target){
            if (root == null) {
                return;
            }

            path.add(root.val);
            target = target-root.val;
            if(target == 0 && root.left==null && root.right==null){
                ans.add(new LinkedList<>(path));
            }

            dfs(root.left,target);
            dfs(root.right,target);

            path.remove(path.size()-1);
        }
    }


    /**
     * 广度优先搜索
     * */

    class Solution_1 {

        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        Map<TreeNode, TreeNode> map = new HashMap<TreeNode, TreeNode>();
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            if (root == null) {
                return ans;
            }

            Deque<TreeNode> queueNode = new ArrayDeque<>();
            Deque<Integer> queueSum = new ArrayDeque<>();
            queueNode.offer(root);
            queueSum.offer(0);

            while (!queueNode.isEmpty()) {
                TreeNode node = queueNode.poll();
                int rec = queueSum.poll() + node.val;

                if (node.left == null && node.right == null) {
                    if (rec == targetSum) {
                        getPath(node);
                    }
                } else {
                    if (node.left != null) {
                        map.put(node.left, node);
                        queueNode.offer(node.left);
                        queueSum.offer(rec);
                    }
                    if (node.right != null) {
                        map.put(node.right, node);
                        queueNode.offer(node.right);
                        queueSum.offer(rec);
                    }
                }
            }

            return ans;
        }

        public void getPath(TreeNode node) {
            List<Integer> temp = new LinkedList<Integer>();
            while (node != null) {
                temp.add(node.val);
                node = map.get(node);
            }
            Collections.reverse(temp);
            ans.add(new LinkedList<Integer>(temp));
        }

    }

}
