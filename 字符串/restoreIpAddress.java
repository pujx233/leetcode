package �ַ���;

import java.util.*;

/**
 * ����һ��ֻ�������ֵ��ַ��������Ա�ʾһ�� IP ��ַ���������п��ܴ� s ��õ� ��Ч IP ��ַ ������԰��κ�˳�򷵻ش𰸡�
 *
 * ��Ч IP ��ַ �������ĸ�������ÿ������λ�� 0 �� 255 ֮����ɣ��Ҳ��ܺ���ǰ�� 0��������֮���� '.' �ָ���
 *
 * ���磺"0.1.2.201" �� "192.168.1.1" �� ��Ч IP ��ַ������ "0.011.255.245"��"192.168.1.312" �� "192.168@1.1" �� ��Ч IP ��ַ
 * */

public class restoreIpAddress {

    class Solution {

        List<String> ans = new ArrayList<String>();
        // ��Լ����
        Deque<String> path = new ArrayDeque<>(4);

        public List<String> restoreIpAddresses(String s) {
            int len = s.length();
            if(len>12 || len<4){
                return null;
            }
            dfs(s,len,0,4);

            return ans;
        }

        public void dfs(String s,int len,int begin,int num){
            if(begin==len){
                if(num == 0){
                    ans.add(String.join(".",path));
                }
                return;
            }

            for(int i = begin;i<begin+3;i++){
                if(i>=len){
                    break;
                }
                if (num * 3 < len - i) {
                    continue;
                }

                if (judgeIpSegment(s, begin, i)) {
                    String currentIpSegment = s.substring(begin, i + 1);
                    path.offer(currentIpSegment);
                    dfs(s, len, i + 1, num - 1);
                    path.removeLast();
                }
            }
        }

        private boolean judgeIpSegment(String s, int left, int right) {
            int len = right - left + 1;
            if (len > 1 && s.charAt(left) == '0') {
                return false;
            }

            int res = 0;
            while (left <= right) {
                res = res * 10 + s.charAt(left) - '0';
                left++;
            }

            return res >= 0 && res <= 255;
        }

    }
}
