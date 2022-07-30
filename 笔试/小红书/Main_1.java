package ±  ‘.–°∫Ï È;

import java.util.*;

public class Main_1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int flag = 0;

        String[] inf = sc.nextLine().trim().split(" ");

        int row = Integer.parseInt(inf[0]),col = Integer.parseInt(inf[1]);

        int[][] dis = new int[row][col];
        int[] pos = new int[]{0,0};
        for(int i = 0;i<row;i++){
            String m = sc.nextLine().trim();

            int len = m.length();
            for(int j = 0;j<len;j++){
                if(m.charAt(j)=='B'){
                    dis[i][j] = 0;
                }
                else if(m.charAt(j) == 'R'){
                    pos[0] = i;
                    pos[1] = j;

                }
                else if(m.charAt(j) == 'O'){
                    dis[i][j] = -1;
                }
            }
        }

        int r = pos[0],c = pos[1];

        int num = Integer.parseInt(sc.nextLine());

        for(int i = 0;i<num;i++){
            String[] res = sc.nextLine().trim().split(" ");
            if(res[0].equals("Turn")){
                if(res[1].equals("left")){
                    flag = (flag+3)%4;
                }
                else if(res[1].equals("right")){
                    flag = (flag+1)%4;
                }
            }

            else if(res[0].equals("Forward")){
                int distance = Integer.parseInt(res[1]);
                for(int j = 0;j<distance;j++){
                    if(flag==0){
                        if(pos[0]-1>=0 && dis[pos[0]-1][j]!=-1){
                            pos[0] = pos[0]-1;
                        }
                        else {
                            break;
                        }
                    }
                    else if(flag==1){
                        if(pos[1]+1<col && dis[pos[0]][pos[1]+1]!=-1){
                            pos[1] = pos[1]+1;
                        }
                        else {
                            break;
                        }
                    }
                    else if(flag==2){
                        if(pos[0]+1<row && dis[pos[0]+1][j]!=-1){
                            pos[0] = pos[0]+1;
                        }
                        else {
                            break;
                        }
                    }
                    else if(flag==3){
                        if(pos[1]-1>=0 && dis[pos[0]][pos[1]-1]!=-1){
                            pos[1] = pos[1]-1;
                        }
                        else {
                            break;
                        }
                    }
                }
            }

        }


        String ans = (pos[0]-r) + " " + (pos[1] -c);
        System.out.println(ans);
    }


}
