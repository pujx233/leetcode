package 其它;

import java.util.*;

/**
 * 0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。
 * 求出这个圆圈里剩下的最后一个数字。
 *
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，
 * 则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 * */

public class JosephusRing {


    /**
     * 暴力
     * */

    public static class Solution {
        public int lastRemaining(int n, int m) {
            ArrayList<Integer> list = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                list.add(i);
            }
            int idx = 0;
            while (n > 1) {
                idx = (idx + m - 1) % n;
                list.remove(idx);
                n--;
            }
            return list.get(0);
        }
    }

    /**
     * 迭代
     * */

    public class Solution_1 {
        public int lastRemaining(int n, int m) {
            int ans = 0;
            // 最后一轮剩下2个人，所以从2开始反推
            for (int i = 2; i <= n; i++) {
                ans = (ans + m) % i;
            }
            return ans;
        }
    }

    /**
     * 递归
     * */

    public class Solution_2 {
        public int lastRemaining(int n, int m) {
            return f(n, m);
        }

        public int f(int n, int m) {
            if (n == 1) {
                return 0;
            }
            int x = f(n - 1, m);
            return (m + x) % n;
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.lastRemaining(10,17));

    }

}
