package 字符串;

import java.util.*;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * */

public class validPalindrome {

    class Solution {
        public boolean isPalindrome(String s) {
            StringBuilder sgood = new StringBuilder();
            int length = s.length();
            for (int i = 0; i < length; i++) {
                char ch = s.charAt(i);
                if (Character.isLetterOrDigit(ch)) {
                    sgood.append(Character.toLowerCase(ch));
                }
            }
            StringBuffer sgood_rev = new StringBuffer(sgood).reverse();
            return sgood.toString().equals(sgood_rev.toString());
        }
    }

    class Solution_1 {
        public boolean isPalindrome(String s) {
            int n = s.length();
            int left = 0, right = n - 1;
            while (left < right) {
                while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                    ++left;
                }
                while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                    --right;
                }
                if (left < right) {
                    if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                        return false;
                    }
                    ++left;
                    --right;
                }
            }
            return true;
        }
    }
}
