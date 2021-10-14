package 栈;

import java.util.Stack;

/**
 * 给你一个字符串 path ，表示指向某一文件或目录的 Unix 风格 绝对路径 （以 '/' 开头），请你将其转化为更加简洁的规范路径
 * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）
 * 两者都可以是复杂相对路径的组成部分。任意多个连续的斜杠（即，'//'）都被视为单个斜杠 '/'
 * 对于此问题，任何其他格式的点（例如，'...'）均被视为文件/目录名称
 * */

public class simplifyPath {

    /**
     * 1.此题主要考察的是栈,所以定义一个辅助栈;
     * 2.先把字符串以"/"为分隔符分割成数组,此时数组有"路径"、""、"."、".."这四种情况;
     * 3.遍历数组,当s[i].equals("..")并且栈不空时pop,当!s[i].equals("") && !s[i].equals(".") && !s[i].equals(".."),
     * 即s[i]是路径入栈;
     * 4.栈空,返回"/",栈非空,用StringBuffer做一个连接返回即可
     * */

    static class Solution {


        public  String simplifyPath(String path) {
            String[] s = path.split("/");
            Stack<String> stack = new Stack<>();

            for (String value : s) {
                if (!stack.isEmpty() && value.equals("..")) {
                    stack.pop();
                } else if (!value.equals("") && !value.equals(".") && !value.equals(".."))
                    stack.push(value);
            }

            if(stack.isEmpty()){
                return "/";
            }

            StringBuilder res = new StringBuilder();
            for (String value : stack) {
                res.append("/").append(value);
            }

            return res.toString();
        }
    }

    public static void main(String[] args){
        String res = "/a/./b///../../c/";

        System.out.println(new Solution().simplifyPath(res));
    }

}
