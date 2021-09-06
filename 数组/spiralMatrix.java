package 数组;

import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个 m 行 n 列的矩阵 matrix ,请按照顺时针螺旋顺序返回矩阵中的所有元素。
 * */

public class spiralMatrix {
    static class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            int m = matrix.length,n = matrix[0].length;
            List<Integer> ans = new LinkedList<>();
            int left = 0,right = n-1,top = 0,bottom = m-1;
            int cnt = (Math.min(m,n)+1)/2;  // 需要遍历的次数
            for(int i = 0;i<cnt;i++){
                for(int j = left;j<=right;j++){
                    ans.add(matrix[top][j]);
                }
                for(int j = top+1;j<=bottom;j++){
                    ans.add(matrix[j][right]);
                }
                for(int j = right-1;j>=left;j--){
                    if(bottom!=top){
                        ans.add(matrix[bottom][j]);
                    }
                }
                for(int j = bottom-1;j>=top+1;j--){
                    if(right!=left){
                        ans.add(matrix[j][left]);
                    }
                }
                left++;right--;top++;bottom--;
            }

            return ans;
        }
    }

    public static void main(String []args){
        int [][]m = new int[1][1];
        m[0][0] = 1;
        Solution solution = new Solution();
        solution.spiralOrder(m);
    }
}
