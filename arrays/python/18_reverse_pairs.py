# 493. Reverse Pairs
# Given an integer array nums, return the number of reverse pairs in the array.
# A reverse pair is a pair (i, j) where:

# 0 <= i < j < nums.length and
# nums[i] > 2 * nums[j].
 
# Example 1:
# Input: nums = [1,3,2,3,1]
# Output: 2
# Explanation: The reverse pairs are:
# (1, 4) --> nums[1] = 3, nums[4] = 1, 3 > 2 * 1
# (3, 4) --> nums[3] = 3, nums[4] = 1, 3 > 2 * 1


class Solution:
    # I. Brute Approach | O(n^2)
    # def reversePairs(self, nums: List[int]) -> int:     
    #     reversePairCount = 0
    #     for i in range(len(nums)):
    #         for j in range(i,len(nums)):
    #             if i < j and j < len(nums):
    #                 if( nums[i] > 2 * nums[j] ):
    #                     reversePairCount += 1
    #     return reversePairCount

    # II. MergeSort Approach | O(nLogn) + O(n)

    def reversePairs(self, nums: list[int]) -> int:
        def merge(low,mid,high):
            cnt=0
            j=mid+1
            for i in range(low,mid+1):
                while j<=high and nums[i]>2*(nums[j]):
                    j+=1
                cnt+=j-(mid+1)
            temp=[]
            left=low
            right=mid+1
            while left<=mid and right<=high:
                if nums[left]<=nums[right]:
                    temp.append(nums[left])
                    left+=1
                else:
                    temp.append(nums[right])
                    right+=1    
                    
            while left<=mid:
                temp.append(nums[left])
                left+=1
            while right<=high:
                temp.append(nums[right])
                right+=1
                
            for i in range(low,high+1):
                nums[i]=temp[i-low]
            return cnt
        def mergeSort(low,high):
            if low>=high:
                return 0
            mid=(low+high)//2
            inv=mergeSort(low,mid)
            inv+=mergeSort(mid+1,high)
            inv+=merge(low,mid,high)
            return inv
        
        return mergeSort(0,len(nums)-1)
        
            
                
            
        
            
            
            
                    
            