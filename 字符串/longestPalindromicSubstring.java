package �ַ���;

/**
 * ����һ���ַ��� s���ҵ� s ����Ļ����Ӵ���
 * */

public class longestPalindromicSubstring {

    /**
     * ������ɢ��
     * */
    static class Solution {
        public String longestPalindrome(String s) {
            if(s==null || s.length()==0){
                return null;
            }

            int len = 1;int max = 0;int start =0;int left;int right;

            for(int i = 0;i<s.length();i++){
                left = i;right = i;
                while(left-1>=0 && s.charAt(left-1)==s.charAt(i)){
                    left--;
                    len++;
                }
                while(right+1<s.length() && s.charAt(right+1)==s.charAt(i)){
                    right++;
                    len++;
                }
                while(left-1>=0 && right+1<s.length() && s.charAt(right+1)==s.charAt(left-1)){
                    left--;
                    right++;
                    len+=2;
                }
                if(len>max){
                    max = len;
                    start = left;
                }
                len = 1;
            }

            return s.substring(start,start+max);
        }
    }

    /**
     * ��̬�滮
     * */

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int strLen = s.length();
        int maxStart = 0;  //����Ĵ������
        int maxEnd = 0;    //����Ĵ����յ�
        int maxLen = 1;  //����Ĵ��ĳ���

        boolean[][] dp = new boolean[strLen][strLen];

        for (int r = 1; r < strLen; r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    if (r - l + 1 > maxLen) {
                        maxLen = r - l + 1;
                        maxStart = l;
                        maxEnd = r;

                    }
                }

            }

        }
        return s.substring(maxStart, maxEnd + 1);

    }

    public static void main(String args[]){
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("ccc"));
    }
}
