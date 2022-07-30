package 字符串;

/**
 * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。
 * 比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。
 * 你可以假设字符串中只包含大小写英文字母（a至z）。
 * */

public class compressStringEasy {

    public static class Solution {
        public String compressString(String S) {
            if (S.length() == 0) { // 空串处理
                return S;
            }
            StringBuffer ans = new StringBuffer();
            int cnt = 1;
            char ch = S.charAt(0);
            for (int i = 1; i < S.length(); ++i) {
                if (ch == S.charAt(i)) {
                    cnt++;
                } else {
                    ans.append(ch);
                    ans.append(cnt);
                    ch = S.charAt(i);
                    cnt = 1;
                }
            }
            ans.append(ch);
            ans.append(cnt);
            return ans.length() >= S.length() ? S : ans.toString();
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.compressString("aabcccccaaa"));
    }
}
