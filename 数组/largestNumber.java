package 数组;

import java.util.Arrays;

/**
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 *
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数
 * */

public class largestNumber {

    public static class Solution {
        public String largestNumber(int[] nums) {
            String[] str = new String[nums.length];
            for(int i = 0;i<nums.length;i++){
                str[i] = String.valueOf(nums[i]);
            }

            Arrays.sort(str,(x, y)->(y+x).compareTo(x+y));
            if(str[0].equals("0")){
                return "0";
            }
            StringBuffer res = new StringBuffer();
            for(String s : str){
                res.append(s);
            }

            return res.toString();
        }
    }

    public static void main(String[] args){
        Solution solution  = new Solution();
        solution.largestNumber(new int[]{3,30,34,5,9});
    }
}
