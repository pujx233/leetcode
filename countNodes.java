import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 * */

public class countNodes {
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
     * 递归求解
     * */
    class Solution_1 {
        public int countNodes(TreeNode root) {
            if(root==null){
                return 0;
            }
            return 1+countNodes(root.left)+countNodes(root.right);
        }
    }

    /**
     * 完全二叉树是一棵空树或者它的叶子节点只出在最后两层，若最后一层不满则叶子节点只在最左侧
     *
     * */

    class Solution_2 {
        public int countNodes(TreeNode root) {
            if(root==null){
                return 0;
            }
            int left = countLever(root.left);
            int right = countLever(root.right);
            if(left==right){
                return countNodes(root.right)+(1<<left);
            }else {
                return countNodes(root.left)+(1<<right);
            }

        }

        public int countLever(TreeNode root){
            int lever = 0;
            while (root!=null){
                lever+=1;
                root = root.left;
            }
            return lever;
        }
    }

    /**
     * BFS遍历每一颗树
     * (超时)
     * */

    class Solution_3 {
        public int countNodes(TreeNode root) {
            if(root == null){
                return 0;
            }
            int count = 0;
            Queue<TreeNode> res = new LinkedList<TreeNode>();
            res.add(root);
            while (!res.isEmpty()){
                TreeNode node = res.poll();
                count++;
                if(node.left!=null){
                    res.add(root.left);
                }
                if(node.right!=null){
                    res.add(root.right);
                }
            }
            return count;
        }
    }
}
