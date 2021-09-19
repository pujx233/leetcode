package 动态规划;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 *
 * 问总共有多少条不同的路径？
 * */

public class uniquePaths {

    class Solution {
        public int uniquePaths(int m, int n) {
            int[][] res = new int[m][n];
            res[0][0] = 1;

            for (int i = 0; i < m; ++i) {
                res[i][0] = 1;
            }
            for (int j = 0; j < n; ++j) {
                res[0][j] = 1;
            }

            for (int i = 1; i < m; ++i) {
                for (int j = 1; j < n; ++j) {
                    res[i][j] = res[i - 1][j] + res[i][j - 1];
                }
            }
            return res[m - 1][n - 1];

        }
    }
}
