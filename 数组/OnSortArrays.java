package 数组;

import java.util.Arrays;

/**
 * 有1,2,…,n的无序数组，求排序算法，并且要求时间复杂度为O(n)，空间复杂度O(1)，一次只能交换两个数
 * */

public class OnSortArrays {

    public static void main(String []args){
        int res[] = {10, 6, 9, 5, 2, 8, 4, 7, 1, 3};
        int temp;
        for(int i = 0;i<res.length;){
            temp = res[res[i]-1];
            res[res[i]-1] = res[i];
            res [i] = temp;
            if(res[i]==i+1){
                i++;
            }
        }

        System.out.println(Arrays.toString(res));
    }
}
