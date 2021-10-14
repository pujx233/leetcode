package ջ;

import java.util.*;

/**
 * ����һ���ַ��� s ������ȥ���ַ������ظ�����ĸ��ʹ��ÿ����ĸֻ����һ�Ρ�
 * �豣֤ ���ؽ�����ֵ�����С��Ҫ���ܴ��������ַ������λ�ã���
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
                // ջ�д����˵�ǰ��ĸ����ô�Ͳ�������ӽ�ȥ��
                if(stack.contains(c)) continue;
                // ���ջ��Ԫ�رȵ�ǰ��ĸ���Һ��滹����ָ���ĸ���Ǿ͵�����
                while(!stack.isEmpty() && stack.peek() > c && s.indexOf(stack.peek(), i) > 0) {
                    stack.pop();
                }
                // ��ǰ��ĸ��ջ
                stack.push(c);
            }

            StringBuilder res = new StringBuilder();
            // ��ջ�е�Ԫ�شӵײ����������Ǵ���
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
