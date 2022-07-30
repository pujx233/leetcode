package ±  ‘.Õ¯“◊ª•”È;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String jsonObject = sc.nextLine();
        char[] res = jsonObject.toCharArray();
        Deque<Character> deque = new ArrayDeque<Character>();

        int cnt = 0, max = 0;
        for(char re: res){
            if(re=='{' || re == '['){
                deque.push(re);
                cnt++;
                if(max<cnt){
                    max = cnt;
                }
            }
            else if(re=='}' || re == ']'){
                deque.pop();
                cnt --;
            }
        }

        System.out.println(max);

    }
}

