package 动态规划;

public class editDistance {
    public static void main(String []args){
        Solution solution = new Solution();
        System.out.println(solution.minDistance("a","bc"));
    }

    static class Solution {
        public int minDistance(String word1, String word2) {
            int n = word1.length(),m = word2.length();
            if (n * m == 0) {
                return n+m;
            }

            // DP 数组
            int[][] D = new int[n + 1][m + 1];

            // 边界状态初始化
            for (int i = 0; i < n + 1; i++) {
                D[i][0] = i;
            }
            for (int j = 0; j < m + 1; j++) {
                D[0][j] = j;
            }
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < m + 1; j++) {
                    int left = D[i - 1][j] + 1;
                    int down = D[i][j - 1] + 1;
                    int left_down = D[i - 1][j - 1];
                    if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                        left_down += 1;
                    }
                    D[i][j] = Math.min(left, Math.min(down, left_down));
                }
            }

            return D[n][m];
        }
    }
}
