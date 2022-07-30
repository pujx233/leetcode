package ����;

import java.util.*;

/**
 * n ������վ��һ�š�����һ���������� ratings ��ʾÿ�����ӵ����֡�
 *
 * ����Ҫ��������Ҫ�󣬸���Щ���ӷַ��ǹ���
 *
 * ÿ���������ٷ��䵽 1 ���ǹ���
 * ���������������ָ��ߵĺ��ӻ��ø�����ǹ���
 * �����ÿ�����ӷַ��ǹ������㲢������Ҫ׼���� �����ǹ���Ŀ
 * */

public class candy {

    /**
     * ���α���
     * */
    class Solution {
        public int candy(int[] ratings) {
            int n = ratings.length;
            int[] left = new int[n];
            for (int i = 0; i < n; i++) {
                if (i > 0 && ratings[i] > ratings[i - 1]) {
                    left[i] = left[i - 1] + 1;
                } else {
                    left[i] = 1;
                }
            }
            int right = 0, ret = 0;
            for (int i = n - 1; i >= 0; i--) {
                if (i < n - 1 && ratings[i] > ratings[i + 1]) {
                    right++;
                } else {
                    right = 1;
                }
                ret += Math.max(left[i], right);
            }
            return ret;
        }
    }
}
