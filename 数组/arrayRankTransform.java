package 数组;

import java.util.*;

/**
 * 给你一个整数数组 arr ，请你将数组中的每个元素替换为它们排序后的序号。
 *
 * 序号代表了一个元素有多大。序号编号的规则如下：
 *
 * 序号从 1 开始编号。
 * 一个元素越大，那么序号越大。如果两个元素相等，那么它们的序号相同。
 * 每个数字的序号都应该尽可能地小。
 * */

public class arrayRankTransform {

    class Solution {
        public int[] arrayRankTransform(int[] arr) {
            int[] sortedArr = new int[arr.length];
            System.arraycopy(arr, 0, sortedArr, 0, arr.length);
            Arrays.sort(sortedArr);
            Map<Integer, Integer> ranks = new HashMap<Integer, Integer>();
            int[] ans = new int[arr.length];
            for (int a : sortedArr) {
                if (!ranks.containsKey(a)) {
                    ranks.put(a, ranks.size() + 1);
                }
            }
            for (int i = 0; i < arr.length; i++) {
                ans[i] = ranks.get(arr[i]);
            }
            return ans;
        }
    }
}
