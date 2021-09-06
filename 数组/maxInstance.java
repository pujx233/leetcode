package 数组;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 你现在手里有一份大小为N x N 的 网格 grid，上面的每个 单元格 都用0和1标记好了
 * 其中0代表海洋，1代表陆地，请你找出一个海洋单元格，这个海洋单元格到离它最近的陆地单元格的距离是最大的
 *
 * 我们这里说的距离是「曼哈顿距离」（Manhattan Distance）
 * (x0, y0) 和(x1, y1)这两个单元格之间的距离是|x0 - x1| + |y0 - y1|。
 *
 * 如果网格上只有陆地或者海洋，请返回-1。
 *
 * */

public class maxInstance {

    /**
     * 多源BFS
     * 先把所有的陆地都入队，然后从各个陆地同时开始一层一层的向海洋扩散，那么最后扩散到的海洋就是最远的海洋
     * */

    class Solution {
        public int maxDistance(int[][] grid) {
            int[] dx = {0, 0, 1, -1};
            int[] dy = {1, -1, 0, 0};

            Queue<int[]> queue = new ArrayDeque<>();
            int m = grid.length;int n = grid[0].length;

            // 先把所有的陆地都入队。
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        queue.offer(new int[] {i, j});
                    }
                }
            }

            boolean hasOcean = false;
            int[] point = null;
            while (!queue.isEmpty()) {
                point = queue.poll();
                int x = point[0], y = point[1];
                // 取出队列的元素，将其四周的海洋入队。
                for (int i = 0; i < 4; i++) {
                    int newX = x + dx[i];
                    int newY = y + dy[i];
                    if (newX < 0 || newX >= m || newY < 0 || newY >= n || grid[newX][newY] != 0) {
                        continue;
                    }
                    grid[newX][newY] = grid[x][y] + 1; // 这里我直接修改了原数组，因此就不需要额外的数组来标志是否访问
                    hasOcean = true;
                    queue.offer(new int[] {newX, newY});
                }
            }

            // 没有陆地或者没有海洋，返回-1。
            if (point == null || !hasOcean) {
                return -1;
            }

            // 返回最后一次遍历到的海洋的距离。
            return grid[point[0]][point[1]] - 1;

        }
    }


    /**
     * 两段动态规划
     * */

    class Solution_2 {
        public int maxDistance(int[][] grid) {
            final int INF = 1000000;
            int n = grid.length;
            int[][] f = new int[n][n];
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    f[i][j] = grid[i][j] == 1 ? 0 : INF;
                }
            }

            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (grid[i][j] == 1) {
                        continue;
                    }
                    if (i - 1 >= 0) {
                        f[i][j] = Math.min(f[i][j], f[i - 1][j] + 1);
                    }
                    if (j - 1 >= 0) {
                        f[i][j] = Math.min(f[i][j], f[i][j - 1] + 1);
                    }
                }
            }

            for (int i = n - 1; i >= 0; --i) {
                for (int j = n - 1; j >= 0; --j) {
                    if (grid[i][j] == 1) {
                        continue;
                    }
                    if (i + 1 < n) {
                        f[i][j] = Math.min(f[i][j], f[i + 1][j] + 1);
                    }
                    if (j + 1 < n) {
                        f[i][j] = Math.min(f[i][j], f[i][j + 1] + 1);
                    }
                }
            }

            int ans = -1;
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (grid[i][j] == 0) {
                        ans = Math.max(ans, f[i][j]);
                    }
                }
            }

            if (ans == INF) {
                return -1;
            } else {
                return ans;
            }
        }
    }

}
