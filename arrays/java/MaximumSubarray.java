//53. Maximum Subarray |  Medium

//Given an integer array nums, find the subarray
//with the largest sum, and return its sum.

//Example 1:
//
//Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
//Output: 6
//Explanation: The subarray [4,-1,2,1] has the largest sum 6.
//Example 2:
//
//Input: nums = [1]
//Output: 1
//Explanation: The subarray [1] has the largest sum 1.

package arrays.java;

class MaximumSubarray {
    public static int maxSubArray(int[] nums) {
        int localMax = nums[0], globalMax = nums[0];
        for(int i = 1; i < nums.length; i++){
            localMax = Math.max(nums[i], localMax + nums[i]);
            globalMax = Math.max(globalMax, localMax);
        }
        return globalMax;
    }

    public static void main(String[] args) {

        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(arr));
    }
}