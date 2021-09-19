package 笔试.网易;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 知晓计算字符串中特定字符的方法
 * */

public class getNum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String res = sc.nextLine();
        int[] cnt = new int[10];
        int ans = 0;
        for(int i = 1;i<=9;i++){
            String a = res.replace(String.valueOf(i),"");
            cnt[i] = res.length()-a.length();
        }

        int num = Integer.parseInt(res);

        for(int i = 1;i<=9;i++){
            int temp = num%i;
            if(temp==0){
                ans += cnt[i];
            }
        }

        System.out.println(ans);
    }
}
