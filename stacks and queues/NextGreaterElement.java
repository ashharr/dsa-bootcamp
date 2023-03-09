//    Next Greater Element II
//    Medium
//
//    Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.
//    The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.
//    Input: nums = [1,2,3,4,3]
//    Output: [2,3,4,-1,4]

import java.util.Stack;

class NextGreaterElement {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack();
        int n = nums.length;
        int[] nge = new int[n];
        for(int i = 2*n - 1; i >=0; i--){

            while( !stack.isEmpty() && stack.peek() <= nums[i%n]){
                stack.pop();
            }

            if(i<n){
                if(!stack.isEmpty()) nge[i] = stack.peek();
                else nge[i] = -1;
            }
            stack.push(nums[i%n]);
        }
        return nge;
    }
}