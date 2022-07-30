package ��;


import java.util.*;

/**
 * ����һ���������� ���ڵ� root�������Լ�վ�������Ҳ࣬���մӶ������ײ���˳�򣬷��ش��Ҳ����ܿ����Ľڵ�ֵ��
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
     * ������Ȳ������
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
     * ������Ȳ������
     * */

    List<Integer> ans = new ArrayList<>();

    public List<Integer> rightSideView_1(TreeNode root) {

        dfs(root,0);  // �Ӹ��ڵ㿪ʼ���ʣ����ڵ������0
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
