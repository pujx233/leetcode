package 笔试.网易;

import java.util.Scanner;

/**
 * 注意前缀和求距离，以及字母间距是环
 * */

public class 前缀和 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int num = Integer.parseInt(input[1]);
        String str = input[0];

        char[] chars = str.toCharArray();

        int ans = 0,len = chars.length;

        for(int i = 1;i<chars.length;i++){
            ans+=Math.abs(chars[i]-chars[i-1]);
        }
        ans+=len;

        if(num==0){
            System.out.println(ans);
        }

        else if(len==1){
            System.out.println(1);
        }

        else {
            int[] prefix = new int[len];
            prefix[0] = 0;

            for(int i = 1;i < len;i++){
                int abs = Math.abs(chars[i] - chars[i - 1]);
                prefix[i] = prefix[i-1]+Math.min(abs,25- abs);
            }

            for(int i = 0;i < len-num;i++){
                ans = Math.min(ans,prefix[i] - prefix[0] + prefix[len-1] - prefix[num+i] +num+len);
            }

            System.out.println(ans);
        }
    }
}
