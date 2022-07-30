package 字符串;

/**
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 *
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 *
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 *
 * */

public class removeAllAdjacentDuplicatesInString {

    /**
     * 栈
     * */

    class Solution {
        public String removeDuplicates(String s) {
            StringBuffer stack = new StringBuffer();
            int top = -1;
            for (int i = 0; i < s.length(); ++i) {
                char ch = s.charAt(i);
                if (top >= 0 && stack.charAt(top) == ch) {
                    stack.deleteCharAt(top);
                    --top;
                } else {
                    stack.append(ch);
                    ++top;
                }
            }
            return stack.toString();
        }
    }
}
