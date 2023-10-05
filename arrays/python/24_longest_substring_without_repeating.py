# 3. Longest Substring Without Repeating Characters
# Given a string s, find the length of the longest 
# substring without repeating characters.
# 
# Example 1:
# Input: s = "abcabcbb"
# Output: 3
# Explanation: The answer is "abc", with the length of 3.

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        # res = 0
        # seen = set()
        # for l in range(len(s)):
        #     seen.clear()
        #     r = l
        #     while r < len(s):
        #         if s[r] in seen:
        #             break
        #         seen.add(s[r])
        #         r += 1
        #     res = max(res, r - l)
        # return res

        seen = {}
        l = 0
        output = 0
        for r in range(len(s)):
            # If s[r] not in seen, we can keep increasing the window size by moving right pointer

            if s[r] not in seen:
                output = max(output,r-l+1)

            # There are two cases if s[r] in seen:
            # case1: s[r] is not inside the current window its behind l, we can keep increase the window
            # case2: s[r] is inside the current window, we need to change the window by moving left pointer to
            #        seen[s[r]] + 1.

            else:
                if seen[s[r]] < l:
                    output = max(output,r-l+1)
                else:
                    l = seen[s[r]] + 1
            seen[s[r]] = r
        return output