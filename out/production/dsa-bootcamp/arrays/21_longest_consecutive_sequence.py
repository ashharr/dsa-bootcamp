# 128. Longest Consecutive Sequence
# Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
# You must write an algorithm that runs in O(n) time.

# Example 1:

# Input: nums = [100,4,200,1,3,2]
# Output: 4


class Solution:
    def longestConsecutive( nums: list[int]) -> int:
        nums.sort()
#         I. Brute Approach
#         curr_len = 1
#         max_len = 0
        
#         if(len(nums) == 1):
#             return 1
        
#         for i in range(len(nums) - 1):
#             j = i + 1
#             if nums[j] == nums[i] + 1:
#                 curr_len +=1
#             elif nums[j] == nums[i]:
#                 pass
#             else:
#                 curr_len = 1
#             max_len = max(curr_len, max_len)

#         return max_len
        
#       II. Hashset/Set Approach
        max_len = 0
        num_set = set(nums)
        for num in num_set:
            if num - 1 not in num_set:
                curr_num = num
                curr_len = 1
                while curr_num + 1 in num_set:
                    curr_num += 1
                    curr_len += 1
                max_len = max(max_len, curr_len)
        return max_len