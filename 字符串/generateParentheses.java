package 字符串;

import java.util.*;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 有效括号组合需满足：左括号必须以正确的顺序闭合。
 * */

public class generateParentheses {

    class Solution {

        List<String> ans = new ArrayList<>();

        public List<String> generateParenthesis(int n) {
            if(n == 0){
                return null;
            }
            dfs("", n, n);

            return ans;
        }

        // 画出分支树，左分支小于右分支时直接返回

        private void dfs(String curStr, int left, int right) {
            if (left == 0 && right == 0) {
                ans.add(curStr);
                return;
            }

            // 剪枝（如图，左括号可以使用的个数严格大于右括号可以使用的个数，才剪枝，注意这个细节）
            if (left > right) {
                return;
            }

            if (left > 0) {
                dfs(curStr + "(", left - 1, right);
            }

            if (right > 0) {
                dfs(curStr + ")", left, right - 1);
            }
        }
    }
}
