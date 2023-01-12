# Given an integer numRows, return the first numRows of Pascal's triangle.
# In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
# [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]] where numRows = 5 as input


# Quadratic Solution
class Solution:
    def generate(self, numRows: int) -> list[list[int]]:
        pascal = [[1]*(i+1) for i in range(numRows)]
        for i in range(numRows):
            for j in range(1, i):
                pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j]
        return pascal

# Linear Solution


class Solution:
    def generate(self, numRows: int) -> list[list[int]]:
        res = [[1]]
        for i in range(1, numRows):
            res += [list(map(lambda x, y: x+y, res[-1] + [0], [0] + res[-1]))]
        return res[:numRows]
