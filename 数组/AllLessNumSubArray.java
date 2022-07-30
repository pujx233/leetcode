package 数组;

import java.util.*;

/**
 * 给定数组arr和整数num,共返回有多少个子数组满足如下情况:
 * max(arr[i.. j]) - min(arr[i.. j]) <= num
 * max (arr[i.. j])表示子数组arr[i.. j]中的最大值，min(arr[i.. j])表示子数组arr[i.. j]中的最小值。
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
                // 保证qMin的队首为子数组arr[i...j]的最小值，qMin对应的数组元素递增
                while (!qMin.isEmpty() && arr[qMin.peek()] >= arr[j])
                    qMin.poll();
                qMin.offer(j);
                // 保证qMax的队首为子数组arr[i...j]的最大值，qMax对应的数组元素递减
                while (!qMax.isEmpty() && arr[qMax.peek()] <= arr[j])
                    qMax.poll();
                qMax.offer(j);
                // 对于子数组arr[i...j], arr[qMax.getFirst()]是最大值，arr[qMin.getFirst()]是最小值
                if(arr[qMax.getFirst()] - arr[qMin.getFirst()] > num)
                    break;
                j++;
            }
            // 跳出内循环代表子数组arr[i...j]已经不符合条件，则qMin和qMax队首如果是i，则应该出队
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
