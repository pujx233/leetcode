package ����;

import java.util.*;

/**
 * ��������arr������num,�������ж��ٸ������������������:
 * max(arr[i.. j]) - min(arr[i.. j]) <= num
 * max (arr[i.. j])��ʾ������arr[i.. j]�е����ֵ��min(arr[i.. j])��ʾ������arr[i.. j]�е���Сֵ��
 * */

public class AllLessNumSubArray {

    public static int getNum(int[] arr, int num){

        if(arr == null || arr.length == 0)
            return 0;
        int len = arr.length;
        Deque<Integer> qMin = new ArrayDeque<Integer>();
        Deque<Integer> qMax = new ArrayDeque<Integer>();

        int i = 0;
        int j = 0;
        int res = 0;
        while (i < arr.length){
            while (j < arr.length){
                // ��֤qMin�Ķ���Ϊ������arr[i...j]����Сֵ��qMin��Ӧ������Ԫ�ص���
                while (!qMin.isEmpty() && arr[qMin.peek()] >= arr[j])
                    qMin.poll();
                qMin.offer(j);
                // ��֤qMax�Ķ���Ϊ������arr[i...j]�����ֵ��qMax��Ӧ������Ԫ�صݼ�
                while (!qMax.isEmpty() && arr[qMax.peek()] <= arr[j])
                    qMax.poll();
                qMax.offer(j);
                // ����������arr[i...j], arr[qMax.getFirst()]�����ֵ��arr[qMin.getFirst()]����Сֵ
                if(arr[qMax.getFirst()] - arr[qMin.getFirst()] > num)
                    break;
                j++;
            }
            // ������ѭ������������arr[i...j]�Ѿ���������������qMin��qMax���������i����Ӧ�ó���
            if(qMin.getFirst() == i)
                qMin.pollFirst();
            if(qMax.getFirst() == i)
                qMax.pollFirst();
            res += j - i;
            i++;
        }

        return res;
    }

    public static void main(String[] args){
        int[] nums = new int[]{10,1,2,4,7,2};
        System.out.println(getNum(nums,3));
    }

}
