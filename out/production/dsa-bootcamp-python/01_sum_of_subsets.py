# Subset Sums
# Stand out from the crowd. Prepare with Complete Interview Preparation  
# Given a list arr of N integers, print sums of all subsets in it.

# Example 1:

# Input:
# N = 2
# arr[] = {2, 3}
# Output:
# 0 2 3 5
# Explanation:
# When no elements is taken then Sum = 0.
# When only 2 is taken then Sum = 2.
# When only 3 is taken then Sum = 3.
# When element 2 and 3 are taken then 
# Sum = 2+3 = 5.

class Solution:
    def subsets(self, nums):
        def sub(nums, i, temp):
            # i crosses array index limit
            if i == len(nums):
                ans.append(sum(temp))
                return
            # we decide to not pick nums[i]
            sub(nums, i + 1, temp)
            # we decide to pick nums[i]
            sub(nums, i + 1, temp + [nums[i]])
        ans = []
        sub(nums, 0, [])
        return ans
