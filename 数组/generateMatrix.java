package ����;

/**
 * ����һ�������� n ������һ������ 1 �� n2 ����Ԫ�أ���Ԫ�ذ�˳ʱ��˳���������е� n x n �����ξ��� matrix ��
 * */

public class generateMatrix {

    class Solution {
        public int[][] generateMatrix(int n) {
            int[][] ans = new int[n][n];
            int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
            for (int i = 0, startX = 0, startY = 0, d = 0; i < n * n; i++) {
                ans[startX][startY] = i + 1;
                int curX = startX + dx[d], curY = startY + dy[d];
                if (curX < 0 || curY < 0 || curX >= n || curY >= n || ans[curX][curY] != 0) {
                    d = (d + 1) % 4;
                }
                startX = startX + dx[d];
                startY = startY + dy[d];
            }
            return ans;
        }
    }
}
