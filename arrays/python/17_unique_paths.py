# 62. Unique Paths
# There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). 
# The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either 
# down or right at any point in time.
# Given the two integers m and n, return the number of possible unique paths that the robot can take to reach 
# the bottom-right corner. The test cases are generated so that the answer will be less than or equal to 2 * 109.

# Example 1:

# Input: m = 3, n = 7
# Output: 28
# Example 2:

# Input: m = 3, n = 2
# Output: 3
# Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
# 1. Right -> Down -> Down
# 2. Down -> Down -> Right
# 3. Down -> Right -> Down


class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        # I. Recursive | O(2^n)
        # def countPaths(i,j,m,n):
        #     if (i,j) == (m-1,n-1):
        #         return 1
        #     elif i >= m or j >= n:
        #         return 0
        #     else:
        #         return countPaths(i+1,j,m,n) + countPaths(i,j+1,m,n)
        # return countPaths(0,0,m,n) 

        # II. Dynamic Programming in Recursive | O(n*m)
        # def countPaths( i, j, n, m, dp):
        #     if i == n-1 and j == m-1:
        #         return 1
        #     if i >= n or j >= m:
        #         return 0
        #     if dp[i][j] != -1:
        #         return dp[i][j]
        #     else:
        #         dp[i][j] = countPaths(i+1, j, n, m, dp) + countPaths(i, j+1, n, m, dp)
        #         return dp[i][j]
        # dp = [[-1 for _ in range(n)] for _ in range(m)]
        # num = countPaths(0, 0, m, n, dp)
        # if m == 1 and n == 1:
        #     return num
        # return dp[0][0]

        # III. Combinatoric Solution (N C m or N C n) | O(m-1)
        N = n + m - 2
        r = m - 1
        res = 1
        for i in range(1, r+1):
            res = res * (N - r + i) / i # N C R

        return int(res)

        