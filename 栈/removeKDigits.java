package 栈;

import java.util.*;

/**
 * 给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。
 * 请你以字符串形式返回这个最小的数字。
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

