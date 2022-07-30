package ��;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * ����һ��������, �ҵ�����������ָ���ڵ������������ȡ�
 *
 * �ٶȰٿ�������������ȵĶ���Ϊ��
 * �������и��� T �������ڵ� p��q������������ȱ�ʾΪһ���ڵ� x��
 * ���� x �� p��q �������� x ����Ⱦ����ܴ�һ���ڵ�Ҳ���������Լ������ȣ�����
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
     * ��������������洢���ӹ�ϵ
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
     *      1.��Խ��Ҷ�ڵ㣬��ֱ�ӷ���null ;
     *      2.��root����p,q����ֱ�ӷ���root;
     * 2.���ƹ���:
     *      1.�����ݹ����ӽڵ㣬����ֵ��Ϊleft ;
     *      2.�����ݹ����ӽڵ㣬����ֵ��Ϊright ;
     * 3.����ֵ:����left��right����չ��Ϊ�������;
     *      1.��left��rightͬʱΪ��:˵��root����/�������ж�������p,q������null;
     *      2.��left��rightͬʱ��Ϊ��:˵��p,q������root�����(�ֱ�����/������)�����
     *      rootΪ����������ȣ�����root ;
     *      3.��leftΪ�գ�right��Ϊ��: p,q������root���������У�ֱ�ӷ���right������ɷ�Ϊ��
     *      �����:
     *          1. p,q����һ����root���������У���ʱrightָ��p (����Ϊp) ;
     *          2. p,q���ڵ㶼��root ���������У���ʱ��rightָ������������Ƚڵ�;
     *      4.��left��Ϊ�գ�rightΪ��:�����3.ͬ��;
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
