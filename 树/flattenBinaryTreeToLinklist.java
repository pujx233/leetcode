package 树;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 *
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 * */

public class flattenBinaryTreeToLinklist {

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
     * 前序遍历
     * */

    class Solution {
        List<TreeNode> list = new ArrayList<TreeNode>();
        public void flatten(TreeNode root) {
            preorder(root);
            int size = list.size();

            for(int i = 1;i < size;i++){
                TreeNode prev = list.get(i-1);
                TreeNode curr = list.get(i);
                prev.left = null;
                prev.right = curr;
            }
        }

        private void preorder(TreeNode root){
            if(root==null){
                return;
            }

            list.add(root);
            preorder(root.left);
            preorder(root.right);
        }
    }

    /**
     * 前序遍历（迭代版）
     * */

    class Solution_1 {
        public void flatten(TreeNode root) {
            List<TreeNode> list = new ArrayList<TreeNode>();
            Deque<TreeNode> stack = new LinkedList<TreeNode>();
            TreeNode node = root;
            while (node != null || !stack.isEmpty()) {
                while (node != null) {
                    list.add(node);
                    stack.push(node);
                    node = node.left;
                }
                node = stack.pop();
                node = node.right;
            }
            int size = list.size();
            for (int i = 1; i < size; i++) {
                TreeNode prev = list.get(i - 1), curr = list.get(i);
                prev.left = null;
                prev.right = curr;
            }
        }
    }

    /**
     * 暴力解法
     * */

    class Solution_2{

        public void flatten(TreeNode root) {
            while (root != null) {
                //左子树为 null，直接考虑下一个节点
                if (root.left == null) {
                    root = root.right;
                } else {
                    // 找左子树最右边的节点
                    TreeNode pre = root.left;
                    while (pre.right != null) {
                        pre = pre.right;
                    }
                    //将原来的右子树接到左子树的最右边节点
                    pre.right = root.right;
                    // 将左子树插入到右子树的地方
                    root.right = root.left;
                    root.left = null;
                    // 考虑下一个节点
                    root = root.right;
                }
            }
        }
    }


}
