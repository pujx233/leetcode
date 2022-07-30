package 数组;

import java.util.*;

/**
 *
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 *
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 *
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 *
 * */

public class canFinish {

    public static class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            if(numCourses<=0){
                return false;
            }
            int pLen = prerequisites.length;
            if(pLen == 0){
                return true;
            }

            int[] inDegree = new int[numCourses];

            HashSet<Integer>[] adj = new HashSet[numCourses];

            for (int i = 0; i < numCourses; i++) {
                adj[i] = new HashSet<>();
            }


            for (int[] p : prerequisites) {
                inDegree[p[0]]++;
                adj[p[1]].add(p[0]);
            }
            Queue<Integer> queue = new LinkedList<>();

            // 首先加入入度为 0 的结点
            for (int i = 0; i < numCourses; i++) {
                if (inDegree[i] == 0) {
                    queue.add(i);
                }
            }

            // 记录已经出队的课程数量
            int cnt = 0;
            while (!queue.isEmpty()) {
                Integer top = queue.poll();
                cnt += 1;
                // 遍历当前出队结点的所有后继结点
                for (int successor : adj[top]) {
                    inDegree[successor]--;
                    if (inDegree[successor] == 0) {
                        queue.add(successor);
                    }
                }
            }
            return cnt == numCourses;
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[][] m = new int[][]{{1,0}};
        int n = 2;
        solution.canFinish(n,m);
    }
}
