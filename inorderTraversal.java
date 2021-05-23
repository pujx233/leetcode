import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Deque;

/**
 * 给定一个二叉树的根节点root,返回它的中序遍历
 * */

public class inorderTraversal {

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
     * 方法一:中序遍历递归求解
     * 但是面试中往往不会这样考察*/
    class Solution_1 {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<Integer>();
            inOrder(root,res);
            return res;
        }

        public void inOrder(TreeNode temp,List<Integer> res){
            if(temp == null){
                return ;
            }
            inOrder(temp.left,res);
            res.add(temp.val);
            inOrder(temp.right,res);
        }
    }

    /**
     * 方法二:迭代法求解
     * 方法一的递归函数我们也可以用迭代的方式实现，两种方式是等价的。
     * 区别在于递归的时候隐式地维护了一个栈，而我们在迭代的时候需要显式地将这个栈模拟出来
     * */

    class Solution_2 {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<Integer>();
            Deque<TreeNode> stk = new LinkedList<TreeNode>();
            while(root!=null || !stk.isEmpty()){
                while(root!=null){
                    stk.push(root);
                    root = root.left;
                }
                root = stk.pop();
                res.add(root.val);
                root = root.right;
            }

            return res;
        }
    }
}
