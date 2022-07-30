package 笔试.五八同城;

import java.util.*;

public class Main_1 {

    public static class Solution {
        public int[] subArraySum(int[] array, int arrayLen, int subArrayLen) {
            int[] num = new int[arrayLen];
            num[0] = array[0];
            //前缀和
            for (int i = 1; i < array.length; i++) {
                num[i] = num[i - 1] + array[i];
            }

            int res = num[subArrayLen-1];
            int index = 0;
            for (int i = 0; i < arrayLen - subArrayLen; ++i) {
                if (res< num[i + subArrayLen] - num[i]){
                    index = i+1;
                    res = num[i + subArrayLen] - num[i];
                }
            }
            int[] ans = {index,res};
            return ans;

        }

    }

    public static  void main(String []args){
        Solution solution = new Solution();
        solution.subArraySum(new int[]{1,1,4,6,7,7,3},7,3);
    }
}
