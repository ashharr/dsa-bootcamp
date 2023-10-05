package arrays.java;

import java.util.HashSet;

class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        HashSet s = new HashSet<>();
        for(int i: nums){
            s.add(i);
        }
        int maxLen = 0;
        for(int num: nums){
            if(!s.contains(num - 1)){
                int currNum = num;
                int currLen = 1;
                while( s.contains(currNum + 1)){
                    currNum += 1;
                    currLen += 1;
                }
                maxLen = Math.max(maxLen, currLen);
            }
        }
        return maxLen;
    }
}