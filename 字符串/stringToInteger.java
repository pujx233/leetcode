package �ַ���;

import java.util.HashMap;
import java.util.Map;

/**
 * ������ʵ��һ�� myAtoi(string s) ������ʹ���ܽ��ַ���ת����һ�� 32 λ�з�������
 * ������ C/C++ �е� atoi ��������
 *
 * ���� myAtoi(string s) ���㷨���£�
 *
 * �����ַ������������õ�ǰ���ո�
 * �����һ���ַ������軹δ���ַ�ĩβ��Ϊ�����Ǹ��ţ���ȡ���ַ�������У��� ȷ�����ս���Ǹ������������� ������߶������ڣ���ٶ����Ϊ����
 * ������һ���ַ���ֱ��������һ���������ַ��򵽴�����Ľ�β���ַ��������ಿ�ֽ������ԡ�
 * ��ǰ�沽��������Щ����ת��Ϊ����������"123" -> 123�� "0032" -> 32�������û�ж������֣�������Ϊ 0 ����Ҫʱ���ķ��ţ��Ӳ��� 2 ��ʼ����
 * ������������� 32 λ�з���������Χ [?231,  231 ? 1] ����Ҫ�ض����������ʹ�䱣���������Χ�ڡ�������˵��С�� ?231 ������Ӧ�ñ��̶�Ϊ ?231 ������ 231 ? 1 ������Ӧ�ñ��̶�Ϊ 231 ? 1 ��
 * ����������Ϊ���ս����
 * ע�⣺
 *
 * �����еĿհ��ַ�ֻ�����ո��ַ� ' ' ��
 * ��ǰ���ո�����ֺ�������ַ����⣬������� �κ������ַ���
 * */

public class stringToInteger {
    static class Solution {
        public int myAtoi(String s) {
            int len  = s.length();
            char []charArray = s.toCharArray();

            int index = 0;

            while(index<len && charArray[index] == ' '){
                index++;
            }

            if(index == len){
                return 0;
            }

            int sign = 1;
            char firstChar = charArray[index];
            if(firstChar=='+'){
                index++;
            }
            else if(firstChar == '-'){
                index++;
                sign = -1;
            }

            int res = 0;

            while(index < len){
                char currChar = charArray[index];

                if(currChar<'0' || currChar>'9'){
                    break;
                }

                // ��Ŀ��˵������ֻ�ܴ洢 32 λ��С���з�����������ˣ���Ҫ��ǰ�У��ϳ��� 10 �Ժ��Ƿ�Խ��
                if(res>Integer.MAX_VALUE/10||(res==Integer.MAX_VALUE/10 && (currChar-'0') > Integer.MAX_VALUE%10)){
                    return Integer.MAX_VALUE;
                }
                if(res<Integer.MIN_VALUE/10||(res == Integer.MIN_VALUE/10 && (currChar-'0') > -(Integer.MIN_VALUE%10))){
                    return Integer.MIN_VALUE;
                }

                res = res*10 + sign*(currChar-'0');
                index++;
            }
            return res;
        }
    }


    /**
     * �Զ���
     * */

    class Solution_1 {

        class Automaton {
            final String START = "start";
            final String SIGNED = "signed";
            final String IN_NUM = "in_number";
            final String END = "end";
            String state = START;
            Map<String, String[]> map;
            public int sign = 1;
            public long ans = 0;

            public Automaton() {
                map = new HashMap<>();
                map.put(START, new String[]{START, SIGNED, IN_NUM, END});
                map.put(SIGNED, new String[]{END, END, IN_NUM, END});
                map.put(IN_NUM, new String[]{END, END, IN_NUM, END});
                map.put(END, new String[]{END, END, END, END});
            }

            public int get_col(char c) {
                if (c == ' ') return 0;
                if (c == '+' || c == '-') return 1;
                if (c >= '0' && c <= '9') return 2;
                return 3;
            }

            public void get(char c) {
                state = map.get(state)[get_col(c)];
                if (state.equals(IN_NUM)) {
                    ans = ans * 10 + c - '0';
                    if (sign == 1) {
                        ans = Math.min(ans, Integer.MAX_VALUE);
                    } else {
                        // -(long)Integer.MIN_VALUE����������е㶫������ȻԽ��
                        ans = Math.min(ans, -(long)Integer.MIN_VALUE);
                    }
                } else if (state.equals(SIGNED))
                    sign = c == '+' ? 1 : -1;
            }
        }

        public int myAtoi(String str) {
            Automaton automaton = new Automaton();
            char[] c = str.toCharArray();
            for (char ch : c) {
                automaton.get(ch);
            }
            return automaton.sign * ((int) automaton.ans);
        }
    }

    public static void main(String args[]){
        Solution solution = new Solution();
        System.out.println(solution.myAtoi("words and -91283472332"));
    }
}
