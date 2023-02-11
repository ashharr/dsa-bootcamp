# Largest subarray with 0 sum
# Given an array having both positive and negative integers. The task is to compute the length of the largest subarray with sum 0.

# Example 1:

# Input:
# N = 8
# A[] = {15,-2,2,-8,1,7,10,23}
# Output: 5


#Your task is to complete this function
#Your should return the required output
class Solution:
    def maxLen(self, n, arr):
        #Code here

        # I. Brute Approach
        # sumOfSub, max_len = 0, 0
        # for i in range(n):
        #     sumOfSub = 0
        #     for j in range(i,n):
        #         sumOfSub += arr[j]
        #         # print(j, sub, sumOfSub )
        #         if sumOfSub == 0:
        #             max_len = max(max_len, j - i +1)

        # return max_len
        

        mpp = {}
        maxi = 0
        sum = 0
        for i in range(n):
            sum += arr[i]
            if sum == 0:
                maxi = i + 1
            else:
                if sum in mpp:
                    maxi = max(maxi, i - mpp[sum])
                else:
                    mpp[sum] = i
        return maxi

# Driver Code Starts
if __name__=='__main__':
    t= int(input())
    for i in range(t):
        n = int(input())
        arr = list(map(int, input().strip().split()))
        ob = Solution()
        print(ob.maxLen(n ,arr))
