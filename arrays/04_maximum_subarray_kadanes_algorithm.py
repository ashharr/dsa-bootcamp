# Maximum Subarray
# Given an integer array nums, find the 
# subarray with the largest sum, and return its sum.

# Example 1:

# Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
# Output: 6
# Explanation: The subarray [4,-1,2,1] has the largest sum 6
nums = [-2,1,-3,4,-1,2,1,-5,4]

class Solution:
    numbs = [-2,1,-3,4,-1,2,1,-5,4]
    # TC: O(n) 
    # SC: O(1)

    #a cubic solution
    # maxsofar = 0;
    # n = len(numbs) 
    # for i in range(0,n):
    #     for j in range(i,n):
    #         sum = 0;
    #         for k in range(i,j+1):
    #             sum += numbs[k]
    #             if (sum > maxsofar):
    #                 maxsofar = sum
    # print(maxsofar)

    # Kadane's algorithm is an efficient method for finding the largest sum of any contiguous subarray 
    # in an array of integers. It starts by initializing a variable, called the "current sum," to the 
    # first element of the array. It then iterates through the rest of the array, comparing the current 
    # element to the current sum plus that element. If the current element is larger, the current sum is 
    # set to that element. If the current sum plus the current element is larger, the current sum is updated 
    # to the current sum plus the current element. The algorithm keeps track of the largest sum it has seen 
    # so far, and returns that sum at the end. The time complexity of this algorithm is O(n) and this algorithm 
    # is a dynamic programing solution for finding the maximum subarray problem


    def maxSubArray(nums: list[int]) -> int:
        local_max = global_max = nums[0]
        for i in range(1, len(nums)):
            local_max = max(local_max + nums[i], nums[i])
            global_max = max(local_max, global_max)
        return global_max
        
    print(maxSubArray(numbs))
