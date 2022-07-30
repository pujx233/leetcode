package ����;

import java.util.*;

/**
 * ���� n ���Ǹ����� a1��a2��...��an��ÿ�������������е�һ���� (i, ai)
 * �������ڻ� n ����ֱ�ߣ���ֱ�� i �������˵�ֱ�Ϊ (i, ai) �� (i, 0)
 * �ҳ����е������ߣ�ʹ�������� x �Ṳͬ���ɵ�����������������ˮ��
 *
 * ˵�����㲻����б����
 * */

public class containerWithMostWater {

    /**
     * ˫ָ��
     * */

    public class Solution {
        public int maxArea(int[] height) {
            int l = 0, r = height.length - 1;
            int ans = 0;
            while (l < r) {
                int area = Math.min(height[l], height[r]) * (r - l);
                ans = Math.max(ans, area);
                if (height[l] <= height[r]) {
                    ++l;
                }
                else {
                    --r;
                }
            }
            return ans;
        }
    }
}
