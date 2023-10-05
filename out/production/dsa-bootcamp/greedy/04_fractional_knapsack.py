# Fractional Knapsack
# Medium
# Given weights and values of N items, we need to put these items in a knapsack of capacity W to get the maximum total value in the knapsack.
# Note: Unlike 0/1 knapsack, you are allowed to break the item. 

# Example 1:
# Input:
# N = 3, W = 50
# values[] = {60,100,120}
# weight[] = {10,20,30}
# Output:
# 240.00
# Explanation:Total maximum value of item we can have is 240.00 from the given capacity of sack. 

#User function Template for python3

class Item:
    def __init__(self,val,w):
        self.value = val
        self.weight = w
        
class Solution:    
    #Function to get the maximum total value in the knapsack.
    def fractionalknapsack(self, W,arr,n):
        
        # code here
        arr.sort(key=lambda x: (x.value/x.weight), reverse=True)

        res = 0
        for item in arr:
            if item.weight <= W:
                res += item.value
                W -= item.weight
            else:
                res += item.value * W / item.weight
                break
        return res

#{ 
 # Driver Code Starts
#Initial Template for Python 3
import atexit
import io
import sys

class Item:
    def __init__(self,val,w):
        self.value = val
        self.weight = w
        
if __name__ == '__main__':
    test_cases = int(input())
    for cases in range(test_cases) :
        n,W = map(int,input().strip().split())
        info = list(map(int,input().strip().split()))
        arr = [Item(0,0) for i in range(n)]
        for i in range(n):
            arr[i].value = info[2*i]
            arr[i].weight = info[2*i+1]
            
        ob=Solution()
        print("%.2f" %ob.fractionalknapsack(W,arr,n))

# } Driver Code Ends