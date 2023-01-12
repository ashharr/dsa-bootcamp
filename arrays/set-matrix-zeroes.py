# Given an m x n integer matrix matrix, if an element is 0,
# set its entire row and column to 0's. You must do it in place.


class Solution:
    def setZeroes(self, matrix: list[list[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        r, c = set(), set()
        for i in range(len(matrix)):
            for j in range(len(matrix[i])):
                if (matrix[i][j] == 0):
                    r.add(i)
                    c.add(j)

        for i in range(len(matrix)):
            for j in range(len(matrix[i])):
                if ((i in r) or (j in c)):
                    matrix[i][j] = 0
