class Solution:

    # I. Brute Force Solution | TC: O(n*n) SC: O(2n) 
    def trap1(height) -> int:
        res = 0
        for i in range(len(height)):
            max_left, max_right = 0,0
            for l in range(0,i):
                max_left = max(max_left, height[l])
            for r in range(i+1, len(height)):
                max_right = max(max_right, height[r])
            if min(max_right, max_left) - height[i] > 0:
                res += (min(max_right, max_left) - height[i])
            print(res)
        return res

    # II. Brute-Better Solution | TC: O(3n) SC: O(2n) 

    def trap2(height) -> int:
        res, max_yet = 0, 0
        prefix, suffix = [], []
        for l in range(len(height)):
            max_yet = max(max_yet, height[l])
            prefix.append(max_yet)
        max_yet = 0
        for r in range(len(height)-1,-1, -1):
            max_yet = max(max_yet, height[r])
            suffix.insert(0,max_yet)
        for i in range(len(height)):
            max_left, max_right = 0,0
            max_left = prefix[i]
            max_right = suffix[i]
            if min(max_right, max_left) - height[i] > 0:
                res += (min(max_right, max_left) - height[i])
        return res

    # III. Optimal Solution using 2 pointers | TC: O(n) SC: O(1) 
    def trap3( height) -> int:
        if len(height) <= 2: return 0
        n = len(height)
        maxLeft, maxRight = height[0], height[n-1]
        left, right = 1, n - 2
        ans = 0
        while left <= right:
            if maxLeft < maxRight:
                if height[left] > maxLeft:
                    maxLeft = height[left]
                else:
                    ans += maxLeft - height[left]
                left += 1
            else:
                if height[right] > maxRight:
                    maxRight = height[right]
                else:
                    ans += maxRight - height[right]
                right -= 1
        return ans

        
# Show the intuition behind trapping rainwater problem is we take 2 pointers left and right 
# initially when the left is lesser than the right that the value of left represents the tower of left and max left is the maximum Tower of left 
# now if the maximum left Tower is less than the maximum right Tower we will trace the left pointer forward and find the bigger Tower which is bigger than the left 
# if we found a tower which is better than the left we will change the value of Max_left but if we found a tower which is lesser than the max_left
# difference between max_left and the current height of the tower which was standing on that will give us the units of water that is going to be stored on that location. 

# Similarly if we have a max_right tower which is taller than the max_left then we trace the righ pointer which will find the tallest right tower and whenever we se
# a tower which is smaller than the max_right then the difference of current height  and max_right will give the trapped water in the current height.



    height = [0,1,0,2,1,0,1,3,2,1,2,1]
    print( trap3(height))
    