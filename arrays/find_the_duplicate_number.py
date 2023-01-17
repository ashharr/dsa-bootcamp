# 287. Find the Duplicate Number
# Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
# There is only one repeated number in nums, return this repeated number.
# You must solve the problem without modifying the array nums and uses only constant extra space.

# Example 1:
# Input: nums = [1,3,4,2,2]
# Output: 2


class Solution:
    def findDuplicate(self, nums: List[int]) -> int:

        # Assuming the Array is a Linked List with a cycle
        # Using Floyds Hare and Tortoise algorithm to solve it

        slow = fast = nums[0]
        while True:
            slow, fast = nums[slow], nums[nums[fast]]
            # if hare and tortoise meet and they are bound to meet
            if slow == fast:
                break
        # sending hare back to the start to get the number 
        fast = nums[0]
        # this time hare will move by one like tortoise
        
        while slow != fast:
            slow, fast = nums[slow], nums[fast]
        return fast