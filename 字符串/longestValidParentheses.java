package 字符串;

import java.util.*;

/**
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 * */

public class longestValidParentheses {


    /**
     * 动态规划
     * */

    public static class Solution {
        public int longestValidParentheses(String s) {
            int ans = 0;
            int[] dp = new int[s.length()];

            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == ')') {
                    if (s.charAt(i - 1) == '(') {
                        dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                    } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                    }
                    ans = Math.max(ans, dp[i]);
                }
            }

            return ans;
        }
    }

    /**
     * 栈
     * */

    public static class Solution_1 {
        public int longestValidParentheses(String s) {
            int ans = 0;
            Deque<Integer> stack = new ArrayDeque<>();

            stack.push(-1);
            for(int i = 0;i<s.length();i++){
                if(s.charAt(i)=='('){
                    stack.push(i);
                }
                else {
                    stack.pop();
                    if(stack.isEmpty()){
                        stack.push(i);
                    }
                    else {
                        ans = Math.max(ans,i-stack.peek());
                    }
                }
            }

            return ans;
        }
    }


    public static void main(String []args){
        Solution_1 solution = new Solution_1();
        System.out.println(solution.longestValidParentheses(")()())"));
    }
}
