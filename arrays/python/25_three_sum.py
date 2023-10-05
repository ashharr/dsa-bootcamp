# 15. 3Sum
# Medium
# Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
# Notice that the solution set must not contain duplicate triplets.


# Input: nums = [-1,0,1,2,-1,-4]
# Output: [[-1,-1,2],[-1,0,1]]
# Explanation: 
# nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
# nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
# nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
# The distinct triplets are [-1,0,1] and [-1,-1,2].


class Solution:

    # I. Brute Solution | O(n^3)
    def threeSum(nums):
        ans = []
        temp = []
        for i in range(len(nums) - 2):
            for j in range(i + 1, len(nums) - 1):
                for k in range(j + 1, len(nums)):
                    temp = []
                    if nums[i] + nums[j] + nums[k] == 0:
                        temp = [nums[i], nums[j], nums[k]]
                    if temp and temp not in ans:
                        ans.append(temp)
        unique_data = [list(x) for x in set(tuple(x) for x in ans)]

        return unique_data

    # II. Optimal Solution | O(n^2)
    def threeSum1(nums):
        res = []
        nums.sort()
        
        for left in range(len(nums) -2 ):
            if left > 0 and nums[left] == nums[left-1]:
                continue
            mid = left +1
            right = len(nums) -1
            while mid<right:
                curr_sum = nums[left] + nums[mid] + nums[right]
                if curr_sum < 0:
                    mid += 1
                elif curr_sum > 0:
                    right -= 1
                else:
                    res.append([nums[left], nums[mid], nums[right]])
                    while mid < right and nums[mid] == nums[mid+1]:
                        mid += 1
                    while right > mid and nums[right] == nums[right - 1]:
                        right -+ 1
                    mid += 1
                    right -= 1

        return res

