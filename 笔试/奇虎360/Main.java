package ����.�滢360;

/**
 * ������a1��an����������1<i<n��λ�����㣺a[i+1]>a[i]��a[i-1]>a[i] ����ô���������Ϊyeah���С�
 * ��ͨ�׵���⣬yeah���г������⣬��������һ��λ�ã���������������һ�������󣩡�
 *
 * ����4 1 8 �� 1 2 3�� 8 6 4 2����yeah���У���1 1 1��0 1 0�Ͳ���yeah����
 *
 * ������һ������b1��bn��ÿ�β��������ѡ��һ��i��ʹ��bi��1(��������������bi��Ϊ����)
 * �����پ������ٴβ���������ʹ��bi��Ϊһ��yeah����
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

