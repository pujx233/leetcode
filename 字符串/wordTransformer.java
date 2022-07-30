package �ַ���;

import java.util.*;

/**
 * �����ֵ��е������ʣ�������ȡ�дһ����������һ����ת������һ���ʣ� ����һ��ֻ�ܸı�һ���ַ���
 * ÿһ���õ����´ʶ����������ֵ����ҵ���
 *
 * ��дһ�����򣬷���һ�����ܵ�ת�����С����ж�����ܵ�ת�����У�����Է����κ�һ����
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
                    //���δ�����ʹ����ҿ���ֱ��ת�����������У�compare()���������ж��Ƿ����ת����
                    if(!visited[i] && compare(wordList.get(i), res)){
                        deque.add(wordList.get(i));
                        visited[i] = true;
                        //�洢ǰ��
                        map.put(wordList.get(i), res);
                    }
                }

            }

            if(!flag){
                return ans;
            }

            //������
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
