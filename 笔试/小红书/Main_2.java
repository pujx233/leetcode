package ����.С����;

/**
 * �����ʹ���������л������еĴ���
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
                hash.put(arr2[i],i);  //����Ԫ�������Ӧ�÷ŵ�λ��
            }

            boolean[] vis = new boolean[n];
            int loops = 0;
            for(int i = 0;i < n;i++){
                if(!vis[i]){
                    int j = i;
                    while(!vis[j]){
                        vis[j] = true;
                        j = hash.get(arr1[j]);   //Ѱ�Ҷ�Ӧλ���ϵ�����һ��Ӧ�÷ŵ�λ��
                    }
                    loops++;    //�ҳ�ѭ���ڸ���
                }
            }
            System.out.println(n-loops);
        }
    }

}



