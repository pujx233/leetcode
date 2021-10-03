package 笔试.星环;

import java.util.*;

public class Main_2{



    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String ans; boolean judge = false;
        int num = Integer.parseInt(sc.nextLine());
        int[][] res = new int[num][2];

        for(int i = 0;i<num;i++){
            String[] temp = sc.nextLine().split(" ");
            res[i][0] = Integer.parseInt(temp[0]);
            res[i][1] = Integer.parseInt(temp[1]);

        }

        for(int i = 0;i < num;i++){
            int flag = res[i][1];
            int jojo = i;
            while(true) {
                for (int j = 0; j <= i; j++) {
                    if (res[j][1] == flag && j!=jojo) {
                        res[j][1]++;
                        flag++;
                        jojo = j;
                        judge =true;

                    }
                }
                if(judge){
                    judge = false;
                }
                else {
                    break;
                }

            }
        }

        StringBuffer buf = new StringBuffer();

        Arrays.sort(res, (v1,v2)->v1[1]-v2[1]);

        for(int i = 0;i<num;i++){

            buf.append(res[i][0]).append(" ");
        }

        int len = buf.length();

        ans = buf.toString().substring(0,len-1);

        System.out.println(ans);

    }

    public static boolean judge(int[][] res, int flag, int i,int jojo){
        for (int j = 0; j <= i; j++) {
            if (res[j][1] == flag && j!=jojo) {
                res[j][1]++;

                return true;
            }
        }

        return false;
    }


}

