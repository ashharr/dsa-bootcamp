# Minimum Platforms
# Medium
# Stand out from the crowd. Prepare with Complete Interview Preparation  
# Given arrival and departure times of all trains that reach a railway station. Find the minimum number of platforms required for the railway station so that no train is kept waiting.
# Consider that all the trains arrive on the same day and leave on the same day. Arrival and departure time can never be the same for a train but we can have arrival time of one train equal to departure time of the other.
# At any given instance of time, same platform can not be used for both departure of a train and arrival of another train. In such cases, we need different platforms.

# Example 1:

# Input: n = 6 
# arr[] = {0900, 0940, 0950, 1100, 1500, 1800}
# dep[] = {0910, 1200, 1120, 1130, 1900, 2000}
# Output: 3
class Solution:    
    #Function to find the minimum number of platforms required at the
    #railway station such that no train waits.
    def minimumPlatform(self,n,arr,dep):
        # code here
        ans = 0
        # for i in range(n):
        #     count = 1
        #     for j in range(i+1,n):
        #         if((arr[i]>=arr[j] and arr[i]<=dep[j]) or (arr[j]>=arr[i] and arr[j]<=dep[i])):
        #             count += 1
        #     ans = max(count, ans)
        
        # return ans
        
        
        arr.sort()
        dep.sort()
    
        ans = 1
        count = 1
        i = 1
        j = 0
        while i < n and j < n:
            if arr[i] <= dep[j]:
                count += 1
                i += 1
            else:
                count -= 1
                j += 1
            ans = max(ans, count)
        return ans
#{ 
 # Driver Code Starts
#Initial Template for Python 3
import atexit
import io
import sys

#Contributed by : Nagendra Jha


if __name__ == '__main__':
    test_cases = int(input())
    for cases in range(test_cases) :
        n = int(input())
        arrival = list(map(int, input().strip().split()))
        departure = list(map(int, input().strip().split()))
        ob=Solution()
        print(ob.minimumPlatform(n,arrival,departure))
# } Driver Code Ends