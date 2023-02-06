# 235. Maximum Profit in Job Scheduling
# Hard
# We have n jobs, where every job is scheduled to be done from startTime[i] to endTime[i], obtaining a profit of profit[i].
# You're given the startTime, endTime and profit arrays, return the maximum profit you can take such that there are no 
# two jobs in the subset with overlapping time range.
# If you choose a job that ends at time X you will be able to start another job that starts at time X.
 
# Example 1:

# Input: startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
# Output: 120
# Explanation: The subset chosen is the first and fourth job. 
# Time range [1-3]+[3-6] , we get profit of 120 = 50 + 70.


class Solution:
    def jobScheduling(self, startTime: List[int], endTime: List[int], profit: List[int]) -> int:
        job = sorted(zip(startTime, endTime, profit), key = lambda x: x[1])

        dp_end_time = [0]
        dp_profit = [0]

        for start, end, profit in job:
            index = self.binarySearch(dp_end_time, start)
            last_profit = dp_profit[-1]
            curr_profit = dp_profit[index-1] + profit
            if curr_profit > last_profit:
                dp_end_time.append(end)
                dp_profit.append(curr_profit)
        return dp_profit[-1]

    def binarySearch(self, dp, target):
        left, right = 0, len(dp)

        while left < right:
            mid = (left +right)//2
            if dp[mid] <= target:
                left = mid + 1
            else:
                right = mid
        return left