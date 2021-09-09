package 数组;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class minPathOfMaze {
    public static void main(String[] args) {
        char[][] ditu = new char[10][10];
        for (int i = 0; i < 10; i++) {
            Arrays.fill(ditu[i], 'O');
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                ditu[0][i] = '#';
                ditu[9][i] = '#';
                ditu[i][0] = '#';
                ditu[i][9] = '#';
            }
        }
        ditu[1][3] = ditu[1][7] = ditu[2][3] = ditu[2][7] = '#';
        ditu[3][5] = '#';
        ditu[4][2] = ditu[4][3] = ditu[4][4] = '#';
        ditu[5][4] = ditu[6][2] = ditu[6][6] = '#';
        ditu[7][2] = ditu[7][3] = ditu[7][4] = ditu[7][6] = ditu[7][7] = '#';
        ditu[8][1] = ditu[8][2] = '#';
        System.out.println("迷宫地形图：");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(ditu[i][j] + " ");
            }
            System.out.println();
        }
        //以上是规划迷宫。



        //设置起始点与终点。
        int[] start = new int[]{1, 1};
        int[] end = new int[]{1, 8};

        int[][] d = bfs(ditu, start, end);
        System.out.println("该地图最短路径长为：" + d[end[0]][end[1]]);
        System.out.println("---上帝视角迷宫最短路径地形图：---");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                //有步数的情况下打印步数，没有步数的情况下打印对应的字符
                if (d[i][j] > 0 && d[i][j] < Integer.MAX_VALUE) {
                    System.out.printf("%-5d", d[i][j]);
                } else {
                    System.out.printf("%-5c", ditu[i][j]);
                }
            }
            System.out.println();
        }
    }

    public static int[][] bfs(char[][] map, int[] start, int[] end) {
        //移动的四个方向（下右上左）。
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        //用队列存储对应点的横坐标与纵坐标。
        Queue<int[]> que = new LinkedList<>();
        // 到起始点的距离，我们先全部初始化为最大值。
        int[][] min = new int[map.length][map[0].length];
        for (int i = 0; i < min.length; i++) {
            Arrays.fill(min[i], Integer.MAX_VALUE);
        }
        //起始点的距离设为0
        min[start[0]][start[1]] = 0;
        //将起始点入队
        que.offer(start);

        //队列为空的情况跳出循环，即该迷宫走不出去，无解。
        while (!que.isEmpty()) {
            //取出队列中最前端的点
            int[] temp = que.poll();
            //如果是终点则结束
            if (temp[0] == end[0] && temp[1] == end[1]) break;
            //四个方向循环
            for (int i = 0; i < 4; i++) {
                int y = temp[0] + dy[i];
                int x = temp[1] + dx[i];
                //判断是否可以走
                if (map[y][x] != '#' && min[y][x] == Integer.MAX_VALUE) {
                    //如果可以走，则将该点的距离加1
                    min[y][x] = min[temp[0]][temp[1]] + 1;
                    //将可以走的点入队
                    que.offer(new int[]{y, x});
                }
            }
        }
        return min;
        //返回所有点到到起始点的距离的二维数组。
    }

}

