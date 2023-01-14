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
    def maxSubArray(nums: list[int]) -> int:
        local_max = global_max = nums[0]
        for i in range(1, len(nums)):
            local_max = max(local_max + nums[i], nums[i])
            global_max = max(local_max, global_max)
        return global_max
        
    print(maxSubArray(numbs))
