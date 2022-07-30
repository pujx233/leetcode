package �ַ���;

/**
 * ����һ�� 32 λ���з������� x �����ؽ� x �е����ֲ��ַ�ת��Ľ����
 *
 * �����ת���������� 32 λ���з��������ķ�Χ [?231,  231 ? 1] ���ͷ��� 0��
 *
 * ���軷��������洢 64 λ�������з��Ż��޷��ţ���
 * */

public class reverseInteger {

    class Solution {
        public int reverse(int x) {
            int rev = 0;
            while (x != 0) {
                if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                    return 0;
                }
                int digit = x % 10;
                x /= 10;
                rev = rev * 10 + digit;
            }
            return rev;
        }
    }
}
