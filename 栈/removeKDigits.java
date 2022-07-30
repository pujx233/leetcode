package ջ;

import java.util.*;

/**
 * ����һ�����ַ�����ʾ�ķǸ����� num ��һ������ k ���Ƴ�������е� k λ���֣�ʹ��ʣ�µ�������С��
 * �������ַ�����ʽ���������С�����֡�
 * */

public class removeKDigits {

    public static class Solution {
        public String removeKDigits(String num, int k) {

            Deque<Character> deque = new ArrayDeque<>();
            int len = num.length();

            for(int i = 0;i<len;i++){
                char digit = num.charAt(i);
                while (!deque.isEmpty() && k>0 && deque.peek()>digit){
                    deque.pop();
                    k--;
                }
                deque.push(digit);
            }

            for(int i = 0;i<k;i++){
                deque.pop();
            }

            StringBuffer sb = new StringBuffer();
            boolean zero = true;


            while (!deque.isEmpty()){
                char digit = deque.pollLast();
                if (zero && digit == '0') {
                    continue;
                }

                zero = false;
                sb.append(digit);
            }

            if(sb.length()==0){
                return "0";
            }

            return sb.toString();
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.removeKDigits("10200",1));
    }
}

