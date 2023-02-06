# Find minimum number of coins that make a given value
# Difficulty Level : Medium
 
# Given a value V, if we want to make a change for V cents, and we have an infinite supply of each of
# C = { C1, C2, .., Cm} valued coins, what is the minimum number of coins to make the change? 
# If it’s not possible to make a change, print -1.
# Examples:  
# Input: coins[] = {25, 10, 5}, V = 30
# Output: Minimum 2 coins required We can use one coin of 25 cents and one of 5 cents 

# Input: coins[] = {9, 6, 5, 1}, V = 11
# Output: Minimum 2 coins required We can use one coin of 6 cents and 1 coin of 5 cents


from os import *
from sys import *
from collections import *
from math import *

denominations = [1, 2, 5, 10, 20, 50, 100, 500, 1000]


def findMinimumCoins(amount):
	# Write your code here
    remainingAmount,res = amount, 0

    while remainingAmount != 0:
        for i in denominations:
            if i <= remainingAmount:
                coin = i
            else: break
        num = remainingAmount // coin
        res += num
        remainingAmount -= num * coin
    return res