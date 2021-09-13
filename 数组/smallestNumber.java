package 数组;

import java.util.Arrays;

/**
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * */

public class smallestNumber {

    public static class Solution {
        public String minNumber(int[] nums) {

            String[] str = new String[nums.length];
            for(int i = 0;i<nums.length;i++){
                str[i] = String.valueOf(nums[i]);
            }

            Arrays.sort(str,(x,y)->(x+y).compareTo(y+x));
            StringBuffer res = new StringBuffer();
            for(String s : str){
                res.append(s);
            }

            return res.toString();
        }
    }

    public static class Solution_1 {
        public String minNumber(int[] nums) {

            String[] str = new String[nums.length];
            for(int i = 0;i<nums.length;i++){
                str[i] = String.valueOf(nums[i]);
            }

            quickSort(str,0,str.length-1);

            StringBuffer res = new StringBuffer();
            for(String s : str){
                res.append(s);
            }

            return res.toString();
        }

        public void quickSort(String[] str,int l,int r){
            if(l>r){
                return;
            }
            int i = l,j = r;
            String tmp = str[i];
            while(i<j){
                while((str[j]+str[l]).compareTo(str[l]+str[j])>=0 && i<j){
                    j--;
                }
                while ((str[i] + str[l]).compareTo(str[l] + str[i]) <= 0 && i < j){
                    i++;
                }
                tmp = str[i];
                str[i] = str[j];
                str[j] = tmp;

            }

            str[i] = str[l];
            str[l] = tmp;
            quickSort(str,l,i-1);
            quickSort(str,i+1,r);
        }
    }

    public static void main(String[] args){
        Solution_1 solution = new Solution_1();
        System.out.println(solution.minNumber(new int[]{3,30,34,5,9}));
    }

}
