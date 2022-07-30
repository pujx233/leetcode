package ����;

import java.util.*;

/**
 *
 * �����ѧ�ڱ���ѡ�� numCourses �ſγ̣���Ϊ 0 �� numCourses - 1 ��
 *
 * ��ѡ��ĳЩ�γ�֮ǰ��ҪһЩ���޿γ̡� ���޿γ̰����� prerequisites ���������� prerequisites[i] = [ai, bi] ����ʾ���Ҫѧϰ�γ� ai �� ���� ��ѧϰ�γ�  bi ��
 *
 * ���磬���޿γ̶� [0, 1] ��ʾ����Ҫѧϰ�γ� 0 ������Ҫ����ɿγ� 1 ��
 * �����ж��Ƿ����������пγ̵�ѧϰ��������ԣ����� true �����򣬷��� false ��
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

            // ���ȼ������Ϊ 0 �Ľ��
            for (int i = 0; i < numCourses; i++) {
                if (inDegree[i] == 0) {
                    queue.add(i);
                }
            }

            // ��¼�Ѿ����ӵĿγ�����
            int cnt = 0;
            while (!queue.isEmpty()) {
                Integer top = queue.poll();
                cnt += 1;
                // ������ǰ���ӽ������к�̽��
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
