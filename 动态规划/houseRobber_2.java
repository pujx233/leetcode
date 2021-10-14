package ��̬�滮;

/**
 * ����һ��רҵ��С͵���ƻ�͵���ؽֵķ��ݣ�ÿ�䷿�ڶ�����һ�����ֽ�
 * ����ط����еķ��ݶ� Χ��һȦ ������ζ�ŵ�һ�����ݺ����һ�������ǽ����ŵġ�
 * ͬʱ�����ڵķ���װ���໥��ͨ�ķ���ϵͳ������������ڵķ�����ͬһ���ϱ�С͵���룬ϵͳ���Զ����� ��
 *
 * ����һ������ÿ�����ݴ�Ž��ķǸ��������飬������ �ڲ���������װ�õ������ �������ܹ�͵�Ե�����߽�
 * */

public class houseRobber_2 {

    /**
     * ��β��ܱ�֤��һ�䷿�ݺ����һ�䷿�ݲ�ͬʱ͵���أ�
     * ���͵���˵�һ�䷿�ݣ�����͵�����һ�䷿�ݣ����͵�Է��ݵķ�Χ�ǵ�һ�䷿�ݵ����ڶ��䷿�ݣ�
     * ���͵�������һ�䷿�ݣ�����͵�Ե�һ�䷿�ݣ����͵�Է��ݵķ�Χ�ǵڶ��䷿�ݵ����һ�䷿�ݡ�
     * */

    class Solution {
        public int rob(int[] nums) {
            int length = nums.length;
            if (length == 1) {
                return nums[0];
            } else if (length == 2) {
                return Math.max(nums[0], nums[1]);
            }
            return Math.max(robRange(nums, 0, length - 2), robRange(nums, 1, length - 1));
        }

        public int robRange(int[] nums, int start, int end) {
            int first = nums[start], second = Math.max(nums[start], nums[start + 1]);
            for (int i = start + 2; i <= end; i++) {
                int temp = second;
                second = Math.max(first + nums[i], second);
                first = temp;
            }
            return second;
        }
    }
}
