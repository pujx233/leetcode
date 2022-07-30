package ����.��������;

import java.util.Arrays;

public class Prim{
    /**
     * �����е����������������������Ѿ�ָ���������޸ģ�ֱ�ӷ��ط����涨��ֵ����
     *
     * ÿ�����������ĵ�1�и�����ׯ��ĿN����һ��֮��� N(N - 1) / 2 ������Ӧ��ׯ���·�ĳɱ����޽�״̬��ÿ�и�4�����������ֱ���������ׯ�ı�ţ���1��ŵ�N����������ׯ���·�ĳɱ����Լ��޽�״̬��1��ʾ�ѽ���0��ʾδ����
     * @param N int���� ��ׯ��Ŀ
     * @param roads int���Ͷ�ά���� ��·λ�á��ɱ����Ƿ��޽�
     * @return int����
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
