package 字符串;

import java.util.*;

/**
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。
 * 如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 * 注意：
 *
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * */

public class minimumWindowSubstring {

    Map<Character,Integer> orient = new HashMap<>();
    Map<Character,Integer> count = new HashMap<>();

    class Solution {
        public String minWindow(String s, String t) {

            int tLen = t.length();
            for (int i = 0; i < tLen; i++) {
                char c = t.charAt(i);
                orient.put(c, orient.getOrDefault(c, 0) + 1);
            }

            int l = 0, r = -1;
            int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
            int sLen = s.length();

            while (r < sLen) {
                ++r;
                if (r < sLen && orient.containsKey(s.charAt(r))) {
                    count.put(s.charAt(r), count.getOrDefault(s.charAt(r), 0) + 1);
                }
                while (check() && l <= r) {
                    if (r - l + 1 < len) {
                        len = r - l + 1;
                        ansL = l;
                        ansR = l + len;
                    }
                    if (orient.containsKey(s.charAt(l))) {
                        count.put(s.charAt(l), count.getOrDefault(s.charAt(l), 0) - 1);
                    }
                    ++l;
                }
            }

            return ansL == -1 ? "" : s.substring(ansL, ansR);
        }


        public boolean check(){
            Iterator iterator = orient.entrySet().iterator();
            while (iterator.hasNext()){
                Map.Entry entry = (Map.Entry)iterator.next();
                Character key = (Character) entry.getKey();
                Integer value = (Integer)entry.getValue();

                if (count.getOrDefault(key, 0) < value) {
                    return false;
                }
            }
            return true;
        }
    }
}
