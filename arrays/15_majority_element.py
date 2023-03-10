class Solution:
    def majorityElement(self, nums: list[int]) -> int:
        
        # I. Brute Approach (Exceeds Time Limit)
        # max_count = 0
        # element_freq = 0
        # for i in range(len(nums)):
        #     count = 0
        #     for j in range(len(nums)):
        #         if nums[i] == nums[j]:
        #             count += 1
        #     if( count > max_count  ):
        #         max_count = count
        #         element_freq = nums[i]


        # return element_freq

        # II. Hashmap Approach 
        # Hash = dict()
        # n = len(nums)
        # for i in range(n):
        #     Hash = dict()
        # for i in range(n):
        #     if arr[i] in Hash.keys():
        #         Hash[arr[i]] += 1
        #     else:
        #         Hash[arr[i]] = 1
  
        # # find the max frequency
        # max_count = 0
        # res = -1
        # for i in Hash: 
        #     if (max_count < Hash[i]): 
        #         res = i
        #         max_count = Hash[i]
        # return res

        # III. Moore's Voting Algorithm
        
        count, candidate = 0, 0
        for num in nums:
            if count == 0:
                candidate,count = num,1
            elif candidate == num:
                count += 1
            else:
                count -= 1
        return candidate

        #  This algorithm works by maintaining a current candidate for the majority element
        #  and a count of the occurrences of that element. It iterates through the list of 
        #  elements, updating the candidate and count based on the current element. If the 
        #  count reaches 0, the current element becomes the new candidate. At the end of 
        #  the iteration, the candidate is returned as the majority element.

        