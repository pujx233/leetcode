package �ַ���;

/**
 * ������ǰ׺������ԭ�ַ����м��� �ǿ� ǰ׺Ҳ�Ǻ�׺��������ԭ�ַ����������ַ�����
 *
 * ����һ���ַ��� s�����㷵������ �����ǰ׺��
 *
 * ������������������ǰ׺���򷵻�һ�����ַ�����
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
