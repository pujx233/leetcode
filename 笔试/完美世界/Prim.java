package 笔试.完美世界;

import java.util.Arrays;

public class Prim{
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 每个测试用例的第1行给出村庄数目N。第一行之后的 N(N - 1) / 2 行数对应村庄间道路的成本及修建状态，每行给4个正整数，分别是两个村庄的编号（从1编号到N），此两村庄间道路的成本，以及修建状态：1表示已建，0表示未建。
     * @param N int整型 村庄数目
     * @param roads int整型二维数组 道路位置、成本、是否修建
     * @return int整型
     */

    int ans;

    public int minCost (int N, int[][] roads) {
        int ans = 0;

        int[][] dis = new int[N][N];
        int[] yard = new int[N];
        for(int i = 0;i<N;i++){
            Arrays.fill(dis[i],Integer.MAX_VALUE);
        }

        for (int[] road : roads) {
            int yard_1 = road[0];
            int yard_2 = road[1];
            if (road[3] == 0) {
                dis[yard_1 - 1][yard_2 - 1] = road[2];
                dis[yard_2 - 1][yard_1 - 1] = road[2];
            } else {
                dis[yard_1 - 1][yard_2 - 1] = 0;
                dis[yard_2 - 1][yard_1 - 1] = 0;
            }
        }

        for(int i = 0;i<N;i++){
            yard[i] = i;
        }

        ans = prim(dis,yard,0);

        return ans;
    }

    public int prim(int[][] roads,int[] road,int start){

        int[] visited = new int[road.length];
        visited[start] = 1;
        int min = Integer.MAX_VALUE;
        int temp = 0;
        int ans = 0;
        for(int i=0;i<road.length-1;i++){
            for(int j=0;j<roads.length;j++){
                for(int k=0;k<roads[j].length;k++){
                    if(visited[j]==1&&visited[k]==0&&min>roads[j][k]){
                        min = roads[j][k];
                        temp = k;
                    }
                }
            }
            visited[temp] = 1;
            ans += min;

            min = Integer.MAX_VALUE;
        }

        return ans;
    }
}
