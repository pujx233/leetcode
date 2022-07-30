package 字符串;

import java.util.*;

/**
 * 给你一个字符串 s ，逐个翻转字符串中的所有 单词 。
 *
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 *
 * 请你返回一个翻转 s 中单词顺序并用单个空格相连的字符串。
 *
 * 说明：
 *
 * 输入字符串 s 可以在前面、后面或者单词间包含多余的空格。
 * 翻转后单词间应当仅用一个空格分隔。
 * 翻转后的字符串中不应包含额外的空格。
 *
 * */

public class reverseWord {

    /**
     * 调用API
     * */

    class Solution {
        public String reverseWords(String s) {
            // 除去开头和末尾的空白字符
            s = s.trim();
            // 正则匹配连续的空白字符作为分隔符分割
            List<String> wordList = Arrays.asList(s.split("\\s+"));
            Collections.reverse(wordList);
            return String.join(" ", wordList);
        }
    }

    /**
     *
     * */

    static class Solution_2 {
        public String reverseWords(String s) {
            int left = 0;int right = s.length()-1;

            while (left<=right && s.charAt(left)==' '){
                left++;
            }
            while (left<=right && s.charAt(right)==' '){
                right--;
            }
            Deque<String> ans = new ArrayDeque<>();
            StringBuilder temp = new StringBuilder();
            while(left<=right){
                char m = s.charAt(left);
                if(m ==' ' && temp.length()!=0){
                    ans.push(String.valueOf(temp));
                    temp.setLength(0);
                }
                else if(m!=' '){
                    temp.append(m);
                }
                left++;
            }

            ans.push(String.valueOf(temp));

            return String.join(" ",ans);
        }
    }

    public static void main(String args[]){
        Solution_2 solution = new Solution_2();
        System.out.println(solution.reverseWords("the sky is blue"));
    }
}
