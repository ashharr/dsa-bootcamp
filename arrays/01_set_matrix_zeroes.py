# Given an m x n integer matrix matrix, if an element is 0,
# set its entire row and column to 0's. You must do it in place.

# TC O(mn) | SC O(m+n)
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

# TC O(mn) | SC O(1)  ♥ Improved


class Solution:
    def setZeroes(self, matrix: list[list[int]]) -> None:

        m = len(matrix)
        n = len(matrix[0])

        first_row_has_zero = False
        first_col_has_zero = False

        # iterate through matrix to mark the zero row and cols
        for row in range(m):
            for col in range(n):
                if matrix[row][col] == 0:
                    if row == 0:
                        first_row_has_zero = True
                    if col == 0:
                        first_col_has_zero = True
                    matrix[row][0] = matrix[0][col] = 0

        # iterate through matrix to update the cell to be zero if it's in a zero row or col
        for row in range(1, m):
            for col in range(1, n):
                matrix[row][col] = 0 if matrix[0][col] == 0 or matrix[row][0] == 0 else matrix[row][col]

        # update the first row and col if they're zero
        if first_row_has_zero:
            for col in range(n):
                matrix[0][col] = 0

        if first_col_has_zero:
            for row in range(m):
                matrix[row][0] = 0
