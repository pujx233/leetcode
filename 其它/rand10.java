package ����;

/**
 * ���з��� rand7 ������ 1 �� 7 ��Χ�ڵľ��������������дһ������ rand10 ���� 1 �� 10 ��Χ�ڵľ������������
 *
 * ��Ҫʹ��ϵͳ�� Math.random() ������
 * */


public class rand10 {

    /**
     * 1.����n���໥�����Ĳ���
     * 2.��ȡ��ĿҪ������䣬������ӳ��
     * (randX() - 1)*Y + randY() ���Եȸ��ʵ�����[1, X * Y]��Χ�������
     * */

    class Solution {
        public int rand10() {
            // �׵õ�һ������
            int num = (rand7() - 1) * 7 + rand7();
            // ֻҪ��������10���Ǿ͸��Ҳ������ɣ���Ϊ��ֻҪ��Χ��1-10�ģ����ֱ�ӷ��ؾͿ�����
            while (num > 10){
                num = (rand7() - 1) * 7 + rand7();
            }
            return num;
        }

        public int rand7(){
            return 0;
        }
    }

    /**
     * ��ȥ̫���ˣ�ѡ���Ż�
     * */
    class Solution_2{
        public int rand10() {
            // ���ȵõ�һ����
            int num = (rand7() - 1) * 7 + rand7();
            // ֻҪ��������40������͸��Ҳ������ɰ�
            while (num > 40)
                num = (rand7() - 1) * 7 + rand7();
            // ���ؽ����+1��Ϊ�˽�� 40%10Ϊ0�����
            return 1 + num % 10;
        }

        public int rand7(){
            return 0;
        }
    }

    /**
     * ĳ�������ϵ�ͨ��
     * �����������Ͽ��Թ����κη�Χ������������������� rand11()��
     *
     * ���� 2 ��������ֱ��� 2 �� 6 �ֽ��������������� 12 �ָ�����ͬ�Ľ����
     * ���� 12 �ֽ��ӳ�䵽 [1,12] ��Ȼ���پܾ� 12 ���ɡ�
     * rand100() ��
     *
     * ���� 3 ��������ֱ��� 4,5,5�ֽ��������������� 100�ָ�����ͬ�Ľ����
     * ���� 12 �ֽ��ӳ�䵽[1,100] ���ɡ�
     * */
    class Solution_3{
        public int rand10() {
            int first, second;
            while ((first = rand7()) > 6);
            while ((second = rand7()) > 5);
            return (first&1) == 1 ? second : 5+second;
        }

        public int rand7(){
            return 0;
        }
    }
}
