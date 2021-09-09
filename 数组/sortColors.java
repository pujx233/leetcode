package 数组;

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * */




public class sortColors {

    /**
     * 单指针
     * */

    class Solution {
        public void sortColors(int[] nums) {
            int n = nums.length;
            int ptr = 0;
            for (int i = 0; i < n; ++i) {
                if (nums[i] == 0) {
                    int temp = nums[i];
                    nums[i] = nums[ptr];
                    nums[ptr] = temp;
                    ++ptr;
                }
            }
            for (int i = ptr; i < n; ++i) {
                if (nums[i] == 1) {
                    int temp = nums[i];
                    nums[i] = nums[ptr];
                    nums[ptr] = temp;
                    ++ptr;
                }
            }
        }
    }

    /**
     * 双指针交换0和1
     * 用指针 p0交换0，p1交换1
     * */

    class Solution_1 {
        public void sortColors(int[] nums) {
            int n = nums.length;
            int p0 = 0, p1 = 0;
            for (int i = 0; i < n; ++i) {
                if (nums[i] == 1) {
                    int temp = nums[i];
                    nums[i] = nums[p1];
                    nums[p1] = temp;
                    ++p1;
                } else if (nums[i] == 0) {
                    int temp = nums[i];
                    nums[i] = nums[p0];
                    nums[p0] = temp;
                    if (p0 < p1) {
                        temp = nums[i];
                        nums[i] = nums[p1];
                        nums[p1] = temp;
                    }
                    ++p0;
                    ++p1;
                }
            }
        }
    }
}
