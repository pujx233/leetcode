package 数组;

import java.util.*;

/**
 * 给你一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点。求最多有多少个点在同一条直线上。
 * */

public class maxPoints {

    class Solution {
        public int maxPoints(int[][] ps) {
            int n = ps.length;
            int ans = 1;
            for (int i = 0; i < n; i++) {
                Map<String, Integer> map = new HashMap<>();
                // 由当前点 i 发出的直线所经过的最多点数量
                int max = 0;
                for (int j = i + 1; j < n; j++) {
                    int x1 = ps[i][0], y1 = ps[i][1], x2 = ps[j][0], y2 = ps[j][1];
                    int a = x1 - x2, b = y1 - y2;
                    int k = gcd(a, b);
                    String key = (a / k) + "_" + (b / k);
                    map.put(key, map.getOrDefault(key, 0) + 1);
                    max = Math.max(max, map.get(key));
                }
                ans = Math.max(ans, max + 1);
            }
            return ans;
        }
        int gcd(int a, int b) {
            return b == 0 ? a : gcd(b, a % b);
        }
    }
}
