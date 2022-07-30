package �ַ���;

import java.util.*;

/**
 * ���� n �����������ŵĶ������������һ�������������ܹ��������п��ܵĲ��� ��Ч�� ������ϡ�
 *
 * ��Ч������������㣺�����ű�������ȷ��˳��պϡ�
 * */

public class generateParentheses {

    class Solution {

        List<String> ans = new ArrayList<>();

        public List<String> generateParenthesis(int n) {
            if(n == 0){
                return null;
            }
            dfs("", n, n);

            return ans;
        }

        // ������֧�������֧С���ҷ�֧ʱֱ�ӷ���

        private void dfs(String curStr, int left, int right) {
            if (left == 0 && right == 0) {
                ans.add(curStr);
                return;
            }

            // ��֦����ͼ�������ſ���ʹ�õĸ����ϸ���������ſ���ʹ�õĸ������ż�֦��ע�����ϸ�ڣ�
            if (left > right) {
                return;
            }

            if (left > 0) {
                dfs(curStr + "(", left - 1, right);
            }

            if (right > 0) {
                dfs(curStr + ")", left, right - 1);
            }
        }
    }
}
