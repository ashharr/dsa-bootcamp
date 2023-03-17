import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;

class MaxSlidingWindow {
    // I. Naive Approach | O(n^2)
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(k == 1 && nums.length == 1) return nums;
        int currMax = -10000;
        int[] maxRes = new int[nums.length- (k-1)];
        for (int i = 0; i < nums.length - (k-1); i++) {
            maxRes[i] = maxOfSlice(nums,i, i+k);
        }
        return maxRes;
    }
    // II. Optimal Approach using Deque | O(2n)
    public static int[] maxSlidingWindow2(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        int ri = 0;
        Deque<Integer> deq = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            // remove all numbers out of range of k
            if(!deq.isEmpty() && deq.peek() == i-k){
                deq.poll();
            }

            // loop and remove all lesser than current element
            // intuition is that we dont need smaller elements
            // if we have a bigger one then we set aas first
            while(!deq.isEmpty() && nums[deq.peekLast()] < nums[i]){
                deq.pollLast();
            }
            deq.offer(i);
            // store the result (current max) i.e. front of deq
            if(i >= k-1) {
                res[ri++] = nums[deq.peek()];
            }
        }
        return res;
    }

    public static int maxOfSlice(int[] nums, int i, int j){
        int maxNow = 0;
        for (int k = i; k < j; k++) {
            maxNow = Math.max(maxNow, nums[k]);
            System.out.print(nums[k] + " ");
        }
        System.out.println();
        return maxNow;
    }
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] max = new int[nums.length];
        max = maxSlidingWindow2(nums,3);
        System.out.println(Arrays.toString(max));
    }
}