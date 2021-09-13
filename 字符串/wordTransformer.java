package 字符串;

import java.util.*;

/**
 * 给定字典中的两个词，长度相等。写一个方法，把一个词转换成另一个词， 但是一次只能改变一个字符。
 * 每一步得到的新词都必须能在字典中找到。
 *
 * 编写一个程序，返回一个可能的转换序列。如有多个可能的转换序列，你可以返回任何一个。
 * */

public class wordTransformer {

    class Solution {
        public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
            List<String> ans = new LinkedList<String>();
            Deque<String> deque = new ArrayDeque<String>();
            Map<String,String> map = new HashMap<String,String>();

            boolean[] visited = new boolean[wordList.size()];
            if(!wordList.contains(endWord)){
                return ans;
            }

            deque.offer(beginWord);
            boolean flag = false;

            while (!deque.isEmpty()){
                String res = deque.poll();
                if(res.equals(endWord)){
                    flag = true;
                    break;
                }
                for(int i = 0;i < wordList.size();i ++){
                    //如果未被访问过并且可以直接转换，则加入队列，compare()函数用来判断是否可以转换。
                    if(!visited[i] && compare(wordList.get(i), res)){
                        deque.add(wordList.get(i));
                        visited[i] = true;
                        //存储前驱
                        map.put(wordList.get(i), res);
                    }
                }

            }

            if(!flag){
                return ans;
            }

            //遍历答案
            String key = endWord;
            while(map.get(key) != beginWord){
                ans.add(key);
                key = map.get(key);
            }
            ans.add(key);
            ans.add(map.get(key));
            Collections.reverse(ans);
            return ans;

        }


        public  boolean compare(String word1,String word2){
            int diff = 0;
            for(int i = 0;i < word1.length();i ++){
                if(word1.charAt(i) != word2.charAt(i)){
                    diff ++;
                    if(diff >= 2){
                        return false;
                    }
                }
            }
            return true;
        }
    }

}
