package �ַ���;

/**
 * ����һ���ǿյ��ַ������ж����Ƿ����������һ���Ӵ��ظ���ι��ɡ��������ַ���ֻ����СдӢ����ĸ�����ҳ��Ȳ�����10000
 * */


public class repeatedSubstringPattern {
    static class Solution {
        public boolean repeatedSubstringPattern(String s) {
            if(s.equals("")){
                return false;
            }

            int len = s.length();

            s = " "+s;
            char[] chars = s.toCharArray();
            int[] next = new int[len+1];

            for(int i = 2,j = 0;i<=len;i++){
                while(j>0 && chars[i] != chars[j+1]){
                    j = next[j];
                }
                if(chars[i]==chars[j+1]){
                    j++;
                }
                next[i] = j;
            }


            if(next[len]>0 && len%(len-next[len])==0){
                return true;
            }
            return false;
        }
    }

    public static void main(String []args){
        Solution solution = new Solution();
        System.out.println(solution.repeatedSubstringPattern("abababaa"));
    }

    /**
     * ���ǵ��ַ���������
     * */

    static class Solution_1 {
        public boolean repeatedSubstringPattern(String s) {
            return (s+s).indexOf(s,1) != s.length();
        }
    }


    /**
     * �����㷨
     * */

    class Solution_2 {
        public boolean repeatedSubstringPattern(String s) {
            int n = s.length();
            for (int i = 1; i * 2 <= n; ++i) {
                if (n % i == 0) {
                    boolean match = true;
                    for (int j = i; j < n; ++j) {
                        if (s.charAt(j) != s.charAt(j - i)) {
                            match = false;
                            break;
                        }
                    }
                    if (match) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
