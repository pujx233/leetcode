package 数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [start i, end i]
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 * */

public class mergeIntervals {


    static class Solution {
        public int[][] merge(int[][] intervals) {
            if(intervals.length==0){
                return new int[0][2];
            }

            // lambda 进行二维数组排序
            Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);

            List<int []> ans = new ArrayList<int[]>();

            for(int i = 0;i<intervals.length;i++){
                int l = intervals[i][0];int r = intervals[i][1];
                if(ans.size()==0||ans.get(ans.size()-1)[1]<l){
                    ans.add(intervals[i]);
                }
                else{
                    ans.get(ans.size()-1)[1]=Math.max(ans.get(ans.size()-1)[1],r);
                }
            }


            return ans.toArray(new int[ans.size()][2]);
        }
    }

    public static void main(String args[]){
        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.merge(new int[][]{{1, 3}, {8, 10}, {2, 6}, {15, 18}})));
    }
}
