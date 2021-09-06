package 树;


import java.util.*;

/**
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * */

public class rightSideView {

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

    /**
     * 广度优先层序遍历
     * */

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans  = new ArrayList<>();

        if(root==null){
            return ans;
        }

        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int n = queue.size();
            for(int i = 0;i<n;i++){
                TreeNode node = queue.poll();
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }

                if(i == n-1){
                    ans.add(node.val);
                }
            }
        }

        return ans;
    }

    /**
     * 深度优先层序遍历
     * */

    List<Integer> ans = new ArrayList<>();

    public List<Integer> rightSideView_1(TreeNode root) {

        dfs(root,0);  // 从根节点开始访问，根节点深度是0
        return ans;
    }

    private void dfs(TreeNode root,int depth){
        if(root == null){
            return;
        }

        if(ans.size()==depth){
            ans.add(root.val);
        }

        depth++;

        dfs(root.right,depth);
        dfs(root.left,depth);
    }

}
