package 数组;

/**
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2
 * 另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目
 *
 * 请你合并 nums2 到 nums1 中，使合并后的数组同样按非递减顺序排列。
 *
 * 注意：最终，并后数组不应由函数返回，而是存储在数组 nums1 中
 * 为了应对这种情况，nums1 的初始长度为 m + n
 * 其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 * */

public class mergeTwoSorts {
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int p1 = 0;int p2 = 0;
            int []temp = new int[m+n];
            int cur;
            while(p1<m||p2<n){
                if (p1 == m) {
                    cur = nums2[p2++];
                } else if (p2 == n) {
                    cur = nums1[p1++];
                } else if (nums1[p1] < nums2[p2]) {
                    cur = nums1[p1++];
                } else {
                    cur = nums2[p2++];
                }
                temp[p1+p2-1]=cur;
            }
            for (int i = 0; i != m + n; ++i) {
                nums1[i] = temp[i];
            }
        }
    }

}
