package �ַ���;

import java.util.*;

/**
 * ����һ���ַ��� s �������ת�ַ����е����� ���� ��
 *
 * ���� ���ɷǿո��ַ���ɵ��ַ�����s ��ʹ������һ���ո��ַ����е� ���� �ָ�����
 *
 * ���㷵��һ����ת s �е���˳���õ����ո��������ַ�����
 *
 * ˵����
 *
 * �����ַ��� s ������ǰ�桢������ߵ��ʼ��������Ŀո�
 * ��ת�󵥴ʼ�Ӧ������һ���ո�ָ���
 * ��ת����ַ����в�Ӧ��������Ŀո�
 *
 * */

public class reverseWord {

    /**
     * ����API
     * */

    class Solution {
        public String reverseWords(String s) {
            // ��ȥ��ͷ��ĩβ�Ŀհ��ַ�
            s = s.trim();
            // ����ƥ�������Ŀհ��ַ���Ϊ�ָ����ָ�
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
