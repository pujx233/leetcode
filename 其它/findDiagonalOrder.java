package ����;

import java.util.*;

/**
 *
 * ����һ����СΪ m x n �ľ��� mat �����ԶԽ��߱�����˳����һ�����鷵����������е�����Ԫ�ء�
 *
 * */

public class findDiagonalOrder {

    /**
     * ����ǰ��������Ϊ�����Ͻǣ��� dir = 1�������� (x, y + 1) ��Ϊ��һ����㣬��Խ�磬���� (x + 1, y) ��Ϊ��һ����㣻
     * ����ǰ��������Ϊ�����½ǣ��� dir = -1�������� (x + 1, y) ��Ϊ��һ����㣬��Խ�磬���� (x, y + 1) ��Ϊ��һ����㡣
     * */

    static class Solution {
        public int[] findDiagonalOrder(int[][] mat) {

            int n = mat.length, m = mat[0].length, cnt = m * n;
            int ans[] = new int[cnt];
            int x = 0, y = 0, judge = 1, index = 0;
            while (index!=cnt){
                ans[index++] = mat[x][y];

                int nx = x, ny = y;
                if (judge == 1) {
                    nx = x - 1; ny = y + 1;
                } else {
                    nx = x + 1; ny = y - 1;
                }
                if (index < cnt && (nx < 0 || nx >= n || ny < 0 || ny >= m)) {
                    if (judge == 1) {
                        nx = y + 1 < m ? x : x + 1;
                        ny = y + 1 < m ? y + 1 : y;
                    } else {
                        nx = x + 1 < n ? x + 1 : x;
                        ny = x + 1 < n ? y : y + 1;
                    }
                    judge *= -1;
                }
                x = nx; y = ny;
            }

            return ans;
        }

        public static void main(String[] args){
            int[][] mat = new int[][]{{2,3}};

            System.out.println(Arrays.toString(new Solution().findDiagonalOrder(mat)));

        }
    }
}
