package �ַ���;

/**
 * ��дһ���������������ǽ�������ַ�����ת�����������ַ������ַ����� s ����ʽ������
 *
 * ��Ҫ�����������������Ŀռ䣬�����ԭ���޸��������顢ʹ�� O(1) �Ķ���ռ�����һ���⡣
 *
 * */

public class reverseString {

    class Solution {
        public void reverseString(char[] s) {
            int n = s.length;
            for (int left = 0, right = n - 1; left < right; ++left, --right) {
                char tmp = s[left];
                s[left] = s[right];
                s[right] = tmp;
            }
        }
    }
}
