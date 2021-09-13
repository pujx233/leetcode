package 字符串;

/**
 * 「快乐前缀」是在原字符串中既是 非空 前缀也是后缀（不包括原字符串自身）的字符串。
 *
 * 给你一个字符串 s，请你返回它的 最长快乐前缀。
 *
 * 如果不存在满足题意的前缀，则返回一个空字符串。
 * */

public class longestHappyPrefix {

    public static class Solution {
        public String longestPrefix(String s) {
            int len = s.length();

            if(len==0 || len==1){
                return "";
            }
            s = " "+s;
            char[] chars = s.toCharArray();
            int[] next = new int[len+1];

            for(int i = 2,j = 0;i<=len;i++){
                while(j>0 && chars[i]!=chars[j+1]){
                    j = next[j];
                }
                if(chars[i] ==chars[j+1]){
                    j++;
                }
                next[i] = j;
            }

            int max = next[next.length-1];

            return s.substring(1,1+max);
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.longestPrefix("bba"));
    }

}
