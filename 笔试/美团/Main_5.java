package 笔试.美团;

import java.util.*;

public class Main_5 {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            int i = 0;
            int j = 0;
            int sum = 0;
            while (j < n) {
                if (max(nums, i, j) <= min(nums, j + 1, n - 1)) {
                    sum++;
                    i = j + 1;
                    j = j + 1;
                } else {
                    j++;
                }
            }
            System.out.println(sum);

        }

        public static int max(int[] nums, int left, int right) {
            int max = Integer.MIN_VALUE;
            for (int i = left; i <= right; i++) {
                if (max < nums[i]) max = nums[i];
            }
            return max;
        }

        public static int min(int[] nums, int left, int right) {
            int max = Integer.MAX_VALUE;
            for (int i = left; i <= right; i++) {
                if (max > nums[i]) max = nums[i];
            }
            return max;
        }

}
