package 字符串;

import java.util.HashMap;
import java.util.Map;

/**
 * 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数
 * （类似 C/C++ 中的 atoi 函数）。
 *
 * 函数 myAtoi(string s) 的算法如下：
 *
 * 读入字符串并丢弃无用的前导空格
 * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 如果整数数超过 32 位有符号整数范围 [?231,  231 ? 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 ?231 的整数应该被固定为 ?231 ，大于 231 ? 1 的整数应该被固定为 231 ? 1 。
 * 返回整数作为最终结果。
 * 注意：
 *
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
 * */

public class stringToInteger {
    static class Solution {
        public int myAtoi(String s) {
            int len  = s.length();
            char []charArray = s.toCharArray();

            int index = 0;

            while(index<len && charArray[index] == ' '){
                index++;
            }

            if(index == len){
                return 0;
            }

            int sign = 1;
            char firstChar = charArray[index];
            if(firstChar=='+'){
                index++;
            }
            else if(firstChar == '-'){
                index++;
                sign = -1;
            }

            int res = 0;

            while(index < len){
                char currChar = charArray[index];

                if(currChar<'0' || currChar>'9'){
                    break;
                }

                // 题目中说：环境只能存储 32 位大小的有符号整数，因此，需要提前判：断乘以 10 以后是否越界
                if(res>Integer.MAX_VALUE/10||(res==Integer.MAX_VALUE/10 && (currChar-'0') > Integer.MAX_VALUE%10)){
                    return Integer.MAX_VALUE;
                }
                if(res<Integer.MIN_VALUE/10||(res == Integer.MIN_VALUE/10 && (currChar-'0') > -(Integer.MIN_VALUE%10))){
                    return Integer.MIN_VALUE;
                }

                res = res*10 + sign*(currChar-'0');
                index++;
            }
            return res;
        }
    }


    /**
     * 自动机
     * */

    class Solution_1 {

        class Automaton {
            final String START = "start";
            final String SIGNED = "signed";
            final String IN_NUM = "in_number";
            final String END = "end";
            String state = START;
            Map<String, String[]> map;
            public int sign = 1;
            public long ans = 0;

            public Automaton() {
                map = new HashMap<>();
                map.put(START, new String[]{START, SIGNED, IN_NUM, END});
                map.put(SIGNED, new String[]{END, END, IN_NUM, END});
                map.put(IN_NUM, new String[]{END, END, IN_NUM, END});
                map.put(END, new String[]{END, END, END, END});
            }

            public int get_col(char c) {
                if (c == ' ') return 0;
                if (c == '+' || c == '-') return 1;
                if (c >= '0' && c <= '9') return 2;
                return 3;
            }

            public void get(char c) {
                state = map.get(state)[get_col(c)];
                if (state.equals(IN_NUM)) {
                    ans = ans * 10 + c - '0';
                    if (sign == 1) {
                        ans = Math.min(ans, Integer.MAX_VALUE);
                    } else {
                        // -(long)Integer.MIN_VALUE，这个操作有点东西，不然越界
                        ans = Math.min(ans, -(long)Integer.MIN_VALUE);
                    }
                } else if (state.equals(SIGNED))
                    sign = c == '+' ? 1 : -1;
            }
        }

        public int myAtoi(String str) {
            Automaton automaton = new Automaton();
            char[] c = str.toCharArray();
            for (char ch : c) {
                automaton.get(ch);
            }
            return automaton.sign * ((int) automaton.ans);
        }
    }

    public static void main(String args[]){
        Solution solution = new Solution();
        System.out.println(solution.myAtoi("words and -91283472332"));
    }
}
