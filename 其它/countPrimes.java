package ����;

import java.util.Arrays;

/**
 * ͳ������С�ڷǸ����� n ��������������
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
