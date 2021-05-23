import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树
 * */

public class isValidBST {
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
     * 二叉搜索树中序遍历后为升序
     * */
    class Solution_1 {
        public boolean isValidBST(TreeNode root) {
            List<Integer> res = new ArrayList<Integer>();
            inOrder(root,res);
            for(int i = 0;i<res.size()-1;i++){
                if(res.get(i)>=res.get(i+1)){
                    return false;
                }
            }
            return true;
        }

        public void inOrder(TreeNode root,List<Integer> res){
            if(root==null){
                return;
            }
            inOrder(root.left,res);
            res.add(root.val);
            inOrder(root.right,res);
        }
    }

    /**
     * 递归
     * */
    class Solution_2 {
        public boolean isValidBST(TreeNode root) {
            return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
        }

        public boolean isValidBST(TreeNode node, long lower, long upper) {
            if (node == null) {
                return true;
            }
            if (node.val <= lower || node.val >= upper) {
                return false;
            }
            return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
        }
    }
}
