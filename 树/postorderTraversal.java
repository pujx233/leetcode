package 树;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class postorderTraversal {

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
    class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<Integer>();
            postorder(root, res);
            return res;
        }

        public void postorder(TreeNode root, List<Integer> res) {
            if (root == null) {
                return;
            }
            postorder(root.left, res);
            postorder(root.right, res);
            res.add(root.val);
        }
    }


    /**
     * 迭代法使用prev作为判断
     * */

    class Solution_2 {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> ans = new ArrayList<>();

            if(root==null) {
                return ans;
            }
            Deque<TreeNode> stack = new ArrayDeque<>();
            TreeNode prev = null;

            while(!stack.isEmpty() || root!=null){
                while(root!=null){
                    stack.push(root);
                    root = root.left;
                }

                root = stack.pop();
                if(root.right==null || prev == root.right){
                    ans.add(root.val);
                    prev = root;
                    root = null;
                }else {
                    stack.push(root);
                    root = root.right;
                }
            }

            return ans;
        }
    }
}
