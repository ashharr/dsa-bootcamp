# 229. Majority Element II
# Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

# Example 1:
# Input: nums = [3,2,3]
# Output: [3]

# Example 2:

# Input: nums = [1,2]
# Output: [1,2]


class Solution:
    def majorityElement(nums: list[int]) -> list[int]:

        # I. Brute Approach
        # count, max_count = 0,0
        # majority_element = set()
        # for i in range(len(nums)):
        #     count = 0
        #     for j in range(len(nums)):
        #         if(nums[i]== nums[j]):
        #             count += 1
        #     if(count > len(nums)//3):
        #         majority_element.add(nums[i])
        # return list(majority_element)

        # II. HashMap Brute-better
        hash_dict = {}
        n = len(nums)
        ans = []

        for i in nums:
            if i in hash_dict:
                hash_dict[i] += 1
            else:
                hash_dict[i] = 1

        for i in hash_dict:
            if hash_dict[i] > n/3:
                ans.append(i)

        # III. Boyer Moore's Voting Algorithm for n/3
        num1, num2 = -1, -1   # Since it is not guaranteed majority will be present
        count1, count2 = 0, 0
        for num in nums:
            if num1 == num:
                count1 += 1
            elif num2 == num:
                count2 += 1
            elif count1 == 0:
                num1 = num
                count1 = 1
            elif count2 == 0:
                num2 = num
                count2 = 1
            else:
                count1 -= 1
                count2 -= 1
        count1, count2 = 0, 0
        for num in nums:
            if (num1 == num):
                count1 += 1
            elif (num2 == num):
                count2 += 1
        ans = []
        if count1 > len(nums) // 3:
            ans.append(num1)

        if count2 > len(nums) // 3:
            ans.append(num2)

        return ans
