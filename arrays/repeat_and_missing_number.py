# Repeat and Missing Number Array
# You are given a read only array of n integers from 1 to n.
# Each integer appears exactly once except A which appears twice and B which is missing.
# Return A and B.
# Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory
# Note that in your output A should precede B.

# Example:
# Input:[3 1 2 5 3] 
# Output:[3, 4] 
# A = 3, B = 4

class Solution:
    # @param A : tuple of integers
    # @return a list of integers
    def repeatedNumber(self, A):
        length = len(A)
        S = (length * (length + 1)) // 2
        P = ((length * (length + 1) * 
                     (2 * length + 1)) // 6)
      
        missingNumber, repeating = 0, 0
      
        for i in range(len(A)):
            S -= A[i]
            P -= A[i] * A[i]
          
        missingNumber = (S + P // S) // 2
        repeating = missingNumber - S
        ans = []
        ans.append(repeating)
        ans.append(missingNumber)
      
        return ans