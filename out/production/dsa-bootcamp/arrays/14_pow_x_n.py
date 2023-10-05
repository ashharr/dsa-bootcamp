# 50. Pow(x, n)
# Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
# Hint: Negative power should also be calculated
# Example 1:
# Input: x = 2.00000, n = 10
# Output: 1024.00000


class Solution:
    def myPow( x: float, n: int) -> float:
        # I. Brute Approach
        # prod = x
        # if(n < 0):
        #     prod = 1
        #     for _ in range(-(n)):
        #         prod = prod / x
        #         print(prod)
        # elif(n == 0):
        #     return 1
        # else:
        #     for _ in range((n-1)):
        #         prod = prod * x
        # return prod

        # II. Binary Exponentiation
        if n < 0:
            n = -n
            x = 1/x
        ans, nn = 1, n
        while nn > 0:
            if nn % 2 == 1:
                ans *= x
            x *= x
            nn //= 2
        return ans
    
    print(myPow(x=99, n=10))

