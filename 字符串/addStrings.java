public class addStrings {

    public static void main(String []args){
        String num1 = "456";
        String num2 = "77";
        Solution solution = new Solution();
        System.out.println(solution.addStrings(num1,num2));
    }

    static class Solution {
        public String addStrings(String num1, String num2) {
            StringBuffer ans = new StringBuffer();
            int add = 0;
            int len1 = num1.length(),len2 = num2.length();

            while(len1>0 || len2>0 || add!=0){
                int add1 = len1 > 0 ? num1.charAt(len1-1) - '0' : 0;
                int add2 = len2 > 0 ? num2.charAt(len2-1) - '0' : 0;

                int temp = add1+add2+add;
                add = temp / 10;
                ans.append(temp%10);


                len1--;
                len2--;
            }

            ans.reverse();
            return ans.toString();
        }
    }
}
