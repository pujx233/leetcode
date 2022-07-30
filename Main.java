// 本题为考试单行多行输入输出规范示例，无需提交，不计分。
import java.util.*;
public class Main {
    public static void main(String[] args) {
        List<String> student = new ArrayList<String>();
        HashMap<String,Student>stu = new HashMap<>();
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            String[] temp = in.nextLine().split(" ");
            String name = temp[0];

            if(temp[0].equals("0")){
                break;
            }

            if(!stu.containsKey(name)){
                Student tmp = new Student();
                stu.put(name,tmp);
            }

            if(temp[1].equals("Chinese")){
                int res = Integer.parseInt(temp[2]);

                stu.get(name).SetChinese(res);
            }
            else if(temp[1].equals("Mathematics")){
                stu.get(name).SetMath(Integer.parseInt(temp[2]));
            }
            else if(temp[1].equals("English")){
                stu.get(name).SetEnglish(Integer.parseInt(temp[2]));
            }

            if(stu.get(name).judge()){
                student.add(name);
            }
        }

        for(String ans: student){
            System.out.println(ans);
        }


    }
    public static class Student{
        int Chinese = 0;
        int Math = 0;
        int English = 0;

        public void SetChinese(int num){
            this.Chinese = num;
        }

        public void SetMath(int num){
            this.Math = num;
        }

        public void SetEnglish(int num){
            this.English = num;
        }

        public boolean judge(){
            return Chinese>80 && Math>80 && English>80;
        }
    }
}
               
               