package �ַ���;

/**
 * ʵ�� strStr() ������
 *
 * ���������ַ��� haystack �� needle �������� haystack �ַ������ҳ� needle �ַ������ֵĵ�һ��λ�ã��±�� 0 ��ʼ������������ڣ��򷵻�  -1 ��
 *
 * */

public class implementStrStr {

    static class Solution {
        public int strStr(String haystack, String needle) {
            if(needle.isEmpty()){
                return 0;
            }

            int n = haystack.length(),m = needle.length();

            haystack = " "+haystack;
            needle = " " + needle;

            char[] s = haystack.toCharArray();
            char[] p = needle.toCharArray();

            int[] next = new int [m+1];

            for(int i = 2,j=0;i<=m;i++){
                while (j>0 && p[i]!=p[j+1]){
                    j = next[j];
                }
                if(p[i]==p[j+1]){
                    j++;
                }
                next[i] = j;
            }

            for(int i = 1,j = 0; i <= n;i++){
                while (j>0 && s[i]!=p[j+1]){
                    j = next[j];
                }
                if(s[i] == p[j+1]){
                    j++;
                }
                if (j == m) return i - m;
            }

            return -1;
        }
    }

    public static void main(String args[]){
        Solution solution = new Solution();
        System.out.println(solution.strStr("aaavbbaa", "ababacd"));
    }

}
