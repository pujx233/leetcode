package ±  ‘.√¿Õ≈;

import java.util.*;

public class Main_2 {


    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt(),path = sc.nextInt(),change = sc.nextInt();
        String ans = "";
        int[] dp = new int[num];
        List<Integer> m = new ArrayList<>();
        Arrays.fill(dp,0);
        for(int i= 0;i<path;i++){
            int tmp_1 = sc.nextInt();
            dp[tmp_1-1] +=1;
            int tmp_2 = sc.nextInt();
            dp[tmp_2-1] +=1;
        }

        for(int i = 0; i<change;i++){
            int tmp_3 = sc.nextInt();
            int tmp_4 = sc.nextInt();
            int temp = dp[tmp_3-1];
            dp[tmp_3-1] = dp[tmp_4-1];
            dp[tmp_4-1] = temp;
        }

        for(int i = 0;i<num-1;i++){
            ans=ans+dp[i]+" ";
        }
        System.out.println(ans);
        ans=ans+ dp[num - 1];
        System.out.println(ans);
    }


}
