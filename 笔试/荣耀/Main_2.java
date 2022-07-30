package ����.��ҫ;

import java.util.ArrayList;
import java.util.Scanner;

public class Main_2 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String command=input.nextLine();
        String[] sub_command = command.split("\\|");  //���������
        int sum_row=0;
        boolean error_flag=false;
        ArrayList<String> final_result=new ArrayList<>();
        for (int i = 0; i <sub_command.length ; i++) {
            //һ��һ����������
            String[] sub_command_array = sub_command[i].split(" ");
            int oper_row=Integer.parseInt(sub_command_array[0]); //�������к�
            if(sum_row==0){
                if(oper_row!=1||!sub_command_array[1].equals("i")){
                    error_flag=true;
                    break;
                }else{
                    sum_row++;
                    String str=getarrary(sub_command_array);
                    final_result.add(str);
                }
            }else{ //���������е�
                if(oper_row>sum_row){  //������кŴ������к�
                    error_flag=true;
                    break;
                }
                switch (sub_command_array[1]){
                    case "i":
                        final_result.add(oper_row-1,getarrary(sub_command_array));
                        sum_row++;
                        break;
                    case "a":
                        final_result.add(oper_row,getarrary(sub_command_array));
                        sum_row++;
                        break;
                    case "r":
                        final_result.set(oper_row-1,getarrary(sub_command_array));  //�滻
                        break;
                    case "d":
                        final_result.remove(oper_row-1);
                        sum_row--;
                        break;
                }
            }
        }
        //������
        if(error_flag==true) {
            System.out.println("error");
        }else {
            for (int i = 0; i <final_result.size() ; i++) {
                System.out.print(final_result.get(i));
            }
        }
    }
    //��ÿ�ε�����ת��Ϊ�ı�����
    public static String getarrary(String []sub_command_arrary){
        int length=sub_command_arrary.length;
        String str="";
        for (int j = 2; j <length ; j++) {
            str+=sub_command_arrary[j];
            str+=" ";
        }
        str+="\n";  //�������
        return str;
    }
}
