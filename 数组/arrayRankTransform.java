package ����;

import java.util.*;

/**
 * ����һ���������� arr �����㽫�����е�ÿ��Ԫ���滻Ϊ������������š�
 *
 * ��Ŵ�����һ��Ԫ���ж����ű�ŵĹ������£�
 *
 * ��Ŵ� 1 ��ʼ��š�
 * һ��Ԫ��Խ����ô���Խ���������Ԫ����ȣ���ô���ǵ������ͬ��
 * ÿ�����ֵ���Ŷ�Ӧ�þ����ܵ�С��
 * */

public class arrayRankTransform {

    class Solution {
        public int[] arrayRankTransform(int[] arr) {
            int[] sortedArr = new int[arr.length];
            System.arraycopy(arr, 0, sortedArr, 0, arr.length);
            Arrays.sort(sortedArr);
            Map<Integer, Integer> ranks = new HashMap<Integer, Integer>();
            int[] ans = new int[arr.length];
            for (int a : sortedArr) {
                if (!ranks.containsKey(a)) {
                    ranks.put(a, ranks.size() + 1);
                }
            }
            for (int i = 0; i < arr.length; i++) {
                ans[i] = ranks.get(arr[i]);
            }
            return ans;
        }
    }
}
