package 数组; /**
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 *
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * */


import java.util.Arrays;
import java.util.Random;

/**
 * 快排、归并之类的默写用
 * */

public class findKthLargest {

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        Solution solution = new Solution();
        int res = solution.findKthLargest(nums,2);

        System.out.println(res);
    }

    static class Solution {
        public int findKthLargest(int[] nums, int k) {

            randomizedQuickSort(nums,0,nums.length-1);
            System.out.println(Arrays.toString(nums));
            return nums[nums.length-k];
        }
        public void randomizedQuickSort(int []nums,int l,int r){
            if(l<r){
                int pos = randomizedPartition(nums,l,r);
                randomizedQuickSort(nums,l,pos-1);
                randomizedQuickSort(nums,pos+1,r);
            }
        }

        public int randomizedPartition(int[] nums, int l, int r) {
            int i = new Random().nextInt(r - l + 1) + l; // 随机选一个作为我们的主元
            swap(nums, r, i);
            return partition(nums, l, r);
        }

        public int partition(int []nums,int l,int r){
            int pivot = nums[r];
            int i = l-1;
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
}
