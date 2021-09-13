package 数组;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * */

public class findFirstAndLastPositionOfElementInSortedArray {

    public static class Solution {
        public int[] searchRange(int[] nums, int target) {

            if(nums.length==0){
                return new int[]{-1,-1};
            }
            int left = findFirstPosition(nums,target);
            if(left == -1){
                return new int[]{-1,-1};
            }
            int right = findLastPosition(nums,target);

            return new int[]{left,right};
        }

        public int findFirstPosition(int[] nums,int target){
            int left = 0;int right = nums.length-1;

            while(left<right){
                int mid = (left+right)/2;
                if(nums[mid]==target){
                    right = mid;
                }
                else if(nums[mid]<target){
                    left = mid+1;
                }
                else if(nums[mid]>target){
                    right = mid;
                }

            }

            if(nums[left]==target){
                return left;
            }

            return -1;
        }

        public int findLastPosition(int[] nums,int target){
            int left = 0;
            int right = nums.length-1;

            while(left<right){
                int mid = (left+right+1)/2;
                if(nums[mid]==target){
                    left = mid;
                }
                else if(nums[mid]<target){
                    left = mid;
                }
                else if(nums[mid]>target){
                    right = mid-1;
                }

            }
            if(nums[right]==target){
                return right;
            }

            return -1;
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        solution.searchRange(new int[]{5,7,7,8,8,10},8);
    }

}
