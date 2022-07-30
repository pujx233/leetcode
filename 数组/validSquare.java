package 数组;

import java.util.*;

/**
 * 给定2D空间中四个点的坐标 p1, p2, p3 和 p4，如果这四个点构成一个正方形，则返回 true 。
 *
 * 点的坐标 pi 表示为 [xi, yi] 。输入 不是 按任何顺序给出的。
 *
 * 一个 有效的正方形 有四条等边和四个等角(90度角)。
 * */

public class validSquare {

    class Solution {
        long len = -1;
        public boolean validSquare(int[] a, int[] b, int[] c, int[] d) {
            return calc(a, b, c) && calc(a, b, d) && calc(a, c, d) && calc(b, c, d);
        }
        boolean calc(int[] a, int[] b, int[] c) {
            long l1 = (long) (a[0] - b[0]) * (a[0] - b[0]) + (long) (a[1] - b[1]) * (a[1] - b[1]);
            long l2 = (long) (a[0] - c[0]) * (a[0] - c[0]) + (long) (a[1] - c[1]) * (a[1] - c[1]);
            long l3 = (long) (b[0] - c[0]) * (b[0] - c[0]) + (long) (b[1] - c[1]) * (b[1] - c[1]);
            boolean ok = (l1 == l2 && l1 + l2 == l3) || (l1 == l3 && l1 + l3 == l2) || (l2 == l3 && l2 + l3 == l1);
            if (!ok) return false;
            if (len == -1) len = Math.min(l1, l2);
            else if (len == 0 || len != Math.min(l1, l2)) return false;
            return true;
        }
    }

    class Solution1 {
        public long len(int[] x,int[] y){
            return (long) (x[0] - y[0]) * (x[0] - y[0]) + (long) (x[1] - y[1]) * (x[1] - y[1]);
        }
        public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
            if(p1[0] == p2[0] && p1[1] == p2[1]) return false;
            long[] l = new long[6];
            l[0] = len(p1,p2);
            l[1] = len(p1,p3);
            l[2] = len(p1,p4);
            l[3] = len(p2,p3);
            l[4] = len(p2,p4);
            l[5] = len(p3,p4);
            Arrays.sort(l);
            return  l[0] == l[3] && l[4] == l[5] && l[0] * 2 == l[5];
        }
    }
}
