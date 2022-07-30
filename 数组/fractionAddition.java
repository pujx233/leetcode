package ����;

/**
 * ����һ����ʾ�����Ӽ�������ַ��� expression ������Ҫ����һ���ַ�����ʽ�ļ�������
 *
 * ������Ӧ���ǲ���Լ�ֵķ��������������� ������ս����һ������������ 2������Ҫ����ת���ɷ�����ʽ�����ĸΪ 1������������������, 2 Ӧ�ñ�ת��Ϊ 2/1��
 * */


public class fractionAddition {

    class Solution {
        public String fractionAddition(String expression) {
            long denominator = 0, numerator = 1; // ���ӣ���ĸ
            int index = 0, n = expression.length();
            while (index < n) {
                // ��ȡ����
                long denominator1 = 0, sign = 1;
                if (expression.charAt(index) == '-' || expression.charAt(index) == '+') {
                    sign = expression.charAt(index) == '-' ? -1 : 1;
                    index++;
                }
                while (index < n && Character.isDigit(expression.charAt(index))) {
                    denominator1 = denominator1 * 10 + expression.charAt(index) - '0';
                    index++;
                }
                denominator1 = sign * denominator1;
                index++;

                // ��ȡ��ĸ
                long numerator1 = 0;
                while (index < n && Character.isDigit(expression.charAt(index))) {
                    numerator1 = numerator1 * 10 + expression.charAt(index) - '0';
                    index++;
                }

                denominator = denominator * numerator1 + denominator1 * numerator;
                numerator *= numerator1;
            }
            if (denominator == 0) {
                return "0/1";
            }
            long g = gcd(Math.abs(denominator), numerator); // ��ȡ���Լ��
            return Long.toString(denominator / g) + "/" + Long.toString(numerator / g);
        }

        public long gcd(long a, long b) {
            long remainder = a % b;
            while (remainder != 0) {
                a = b;
                b = remainder;
                remainder = a % b;
            }
            return b;
        }
    }
}
