package 字符串;

/**
 * 给你一个字符数组 chars ，请使用下述算法压缩：
 *
 * 从一个空字符串 s 开始。对于 chars 中的每组 连续重复字符 ：
 *
 * 如果这一组长度为 1 ，则将字符追加到 s 中。
 * 否则，需要向 s 追加字符，后跟这一组的长度。
 * 压缩后得到的字符串 s 不应该直接返回 ，需要转储到字符数组 chars 中。
 * 需要注意的是，如果组长度为 10 或 10 以上，则在 chars 数组中会被拆分为多个字符。
 *
 * 请在 修改完输入数组后 ，返回该数组的新长度。
 *
 * 你必须设计并实现一个只使用常量额外空间的算法来解决此问题。
 * */


public class compressString {

    public static class Solution {
        public int compress(char[] chars) {
            int length = chars.length;
            if(length<=1){
                return length;
            }
            int count = 1;int write = 0;
            for(int i = 0;i<length;i++){
                char now = chars[i];
                char next = i == length-1? ' ':chars[i+1];
                if(now!=next){
                    chars[write] = now;
                    write++;
                    if(count==1){
                        continue;
                    }
                    int len = String.valueOf(count).length(); //计算出count的位数
                    for(int j = (int)Math.pow(10,len-1);j>0; count%=j,j/=10,write++){
                        chars[write] = (char) (count/j+48);
                    }
                    count = 1;
                }else {
                    count++;
                }
            }
            return write;
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        solution.compress("aaaaba".toCharArray());
    }
}

