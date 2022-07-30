package 笔试.星环;

import java.util.*;

public class Main_1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int[] res = new int[num];

        for(int i = 0;i<num;i++){
            res[i] = sc.nextInt();
        }

        int max = res[0],min = 0,ans = res[0];

        // ans_1 代表指针指向处为+,ans_2代表指针指向处为-
        int[] ans_1 = new int[num];
        int[] ans_2 = new int[num];

        ans_1[0] = res[0];
        ans_2[0] = 0;


        for(int i = 1;i<num;i++){
            ans_1[i] = Math.max(min + res[i],res[i]);
            ans_2[i] = Math.max(max- res[i],0);

            if(ans_1[i]>max){
                max = ans_1[i];
            }
            if(ans_2[i]>min){
                min = ans_2[i];
            }
            ans = Math.max(max,min);
        }

        System.out.println(ans);


    }


}
