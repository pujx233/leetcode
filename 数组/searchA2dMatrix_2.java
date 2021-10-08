package 数组;

import java.util.*;

/**
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 *
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * */

public class searchA2dMatrix_2 {

    /**
     * 模拟
     * */

    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            // start our "pointer" in the bottom-left
            int row = matrix.length-1;
            int col = 0;

            while (row >= 0 && col < matrix[0].length) {
                if (matrix[row][col] > target) {
                    row--;
                } else if (matrix[row][col] < target) {
                    col++;
                } else { // found it
                    return true;
                }
            }

            return false;
        }
    }

    class Solution_1 {
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix.length == 0 || matrix[0].length == 0) {
                return false;
            }
            return searchMatrixHelper(matrix, 0, 0, matrix[0].length - 1, matrix.length - 1, matrix[0].length - 1, matrix.length - 1, target);
        }

        private boolean searchMatrixHelper(int[][] matrix, int x1, int y1, int x2, int y2, int xMax, int yMax, int target) {
            //只需要判断左上角坐标即可
            if (x1 > xMax || y1 > yMax) {
                return false;
            }

            //x 轴代表的是列，y 轴代表的是行
            if(x1 == x2 && y1 == y2){
                return matrix[y1][x1] == target;
            }
            int m1 = (x1 + x2) >>> 1;
            int m2 = (y1 + y2) >>> 1;
            if (matrix[m2][m1] == target) {
                return true;
            }
            if (matrix[m2][m1] < target) {
                // 右上矩阵
                return searchMatrixHelper(matrix, m1 + 1, y1, x2, m2, x2, y2, target) ||
                        // 左下矩阵
                        searchMatrixHelper(matrix, x1, m2 + 1, m1, y2, x2, y2, target) ||
                        // 右下矩阵
                        searchMatrixHelper(matrix, m1 + 1, m2 + 1, x2, y2, x2, y2, target);

            } else {
                // 右上矩阵
                return searchMatrixHelper(matrix, m1 + 1, y1, x2, m2, x2, y2, target) ||
                        // 左下矩阵
                        searchMatrixHelper(matrix, x1, m2 + 1, m1, y2, x2, y2, target) ||
                        // 左上矩阵
                        searchMatrixHelper(matrix, x1, y1, m1, m2, x2, y2, target);
            }
        }
    }
}
