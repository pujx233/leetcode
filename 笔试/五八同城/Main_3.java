package ±ÊÊÔ.Îå°ËÍ¬³Ç;

import java.util.*;

public class Main_3 {

    public static class Solution {

        public int[] find (int[] arg) {
            Map<Integer,Integer> note = new HashMap<>();
            ArrayList<Integer> res = new ArrayList<>();
            int len = arg.length;
            for(int i = 0;i<len;i++){
                if(!note.containsKey(arg[i])){
                    note.put(arg[i],1);
                }
                else {
                    int num = note.get(arg[i]);
                    note.put(arg[i],num+1);
                }
            }

            for(Integer key:note.keySet()){
                if(note.get(key)==1){
                    res.add(key);
                }
            }

            int[] ans = new int [res.size()];
            for(int i = 0;i<res.size();i++){
                ans[i] = res.get(i);
            }
            System.out.println(Arrays.toString(ans));

            return ans;

        }
    }

    public static  void main(String []args){
        Solution solution = new Solution();
        solution.find(new int[]{1,1,4,6,7,7,3});
    }
}
