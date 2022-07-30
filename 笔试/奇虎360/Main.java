package 笔试.奇虎360;

/**
 * 若数列a1…an，对于任意1<i<n的位置满足：a[i+1]>a[i]或a[i-1]>a[i] ，那么称这个数列为yeah数列。
 * （通俗的理解，yeah数列除两端外，对于任意一个位置，左右两边至少有一个比他大）。
 *
 * 比如4 1 8 或 1 2 3或 8 6 4 2就是yeah数列，而1 1 1和0 1 0就不是yeah数列
 *
 * 现在有一个数列b1…bn，每次操作你可以选择一个i，使得bi减1(操作过程中允许bi减为负数)
 * 问最少经过多少次操作，可以使得bi变为一个yeah数列
 * */


import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine().trim());
        long[] res = new long[num];

        for(int i = 0;i < num;i++){
            res[i] = sc.nextLong();
        }

        boolean flag = true;

        for(int i = 1;i < num-1;i++){
            if(res[i]<res[i+1] || res[i]<res[i-1]){
            }
            else {
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println(0);
        }

        else {
            long ans = 0L;
            long[] dp = new long[num];
            for(int i = num-1;i>=0;i--){
                if(i==num-1){
                    dp[i] = res[i];
                }
                else {
                    long x = dp[i+1] - 1;
                    long c = res[i];
                    if(x>=c){
                        dp[i] = c;
                    }
                    else {
                        dp[i] = x;
                        ans += c-x;
                    }
                }
            }

            for(int i = 0;i<num;i++){
                long cap = 0l;
                if(i==0){
                    cap = ans-(res[i]-dp[i]);
                    dp[i]=res[i];
                    ans = Math.min(ans,cap);
                }else {
                    if(res[i]>=dp[i-1]-1){
                        cap = ans-(dp[i-1]-1-dp[i]);
                        dp[i]=dp[i-1]-1;
                    }else {
                        cap = ans-(res[i]-dp[i]);
                        dp[i] = res[i];
                    }


                    ans = Math.min(ans,cap);
                }
            }

            System.out.println(ans);

        }


    }
}

