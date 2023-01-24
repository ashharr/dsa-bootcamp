# Subarray with given XOR

# Problem Description 

# Given an array of integers A and an integer B.
# Find the total number of subarrays having bitwise XOR of all elements equals to B.

# Problem Constraints

# 1 <= length of the array <= 105

# 1 <= A[i], B <= 109

# Input Format
# The first argument given is the integer array A.
# The second argument given is integer B.

# Output Format

# Return the total number of subarrays having bitwise XOR equals to B.


# Example Input

# Input 1:

#  A = [4, 2, 2, 6, 4]
#  B = 6


class Solution:
    # @param A : list of integers
    # @param B : integer
    # @return an integer
    # def solve(self, A, B):
    #     count = 0
    #     for i in range(len(A)):
    #         xor = A[i]
    #         if(A[i] == B):
    #             count += 1
    #         for j in range(i+1,len(A)):
    #             xor ^= A[j]
    #             if xor == B:
    #                 count += 1
    #     return count
                    
                    
    def solve(self, A, B):
        visited = {}
        xorr = 0
        count = 0
        for i in range(len(A)):
            xorr ^= A[i]
            if xorr == B: 
                count += 1
            h = xorr ^ B
            if h in visited:
                count += visited[h]
            if xorr in visited:
                visited[xorr] += 1
            else:
                visited[xorr] = 1
        return count
            
