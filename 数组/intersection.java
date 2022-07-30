package 数组;

import java.util.*;

/**
 *
 * 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 *
 * */

public class intersection {

    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            Set<Integer> set1 = new HashSet<>();
            Set<Integer> set2 = new HashSet<>();
            for(int i:nums1){
                set1.add(i);
            }
            for(int i:nums2){
                if(set1.contains(i)){
                    set2.add(i);
                }
            }
            int[] arr = new int[set2.size()];
            int j=0;
            for(int i:set2){
                arr[j++] = i;
            }
            return arr;
        }
    }

    class Solution1 {
        public int[] intersection(int[] nums1, int[] nums2) {
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            int length1 = nums1.length, length2 = nums2.length;
            int[] intersection = new int[length1 + length2];
            int index = 0, index1 = 0, index2 = 0;
            while (index1 < length1 && index2 < length2) {
                int num1 = nums1[index1], num2 = nums2[index2];
                if (num1 == num2) {
                    // 保证加入元素的唯一性
                    if (index == 0 || num1 != intersection[index - 1]) {
                        intersection[index++] = num1;
                    }
                    index1++;
                    index2++;
                } else if (num1 < num2) {
                    index1++;
                } else {
                    index2++;
                }
            }
            return Arrays.copyOfRange(intersection, 0, index);
        }
    }
}
