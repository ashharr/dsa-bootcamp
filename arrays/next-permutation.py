class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        i = j = len(nums)-1
        while i > 0 and  nums[i] <= nums[i-1]:
            i -= 1
        if i == 0:   # nums are in descending order and no ascending position found
            nums.reverse()
            return 
        k = i - 1    # the last "ascending" position where are sequence starts
        while nums[j] <= nums[k]: 
            j -= 1   #
        nums[k], nums[j] = nums[j], nums[k]  
        l, r = k+1, len(nums)-1  # reverse the second part
        while l < r:
            nums[l], nums[r] = nums[r], nums[l]
            l +=1 ; r -= 1


        return nums