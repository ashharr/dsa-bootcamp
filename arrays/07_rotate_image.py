# 48. Rotate Image
# You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
# You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
# DO NOT allocate another 2D matrix and do the rotation

# Example
# Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
# Output: [[7,4,1],[8,5,2],[9,6,3]]

class Solution:
    def rotate(matrix: list[list[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """

        n = len(matrix)
        # Step 1: Transpose the Matrix
        for i in range(n):
            for j in range(i):
                matrix[i][j], matrix[j][i] = matrix[j][i], matrix[i][j]
        # matrix = [[1,4,7],[2,5,8],[3,6,9]]

        # Step 2: Reverse all lists to get rotation matrix
        for i in range(n):
            matrix[i].reverse()
            # by not using library function
            # l, r = 0, len(matrix[i]) -1
            # while (l < r):
            #     matrix[i][l] ,matrix[i][r] = matrix[i][r], matrix[i][l] 
            #     l += 1
            #     r -= 1
    matrix = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
    rotate(matrix)
    print(matrix)
