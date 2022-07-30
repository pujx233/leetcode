package �ַ���;

/**
 * �ַ���ѹ���������ַ��ظ����ֵĴ�������дһ�ַ�����ʵ�ֻ������ַ���ѹ�����ܡ�
 * ���磬�ַ���aabcccccaaa���Ϊa2b1c5a3������ѹ��������ַ���û�б�̣��򷵻�ԭ�ȵ��ַ�����
 * ����Լ����ַ�����ֻ������СдӢ����ĸ��a��z����
 * */

public class compressStringEasy {

    public static class Solution {
        public String compressString(String S) {
            if (S.length() == 0) { // �մ�����
                return S;
            }
            StringBuffer ans = new StringBuffer();
            int cnt = 1;
            char ch = S.charAt(0);
            for (int i = 1; i < S.length(); ++i) {
                if (ch == S.charAt(i)) {
                    cnt++;
                } else {
                    ans.append(ch);
                    ans.append(cnt);
                    ch = S.charAt(i);
                    cnt = 1;
                }
            }
            ans.append(ch);
            ans.append(cnt);
            return ans.length() >= S.length() ? S : ans.toString();
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.compressString("aabcccccaaa"));
    }
}
