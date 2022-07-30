package 笔试.网易互娱;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Main_1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());

        int[] answer = new int[num];

        for(int i = 0;i<num;i++){
            int N = sc.nextInt(),M1 = sc.nextInt(),M2 = sc.nextInt();

            sc.nextLine();

            int[][] res =  new int[N][N];

            for(int j = 0;j<N;j++){
                Arrays.fill(res[i],-1);
            }

            for(int j = 0;j<M1;j++){
                String m = sc.nextLine();
                String[] n = m.split(" ");
                int a = Integer.parseInt(n[0]), b = Integer.parseInt(n[1]);

                res[a-1][b-1] = 1;
            }

            for(int j = 0;j<M2;j++){
                int a ,b ;

                a = Integer.parseInt(sc.next());

                b = sc.nextInt();
                res[a-1][b-1] = 0;
            }


            Deque<Integer> deque = new ArrayDeque<>();
            int ans = Integer.MAX_VALUE;
            boolean wait = false;
            deque.push(0);
            boolean[] visited = new boolean[N];
            visited[0] = true;
            int[] minLen = new int[N];

            while (!deque.isEmpty()){
                int temp = deque.poll();
                //如果是终点则结束
                if (temp == N-1){
                    ans = Math.min(ans,minLen[N-1]);
                    break;
                }

                for(int k = 0;k<N;k++){
                    if(res[temp][k]==1 && !visited[k] && wait){
                        minLen[k] += res[temp][k];
                        visited[k] = true;
                        deque.offer(k);
                        wait = false;
                    }

                    else if(res[temp][k]==1 && !visited[k] && !wait){
                        minLen[k] += res[temp][k];
                        visited[k] = true;
                        deque.offer(k);

                    }

                    else if(res[temp][k]==0 && !visited[k] && !wait){
                        wait = true;
                        minLen[k] += res[temp][k];
                        visited[k] = true;
                        deque.offer(k);
                    }
                    else if(res[temp][k]==0 && !visited[k] && wait){
                        minLen[k] += res[temp][k] + 1;
                        visited[k] = true;
                        deque.offer(k);
                    }
                }

            }

            answer[i] = ans;
        }

        for(int i = 0;i<num;i++){
            System.out.println(answer[i]);
        }

    }
}
