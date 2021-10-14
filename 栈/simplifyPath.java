package ջ;

import java.util.Stack;

/**
 * ����һ���ַ��� path ����ʾָ��ĳһ�ļ���Ŀ¼�� Unix ��� ����·�� ���� '/' ��ͷ�������㽫��ת��Ϊ���Ӽ��Ĺ淶·��
 * �� Unix �����ļ�ϵͳ�У�һ���㣨.����ʾ��ǰĿ¼�������⣬������ ��..�� ��ʾ��Ŀ¼�л�����һ����ָ��Ŀ¼��
 * ���߶������Ǹ������·������ɲ��֡�������������б�ܣ�����'//'��������Ϊ����б�� '/'
 * ���ڴ����⣬�κ�������ʽ�ĵ㣨���磬'...'��������Ϊ�ļ�/Ŀ¼����
 * */

public class simplifyPath {

    /**
     * 1.������Ҫ�������ջ,���Զ���һ������ջ;
     * 2.�Ȱ��ַ�����"/"Ϊ�ָ����ָ������,��ʱ������"·��"��""��"."��".."���������;
     * 3.��������,��s[i].equals("..")����ջ����ʱpop,��!s[i].equals("") && !s[i].equals(".") && !s[i].equals(".."),
     * ��s[i]��·����ջ;
     * 4.ջ��,����"/",ջ�ǿ�,��StringBuffer��һ�����ӷ��ؼ���
     * */

    static class Solution {


        public  String simplifyPath(String path) {
            String[] s = path.split("/");
            Stack<String> stack = new Stack<>();

            for (String value : s) {
                if (!stack.isEmpty() && value.equals("..")) {
                    stack.pop();
                } else if (!value.equals("") && !value.equals(".") && !value.equals(".."))
                    stack.push(value);
            }

            if(stack.isEmpty()){
                return "/";
            }

            StringBuilder res = new StringBuilder();
            for (String value : stack) {
                res.append("/").append(value);
            }

            return res.toString();
        }
    }

    public static void main(String[] args){
        String res = "/a/./b///../../c/";

        System.out.println(new Solution().simplifyPath(res));
    }

}
