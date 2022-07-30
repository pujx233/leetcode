package �ַ���;

import java.util.*;

/**
 * ����һ���ַ��� s ��һ���ַ��� t ������ s �к��� t �����ַ�����С�Ӵ���
 * ��� s �в����ں��� t �����ַ����Ӵ����򷵻ؿ��ַ��� "" ��
 *
 * ע�⣺
 *
 * ���� t ���ظ��ַ�������Ѱ�ҵ����ַ����и��ַ��������벻���� t �и��ַ�������
 * ��� s �д����������Ӵ������Ǳ�֤����Ψһ�Ĵ𰸡�
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
