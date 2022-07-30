package �ַ���;

/**
 * ����һ���ַ����� chars ����ʹ�������㷨ѹ����
 *
 * ��һ�����ַ��� s ��ʼ������ chars �е�ÿ�� �����ظ��ַ� ��
 *
 * �����һ�鳤��Ϊ 1 �����ַ�׷�ӵ� s �С�
 * ������Ҫ�� s ׷���ַ��������һ��ĳ��ȡ�
 * ѹ����õ����ַ��� s ��Ӧ��ֱ�ӷ��� ����Ҫת�����ַ����� chars �С�
 * ��Ҫע����ǣ�����鳤��Ϊ 10 �� 10 ���ϣ����� chars �����лᱻ���Ϊ����ַ���
 *
 * ���� �޸������������ �����ظ�������³��ȡ�
 *
 * �������Ʋ�ʵ��һ��ֻʹ�ó�������ռ���㷨����������⡣
 * */


public class compressString {

    public static class Solution {
        public int compress(char[] chars) {
            int length = chars.length;
            if(length<=1){
                return length;
            }
            int count = 1;int write = 0;
            for(int i = 0;i<length;i++){
                char now = chars[i];
                char next = i == length-1? ' ':chars[i+1];
                if(now!=next){
                    chars[write] = now;
                    write++;
                    if(count==1){
                        continue;
                    }
                    int len = String.valueOf(count).length(); //�����count��λ��
                    for(int j = (int)Math.pow(10,len-1);j>0; count%=j,j/=10,write++){
                        chars[write] = (char) (count/j+48);
                    }
                    count = 1;
                }else {
                    count++;
                }
            }
            return write;
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        solution.compress("aaaaba".toCharArray());
    }
}

