// 1. Two Sum

// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

// You may assume that each input would have exactly one solution, and you may not use the same element twice.

// You can return the answer in any order.

// Example 1:

// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]
// Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].



package arrays.java;

import java.util.HashMap;

public class TwoSum {
    
    public static int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(map.containsKey(complement)){
                return new int[] {i, map.get(complement)};
            }
            map.put(nums[i], i);
        }
        
        return new int[] {0,0};
    }

    public static void main(String[] args) {
        int[] arr = {7, 8, 9, 3, 2, 1};
        System.out.println(twoSum(arr, 9)[0] +" "+ twoSum(arr, 9)[1]);
        
    }
}
