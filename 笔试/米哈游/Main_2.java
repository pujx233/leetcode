package ±ÊÊÔ.Ã×¹şÓÎ;

import java.util.*;

public class Main_2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        List<Integer> ans = new LinkedList<>();
        int[][] res = new int[2][2]; int cnt = 0;
        for(int i = 0;i<2;i++){
            String[] m = in.nextLine().split(" ");
            res[cnt][0] = Integer.parseInt(m[0]);
            res[cnt][1] = Integer.parseInt(m[1]);
            cnt++;
        }

        boolean judge[][] = new boolean[12][12];

        int[] dx = new int[]{-2, -3, -3, -2, 2, 3, 3, 2};
        int[] dy = new int[]{-3, -2, 2, 3, 3, 2, -2, -3};

        int[] k1x = new int[]{0, -1, -1, 0, 0, 1, 1, 0};
        int[] k1y = new int[]{-1, 0, 0, 1, 1, 0, 0, -1};
        int[] k2x = new int[]{-1, -2, -2, -1, 1, 2, 2, 1};
        int[] k2y = new int[]{-2, -1, 1, 2, 2, 1, -1, -2};

        Deque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{res[0][0],res[0][1]});
        int path = 0;
        boolean flag = true;

        while (!deque.isEmpty()){
            int len = deque.size();
            for(int i = 0;i<len;i++){
                int[] temp = deque.poll();
                assert temp != null;
                int x = temp[0],y = temp[1];
                if(x==res[1][0] && y==res[1][1]){
                    System.out.println(path);
                    flag = false;
                }
                for(int j = 0;j<8;j++){
                    int _a = x + dx[j], _b = y + dy[j];
                    int k1a = x + k1x[j], k1b = y + k1y[j];
                    int k2a = x + k2x[j], k2b = y + k2y[j];

                    if (_a < 0 || _a >= 10 || _b < 0 || _b >= 9 || judge[_a][_b] || (k1a == res[1][0] && k1b == res[1][1])
                            || (k2a == res[1][0] && k2b == res[1][1]))
                        continue;
                    deque.offer(new int[]{_a, _b});
                    judge[_a][_b] = true;

                }

            }
            path++;

            if(!flag){
                break;
            }
        }

        if(flag){
            System.out.println(-1);
        }
    }



}
