package 栈;

import java.util.*;

/**
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。
 * 需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 * */

public class removeDuplicateLetters {

    public static class Solution {
        String removeDuplicateLetters(String s) {
            Stack<Character> stk = new Stack<>();

            // 维护一个计数器记录字符串中字符的数量
            // 因为输入为 ASCII 字符，大小 256 够用了
            int[] count = new int[256];
            for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i)]++;
            }

            boolean[] inStack = new boolean[256];
            for (char c : s.toCharArray()) {
                // 每遍历过一个字符，都将对应的计数减一
                count[c]--;

                if (inStack[c]) continue;

                while (!stk.isEmpty() && stk.peek() > c) {
                    // 若之后不存在栈顶元素了，则停止 pop
                    if (count[stk.peek()] == 0) {
                        break;
                    }
                    // 若之后还有，则可以 pop
                    inStack[stk.pop()] = false;
                }
                stk.push(c);
                inStack[c] = true;
            }

            StringBuilder sb = new StringBuilder();
            while (!stk.empty()) {
                sb.append(stk.pop());
            }
            return sb.reverse().toString();
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
