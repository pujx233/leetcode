package �ַ���;

/**
 * ������Сд��ĸ��ɵ��ַ��� S���ظ���ɾ��������ѡ��������������ͬ����ĸ����ɾ�����ǡ�
 *
 * �� S �Ϸ���ִ���ظ���ɾ��������ֱ���޷�����ɾ����
 *
 * ����������ظ���ɾ�������󷵻����յ��ַ������𰸱�֤Ψһ��
 *
 * */

public class removeAllAdjacentDuplicatesInString {

    /**
     * ջ
     * */

    class Solution {
        public String removeDuplicates(String s) {
            StringBuffer stack = new StringBuffer();
            int top = -1;
            for (int i = 0; i < s.length(); ++i) {
                char ch = s.charAt(i);
                if (top >= 0 && stack.charAt(top) == ch) {
                    stack.deleteCharAt(top);
                    --top;
                } else {
                    stack.append(ch);
                    ++top;
                }
            }
            return stack.toString();
        }
    }
}
