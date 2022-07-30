package ±ÊÊÔ.Îå°ËÍ¬³Ç;

import java.util.HashMap;
import java.util.Map;

public class Main_2 {
    public class Solution{
        public int getTeams (int[] heros) {
            // write code here
            HashMap<Integer,Integer> map = new HashMap<>();
            for (int hero : heros) {
                map.put(hero,map.getOrDefault(hero,0)+1);
            }
            if (map.size()<5) return 0;
            int res = 1;
            for (Map.Entry<Integer, Integer> m : map.entrySet()) {
                res *= m.getValue();
            }
            return res;
        }
    }
}
