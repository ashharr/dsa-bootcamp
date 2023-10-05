# 18. 4Sum
# Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

# 0 <= a, b, c, d < n
# a, b, c, and d are distinct.
# nums[a] + nums[b] + nums[c] + nums[d] == target
# You may return the answer in any order.

# Example 1:
# Input: nums = [1,0,-1,0,-2,2], target = 0
# Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

class Solution:
    def fourSum( num: list[int], target: int) -> list[list[int]]:
        res = []
        if not num:
            return res
        n = len(num)
        num.sort()
        for i in range(n):
            target_3 = target - num[i]
            for j in range(i+1, n):
                target_2 = target_3 - num[j]
                front, back = j+1, n-1
                while front < back:
                    two_sum = num[front] + num[back]
                    if two_sum < target_2:
                        front += 1
                    elif two_sum > target_2:
                        back -= 1
                    else:
                        quadruplet = [num[i], num[j], num[front], num[back]]
                        if quadruplet not in res:
                            res.append(quadruplet)
                        while front < back and num[front] == quadruplet[2]:
                            front += 1
                        while front < back and num[back] == quadruplet[3]:
                            back -= 1
                while j+1 < n and num[j+1] == num[j]:
                    j += 1
            while i+1 < n and num[i+1] == num[i]:
                i += 1
        return res
