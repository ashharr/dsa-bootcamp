# 1. Two Sum
# Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
# You may assume that each input would have exactly one solution, and you may not use the same element twice.
# You can return the answer in any order.

# Example 1:
# Input: nums = [2,7,11,15], target = 9
# Output: [0,1]
# Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].


class Solution:
    def twoSum( nums: list[int], target: int) -> list[int]:
        # I. Brute Approach
        # for i in range(len(nums)):
        #     for j in range(len(nums)):
        #         if ( nums[i] + nums[j]) == target and i != j :
        #             return [i,j]

        # II. Hashmap Approach
        hashmap = {}
        for i in range(len(nums)):
            complement = target - nums[i]
            if complement in hashmap:
                return [i, hashmap[complement]]
            hashmap[nums[i]] = i