package 笔试.TPLINK;

import java.util.*;

public class Main_2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String m = sc.nextLine();
        List<Integer> res = new ArrayList<Integer>();
        int len = m.length();
        int temp = 0; boolean flag = true; boolean judge = true;

        m = m.replace(","," ");
        m = m.strip();

        for(int i = 0;i<len;i++){
            if(m.charAt(i)==' '){
                if(!flag) {
                    res.add(temp);
                    temp = 0;
                    flag = true;
                    judge = true;
                }
            }
            else{
                if(m.charAt(i)=='-'){
                    judge = false;
                }else if(m.charAt(i) == '+'){
                    judge = true;
                }
                else {
                    if(judge){
                        temp = temp * 10 + m.charAt(i) - '0';
                    }else {
                        temp = temp * 10 - m.charAt(i) + '0';
                    }

                    flag = false;
                }
            }

        }

        res.add(temp);

        int[] nums = new int[res.size()];
        for(int i = 0;i<res.size();i++){
            nums[i] = res.get(i);
        }

        System.out.println(findMax(nums));


    }

    public static int findMax(int[] ans){
        int result = 1;
        int max = 1, min = 1;
        for(int i = 0;i < ans.length;i++) {
            int temp = max;
            max = Math.max(max * ans[i], Math.max(min * ans[i], ans[i]));
            min = Math.min(temp * ans[i], Math.min(min * ans[i], ans[i]));

            if(max > result)
                result = max;
        }

        return result;
    }
}