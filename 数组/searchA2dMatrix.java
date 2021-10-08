package 数组;

import java.util.*;

/**
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * */

public class searchA2dMatrix {

    /**
     * 一次二分查找
     * */

    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length, n = matrix[0].length;
            int low = 0, high = m * n - 1;
            while (low <= high) {
                int mid = (high - low) / 2 + low;
                int x = matrix[mid / n][mid % n];
                if (x < target) {
                    low = mid + 1;
                } else if (x > target) {
                    high = mid - 1;
                } else {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * 两次二分查找
     * */

    class Solution_1 {
        public boolean searchMatrix(int[][] matrix, int target) {
            int rowIndex = binarySearchFirstColumn(matrix, target);
            if (rowIndex < 0) {
                return false;
            }
            return binarySearchRow(matrix[rowIndex], target);
        }

        public int binarySearchFirstColumn(int[][] matrix, int target) {
            int low = -1, high = matrix.length - 1;
            while (low < high) {
                int mid = (high - low + 1) / 2 + low;
                if (matrix[mid][0] <= target) {
                    low = mid;
                } else {
                    high = mid - 1;
                }
            }
            return low;
        }

        public boolean binarySearchRow(int[] row, int target) {
            int low = 0, high = row.length - 1;
            while (low <= high) {
                int mid = (high - low) / 2 + low;
                if (row[mid] == target) {
                    return true;
                } else if (row[mid] > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return false;
        }
    }
}
