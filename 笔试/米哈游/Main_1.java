package ±ÊÊÔ.Ã×¹þÓÎ;

import java.util.*;

public class Main_1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = Integer.parseInt(in.nextLine());
        List<Integer> ans = new LinkedList<>();
        for(int i = 0;i<num;i++){
            int cnt = 0;
            String a = in.nextLine();
            char[] res = a.toCharArray();
            Deque<Character> deque_1 = new ArrayDeque<>();

            for(char b: res){
                if(b == '{' || b == '['){
                    deque_1.push(b);
                }
                else if(b == '}'){
                    if(!deque_1.peek().equals('{')){
                        cnt++;
                    }
                    deque_1.pop();
                }
                else if(b==']'){
                    if (!deque_1.peek().equals('[')){
                        cnt++;
                    }
                    deque_1.pop();
                }

            }
            ans.add(cnt);


        }

        for(int i: ans){
            System.out.println(i);
        }
    }

}

