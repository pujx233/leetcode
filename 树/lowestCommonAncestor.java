package 树;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：
 * “对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * */

public class lowestCommonAncestor {
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
     * 深度优先搜索，存储父子关系
     * */

    class Solution {
        Map<Integer, TreeNode> parent = new HashMap<Integer, TreeNode>();
        Set<Integer> visited = new HashSet<Integer>();

        public void dfs(TreeNode root) {
            if (root.left != null) {
                parent.put(root.left.val, root);
                dfs(root.left);
            }
            if (root.right != null) {
                parent.put(root.right.val, root);
                dfs(root.right);
            }
        }

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            dfs(root);
            while (p != null) {
                visited.add(p.val);
                p = parent.get(p.val);
            }
            while (q != null) {
                if (visited.contains(q.val)) {
                    return q;
                }
                q = parent.get(q.val);
            }
            return null;
        }
    }

    /**
     * 1.
     *      1.当越过叶节点，则直接返回null ;
     *      2.当root等于p,q，则直接返回root;
     * 2.递推工作:
     *      1.开启递归左子节点，返回值记为left ;
     *      2.开启递归右子节点，返回值记为right ;
     * 3.返回值:根据left和right，可展开为四种情况;
     *      1.当left和right同时为空:说明root的左/右子树中都不包含p,q，返回null;
     *      2.当left和right同时不为空:说明p,q分列在root的异侧(分别在左/右子树)，因此
     *      root为最近公共祖先，返回root ;
     *      3.当left为空，right不为空: p,q都不在root的左子树中，直接返回right。具体可分为两
     *      种情况:
     *          1. p,q其中一个在root的右子树中，此时right指向p (假设为p) ;
     *          2. p,q两节点都在root 的右子树中，此时的right指向最近公共祖先节点;
     *      4.当left不为空，right为空:与情况3.同理;
     * */

    class Solution_2 {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(root == null || root == p || root == q) return root;
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if(left == null && right == null) return null; // 1.
            if(left == null) return right; // 3.
            if(right == null) return left; // 4.
            return root; // 2. if(left != null and right != null)
        }
    }
}
