package 栈;

import java.util.*;

/**
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。
 * 需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 * */

public class removeDuplicateLetters {

    public static class Solution {
        public String removeDuplicateLetters(String s) {
            boolean[] vis = new boolean[26];
            int[] num = new int[26];
            for (int i = 0; i < s.length(); i++) {
                num[s.charAt(i) - 'a']++;
            }

            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (!vis[ch - 'a']) {
                    while (sb.length() > 0 && sb.charAt(sb.length() - 1) > ch) {
                        if (num[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                            vis[sb.charAt(sb.length() - 1) - 'a'] = false;
                            sb.deleteCharAt(sb.length() - 1);
                        } else {
                            break;
                        }
                    }
                    vis[ch - 'a'] = true;
                    sb.append(ch);
                }
                num[ch - 'a'] -= 1;
            }
            return sb.toString();
        }
    }

    public static class Solution_1 {
        public String removeDuplicateLetters(String s) {
            Deque<Character> stack = new LinkedList<>();

            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                // 栈中存在了当前字母，那么就不能再添加进去了
                if(stack.contains(c)) continue;
                // 如果栈顶元素比当前字母大，且后面还会出现该字母，那就弹出它
                while(!stack.isEmpty() && stack.peek() > c && s.indexOf(stack.peek(), i) > 0) {
                    stack.pop();
                }
                // 当前字母入栈
                stack.push(c);
            }

            StringBuilder res = new StringBuilder();
            // 将栈中的元素从底部弹出，就是答案了
            while(!stack.isEmpty()) {
                res.append(stack.pollLast());
            }

            return res.toString();
        }
    }



    public static void main(String[] args){
        String res = "cbacdcbc";

        System.out.println(new Solution().removeDuplicateLetters(res));
    }
}
