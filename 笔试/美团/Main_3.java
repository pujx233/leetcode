package 笔试.美团;

import java.util.*;

public class Main_3{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int ans = 0;
        int num = sc.nextInt(); int k = sc.nextInt();
        boolean[] judge = new boolean[num];
        Arrays.fill(judge,true);
        List<List<Integer>> song = new ArrayList<List<Integer>>();

        for(int i = 0;i<num;i++){
            List<Integer> temp = new ArrayList<>();

            for(int j = 0;j<4;j++) {
                int a = sc.nextInt();
                temp.add(a);
            }
            song.add(temp);
        }

        judge[0] = song.get(0).get(3)==1;

        for(int i = 1;i<num;i++){

            if(song.get(i).get(3)==1){
                judge[i] = true;
                continue;
            }
            for(int j = i-1;j>=0;j--){
                if(song.get(j+1).get(2)==song.get(j).get(2) && song.get(j+1).get(3) - song.get(j).get(3)==1){
                }
                else if(song.get(j+1).get(2)!=song.get(j).get(2) || song.get(j+1).get(3) - song.get(j).get(3)!=1){
                    judge[i] = false;
                }
            }

        }

        /*System.out.println(Arrays.toString(judge));*/

        for(int i=0;i<num;i++){
            if(judge[i]){
                ans+= song.get(i).get(0);
            }
            else {
                ans+= Math.max(song.get(i).get(0)-song.get(i).get(1),-k);
            }
        }

        System.out.println(ans);
    }
}
