# 1) N meetings in one room
# Easy
# Stand out from the crowd. Prepare with Complete Interview Preparation  
# There is one meeting room in a firm. There are N meetings in the form of (start[i], end[i]) where start[i] is start time of meeting i and end[i] is finish time of meeting i.
# What is the maximum number of meetings that can be accommodated in the meeting room when only one meeting can be held in the meeting room at a particular time?
# Note: Start time of one chosen meeting can't be equal to the end time of the other chosen meeting.
# Example 1:

# Input:
# N = 6
# start[] = {1,3,0,5,8,5}
# end[] =  {2,4,6,7,9,9}
# Output: 
# 4
# Explanation:
# Maximum four meetings can be held with
# given start and end timings.
# The meetings are - (1, 2),(3, 4), (5,7) and (8,9)

class Solution:
    
    #Function to find the maximum number of meetings that can
    #be performed in a meeting room.
    def maximumMeetings(self,n,start,end):
        # code here
        meeting_list = []
        for i in range(n):
            meeting_list.append([start[i], end[i]])
        meeting_list.sort(key = lambda x:x[1])
        # print(meeting_list)
        count = 1
        limit = meeting_list[0][1]
        for i in range(n):
            if limit < meeting_list[i][0]:
                count += 1
                limit = meeting_list[i][1]
                # print(limit, True)
            # else: print(False)
        return count
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
        start = list(map(int,input().strip().split()))
        end = list(map(int,input().strip().split()))
        ob=Solution()
        print(ob.maximumMeetings(n,start,end))
# } Driver Code Ends