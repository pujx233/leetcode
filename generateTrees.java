import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个整数 n ,请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同二叉搜索树
 * 可以按任意顺序返回答案
 * */

public class generateTrees {
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
     * 分治法
     * */

    class Solution {
        public List<TreeNode> generateTrees(int n) {
            return generateTrees(1, n);
        }

        private List<TreeNode> generateTrees(int start, int end) {
            List<TreeNode> curRes = new LinkedList<TreeNode>();
            if (start > end) {
                curRes.add(null);
                return curRes;
            }
            for (int i = start; i <= end; i++) {
                List<TreeNode> leftNodeList = generateTrees(start, i - 1);
                List<TreeNode> rightNodeList = generateTrees(i + 1, end);

                for (TreeNode leftNode : leftNodeList) {
                    for (TreeNode rightNode : rightNodeList) {
                        curRes.add(new TreeNode(i, leftNode, rightNode));
                    }
                }
            }

            return curRes;
        }

    }
}
