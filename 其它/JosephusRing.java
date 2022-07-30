package ����;

import java.util.*;

/**
 * 0,1,������,n-1��n�������ų�һ��ԲȦ��������0��ʼ��ÿ�δ����ԲȦ��ɾ����m�����֣�ɾ�������һ�����ֿ�ʼ��������
 * ������ԲȦ��ʣ�µ����һ�����֡�
 *
 * ���磬0��1��2��3��4��5���������һ��ԲȦ��������0��ʼÿ��ɾ����3�����֣�
 * ��ɾ����ǰ4������������2��0��4��1��������ʣ�µ�������3��
 * */

public class JosephusRing {


    /**
     * ����
     * */

    public static class Solution {
        public int lastRemaining(int n, int m) {
            ArrayList<Integer> list = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                list.add(i);
            }
            int idx = 0;
            while (n > 1) {
                idx = (idx + m - 1) % n;
                list.remove(idx);
                n--;
            }
            return list.get(0);
        }
    }

    /**
     * ����
     * */

    public class Solution_1 {
        public int lastRemaining(int n, int m) {
            int ans = 0;
            // ���һ��ʣ��2���ˣ����Դ�2��ʼ����
            for (int i = 2; i <= n; i++) {
                ans = (ans + m) % i;
            }
            return ans;
        }
    }

    /**
     * �ݹ�
     * */

    public class Solution_2 {
        public int lastRemaining(int n, int m) {
            return f(n, m);
        }

        public int f(int n, int m) {
            if (n == 1) {
                return 0;
            }
            int x = f(n - 1, m);
            return (m + x) % n;
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.lastRemaining(10,17));

    }

}
