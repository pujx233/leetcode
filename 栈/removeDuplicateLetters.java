package ջ;

import java.util.*;

/**
 * ����һ���ַ��� s ������ȥ���ַ������ظ�����ĸ��ʹ��ÿ����ĸֻ����һ�Ρ�
 * �豣֤ ���ؽ�����ֵ�����С��Ҫ���ܴ��������ַ������λ�ã���
 * */

public class removeDuplicateLetters {

    public static class Solution {
        String removeDuplicateLetters(String s) {
            Stack<Character> stk = new Stack<>();

            // ά��һ����������¼�ַ������ַ�������
            // ��Ϊ����Ϊ ASCII �ַ�����С 256 ������
            int[] count = new int[256];
            for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i)]++;
            }

            boolean[] inStack = new boolean[256];
            for (char c : s.toCharArray()) {
                // ÿ������һ���ַ���������Ӧ�ļ�����һ
                count[c]--;

                if (inStack[c]) continue;

                while (!stk.isEmpty() && stk.peek() > c) {
                    // ��֮�󲻴���ջ��Ԫ���ˣ���ֹͣ pop
                    if (count[stk.peek()] == 0) {
                        break;
                    }
                    // ��֮���У������ pop
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
