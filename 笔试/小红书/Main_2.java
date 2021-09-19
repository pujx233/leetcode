package 笔试.小红书;

/**
 * 求最短使其升序排列或倒序排列的次数
 * */

import java.util.*;

public class Main_2{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextInt()){
            int n = scanner.nextInt();
            int[] arr1 = new int[n];
            Map<Integer,Integer> hash = new HashMap<>();
            for(int i = 0;i < n;i++)
                arr1[i] = scanner.nextInt();
            int[] arr2 = Arrays.copyOf(arr1, arr1.length);
            Arrays.sort(arr2);
            for(int i = 0;i < n;i++){
                hash.put(arr2[i],i);  //数组元素排序后应该放的位置
            }

            boolean[] vis = new boolean[n];
            int loops = 0;
            for(int i = 0;i < n;i++){
                if(!vis[i]){
                    int j = i;
                    while(!vis[j]){
                        vis[j] = true;
                        j = hash.get(arr1[j]);   //寻找对应位置上的数下一个应该放的位置
                    }
                    loops++;    //找出循环节个数
                }
            }
            System.out.println(n-loops);
        }
    }

}



