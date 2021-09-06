package 其它;

/**
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * */

public class sqrtX {

    /**
     * 牛顿法
     * */
    class Solution {
        public int mySqrt(int x) {
            if(x == 0){
                return 0;
            }

            double C = x;
            double x0 = x;

            while (true){
                double xi = (x0+C/x0)/2;
                if(Math.abs(x0-xi)<1e-7){
                    break;
                }
                x0 = xi;
            }
            return (int)x0;
        }
    }

    class Solution_2 {
        public int mySqrt(int x) {
            int l = 0, r = x, ans = -1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if ((long) mid * mid <= x) {
                    ans = mid;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            return ans;
        }
    }
}
