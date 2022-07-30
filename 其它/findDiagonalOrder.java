package 其它;

import java.util.*;

/**
 *
 * 给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。
 *
 * */

public class findDiagonalOrder {

    /**
     * 若当前遍历方向为往右上角，即 dir = 1，优先找 (x, y + 1) 作为下一发起点，若越界，则找 (x + 1, y) 作为下一发起点；
     * 若当前遍历方向为往左下角，即 dir = -1，优先找 (x + 1, y) 作为下一发起点，若越界，则找 (x, y + 1) 作为下一发起点。
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
