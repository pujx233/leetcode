package �ַ���;

/**
 * ���������汾�� version1 �� version2 ������Ƚ����ǡ�
 *
 * �汾����һ�������޶�����ɣ����޶�����һ�� '.' ���ӡ�ÿ���޶����ɶ�λ������ɣ����ܰ���ǰ���� ��
 * ÿ���汾�����ٰ���һ���ַ����޶��Ŵ����ұ�ţ��±�� 0 ��ʼ��
 * ����ߵ��޶����±�Ϊ 0 ����һ���޶����±�Ϊ 1 ���Դ����ơ����磬2.5.33 �� 0.1 ������Ч�İ汾�š�
 *
 * �Ƚϰ汾��ʱ���밴�����ҵ�˳�����αȽ����ǵ��޶��š��Ƚ��޶���ʱ��ֻ��Ƚ� �����κ�ǰ����������ֵ ��
 * Ҳ����˵���޶��� 1 ���޶��� 001 ��� ������汾��û��ָ��ĳ���±괦���޶��ţ�����޶�����Ϊ 0 ��
 * ���磬�汾 1.0 С�ڰ汾 1.1 ����Ϊ�����±�Ϊ 0 ���޶�����ͬ�����±�Ϊ 1 ���޶��ŷֱ�Ϊ 0 �� 1 ��0 < 1 ��
 *
 * ���ع������£�
 *
 * ��� version1 > version2 ���� 1��
 * ��� version1 < version2 ���� -1��
 * ����֮�ⷵ�� 0��
 * */

public class compareVersionNumbers {

    class Solution {
        public int compareVersion(String version1, String version2) {
            String[] s1 = version1.split("\\.");
            String[] s2 = version2.split("\\.");

            int n = s1.length,m = s2.length;
            int i = 0, j = 0;
            while (i<n||j<m){
                int a = 0,b = 0;
                if(i<n){
                    a = Integer.parseInt(s1[i]);
                    i++;
                }
                if(j<m){
                    b = Integer.parseInt(s2[j]);
                    j++;
                }
                if(a!=b){
                    return a>b?1:-1;
                }
            }

            return 1;
        }
    }
}
