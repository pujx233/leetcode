package 其它;

import java.util.Arrays;

/**
 * 统计所有小于非负整数 n 的质数的数量。
 * */

public class countPrimes {

    class Solution {
        public int countPrimes(int n) {
            int ans = 0;
            boolean isPrime[] = new boolean[n+1];

            for(int i = 2;i<n;i++){
                if(!isPrime[i]){
                    ans++;

                    if ((long) i * i < n) {
                        for (int j = i * i; j < n; j += i) {
                            isPrime[j] = true;
                        }
                    }
                }
            }

            return ans;
        }
    }
}
