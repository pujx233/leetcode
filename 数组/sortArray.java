package 数组;

import java.util.Arrays;
import java.util.Random;

/**
 * 给你一个整数数组 nums，请你将该数组升序排列。
 * **/

public class sortArray {

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        Solution_4 solution = new Solution_4();
        int[] res = solution.sortArray(nums);
        System.out.println(Arrays.toString(res));
    }


    /**
     * 选择排序
     */

    static class Solution_1 {
        public int[] sortArray(int[] nums) {
            int len = nums.length;

            int minIndex = -1;

            for (int i = 0; i < len - 1; i++) {
                minIndex = i;
                for (int j = i + 1; j < len; j++) {
                    if (nums[minIndex] > nums[j]) {
                        minIndex = j;
                    }
                }

                int temp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = temp;
            }

            return nums;
        }
    }


    /**
     * 插入排序
     **/


    static class Solution_2 {
        public int[] sortArray(int[] nums) {
            int len = nums.length;
            // 循环不变量：将 nums[i] 插入到区间 [0, i) 使之成为有序数组
            for (int i = 1; i < len; i++) {
                // 先暂存这个元素，然后之前元素逐个后移，留出空位
                int temp = nums[i];
                int j = i;
                // 注意边界 j > 0
                while (j > 0 && nums[j - 1] > temp) {
                    nums[j] = nums[j - 1];
                    j--;
                }
                nums[j] = temp;
            }
            return nums;
        }
    }


    /**
     * 冒泡排序：超时
     */

    public static class Solution_3 {

        int temp;

        public int[] sortArray(int[] nums) {
            int len = nums.length;
            for (int i = 0; i < len - 1; i++) {
                int flag = 0;
                for (int j = 0; j < len - 1 - i; j++) {
                    if (nums[j] > nums[j + 1]) {
                        temp = nums[j];
                        nums[j] = nums[j + 1];
                        nums[j + 1] = temp;
                        flag = 1;//不是有序的，flags设置为1；
                    }

                }

                if (flag == 0)
                    return nums;

            }
            return nums;
        }

    }

    /**
     * 快速排序
     * 要注意随机取划分函数的主元
     * 注意快慢指针的使用
     */

    public static class Solution_4 {

        public int[] sortArray(int[] nums) {
            randomizedQuickSort(nums, 0, nums.length - 1);
            return nums;
        }

        public void randomizedQuickSort(int[] nums, int l, int r) {
            if (l < r) {
                int pos = randomizedPartition(nums, l, r);
                randomizedQuickSort(nums, l, pos - 1);
                randomizedQuickSort(nums, pos + 1, r);
            }
        }

        public int randomizedPartition(int[] nums, int l, int r) {
            int i = new Random().nextInt(r - l + 1) + l; // 随机选一个作为我们的主元
            swap(nums, r, i);
            return partition(nums, l, r);
        }

        public int partition(int[] nums, int l, int r) {
            int pivot = nums[r];
            int i = l - 1;
            for (int j = l; j <= r - 1; ++j) {
                if (nums[j] <= pivot) {
                    i = i + 1;
                    swap(nums, i, j);
                }
            }
            swap(nums, i + 1, r);
            return i + 1;
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }


    /**
     * 堆排序
     * len是长度-1
     */
    public static class Solution_5 {

        public int[] sortArray(int[] nums) {
            heapSort(nums);
            return nums;
        }

        public void heapSort(int[] nums) {
            int len = nums.length;
            buildMaxHeap(nums, len - 1);
            for (int i = len - 1; i >= 1; --i) {
                swap(nums, i, 0);
                len -= 1;
                maxHeapify(nums, 0, len - 1);
            }
        }

        public void maxHeapify(int[] nums, int i, int len) {
            for (; (i << 1) + 1 <= len; ) {
                int lson = (i << 1) + 1;
                int rson = (i << 1) + 2;
                int large;
                if (lson <= len && nums[lson] > nums[i]) {
                    large = lson;
                } else {
                    large = i;
                }
                if (rson <= len && nums[rson] > nums[large]) {
                    large = rson;
                }
                if (large != i) {
                    swap(nums, i, large);
                    i = large;
                } else {
                    break;
                }
            }
        }

        public void buildMaxHeap(int[] nums, int len) {
            for (int i = len / 2; i >= 0; --i) {
                maxHeapify(nums, i, len);
            }
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    /**
     * 归并排序
     */
    public static class Solution_6 {
        int[] tmp;

        public int[] sortArray(int[] nums) {
            tmp = new int[nums.length];
            mergeSort(nums, 0, nums.length - 1);
            return nums;
        }

        public void mergeSort(int[] nums, int l, int r) {
            if (l >= r) {
                return;
            }
            int mid = (l + r) >> 1;
            mergeSort(nums, l, mid);
            mergeSort(nums, mid + 1, r);

            int i = l, j = mid + 1;
            int cnt = 0;
            while (i <= mid && j <= r) {
                if (nums[i] <= nums[j]) {
                    tmp[cnt++] = nums[i++];
                } else {
                    tmp[cnt++] = nums[j++];
                }
            }
            while (i <= mid) {
                tmp[cnt++] = nums[i++];
            }
            while (j <= r) {
                tmp[cnt++] = nums[j++];
            }
            for (int k = 0; k < r - l + 1; ++k) {
                nums[k + l] = tmp[k];
            }
        }
    }

}