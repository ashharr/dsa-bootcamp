# 485. Max Consecutive Ones
# Easy
# Given a binary array nums, return the maximum number of consecutive 1's in the array.

# Example 1:
# Input: nums = [1,1,0,1,1,1]
# Output: 3


from itertools import groupby


class Solution:
    def findMaxConsecutiveOnes(nums):
        count = 0
        max_count = 0
        for i in range(len(nums)):
            if nums[i] == 1:
                count += 1
            else: count = 0
            max_count = max(max_count, count)
        return max_count

    def findMaxConsecutiveOnes2(nums):
        return max(sum(g) for _, g in groupby(nums))
