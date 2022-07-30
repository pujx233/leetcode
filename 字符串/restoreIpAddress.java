package 字符串;

import java.util.*;

/**
 * 给定一个只包含数字的字符串，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。
 *
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 *
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址
 * */

public class restoreIpAddress {

    class Solution {

        List<String> ans = new ArrayList<String>();
        // 节约性能
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
