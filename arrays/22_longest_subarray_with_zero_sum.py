class Solution:
    def maxLen(self, n, arr):
        #Code here
        hashmap = {}
        cur_sum, max_len = 0,0
        for i in range(n):
            cur_sum += arr[i]
            if cur_sum == 0:
                max_len = i+1
            elif cur_sum in hashmap:
                max_len = max(max_len, i - hashmap[cur_sum])
            else: hashmap[cur_sum] = i
        return max_len