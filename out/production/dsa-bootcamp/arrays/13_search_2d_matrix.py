# 74. Search a 2D Matrix
# You are given an m x n integer matrix matrix with the following two properties:
# Each row is sorted in non-decreasing order.
# The first integer of each row is greater than the last integer of the previous row.
# Given an integer target, return true if target is in matrix or false otherwise.
# You must write a solution in O(log(m * n)) time complexity.

# Example 1:
# Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
# Output: true


class Solution:
    def searchMatrix(self, matrix: list[list[int]], target: int) -> bool:
        if (len(matrix) == 0):
            return False

        n = len(matrix)
        m = len(matrix[0])

        low, high = 0, (n*m) - 1

        while low <= high:
            mid = low + (high - low)//2
            if (matrix[mid//m][mid % m] == target):
                return True
            if (matrix[mid//m][mid % m] < target):
                low = mid + 1
            else:
                high = mid - 1
        return False
