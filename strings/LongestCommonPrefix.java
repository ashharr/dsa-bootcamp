//14. Longest Common Prefix | Easy
//
//        Write a function to find the longest common prefix string amongst an array of strings
//        If there is no common prefix, return an empty string "".
//
//        Example 1:
//
//        Input: strs = ["flower","flow","flight"]
//        Output: "fl"
//        Example 2:
//
//        Input: strs = ["dog","racecar","car"]
//        Output: ""
//        Explanation: There is no common prefix among the input strings.

package strings;

import java.util.Arrays;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int size = strs.length;

        /* if size is 0, return empty string */
        if (size == 0)
            return "";

        if (size == 1)
            return strs[0];

        /* sort the array of strings */
        Arrays.sort(strs);

        /* find the minimum length from first and last string */
        int end = Math.min(strs[0].length(), strs[size-1].length());

        /* find the common prefix between the first and
           last string */
        int i = 0;
        while (i < end && strs[0].charAt(i) == strs[size-1].charAt(i) )
            i++;

        String pre = strs[0].substring(0, i);
        return pre;
    }
}
