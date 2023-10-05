package arrays.java;// 70. Climbing Stairs | Easy
// You are climbing a staircase. It takes n steps to reach the top.
// Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

// Example 1:

// Input: n = 2
// Output: 2
// Explanation: There are two ways to climb to the top.
// 1. 1 step + 1 step
// 2. 2 steps

class ClimbingStairs {
    public int climbStairs(int n) {
        if(n<3) return n;

        // its basically a fibonacci problem
        // the solution for the last two steps is being added to 
        // get the current step answer
        // since we already know answer for first 2 steps
        // we loop till n to get answer for nth step
        // TC: O(n) | SC: O(1) {can also be O(n) if you maintain array of solutions}

        int step1 = 1;
        int step2 = 2;
        int currentStep = 0;

        for(int i =2; i < n; i++){
            currentStep = step1 + step2;
            step1 = step2;
            step2 = currentStep;
        }
        return currentStep;
    }
}