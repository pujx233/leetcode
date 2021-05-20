/*给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。*/

import java.util.HashMap;

public class longestSubstring {

/*    public static void main(String[] args){
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }*/

    // 滑动窗口
    public static int lengthOfLongestSubstring(String s) {
        if(s.length()==0){
            return 0;
        }
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        int max = 0;
        int left = 0;

        for(int i = 0; i < s.length(); i ++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;
    }

}
