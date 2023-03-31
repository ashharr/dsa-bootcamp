//771. Jewels and Stones | Easy
//
//        You're given strings jewels representing the types of stones
//        that are jewels, and stones representing the stones you have.
//        Each character in stones is a type of stone you have. You want to
//        know how many of the stones you have are also jewels.
//        Letters are case sensitive, so "a" is considered a different type of stone from "A".
//        Example 1:
//        Input: jewels = "aA", stones = "aAAbbbb"
//        Output: 3
//        Example 2:
//        Input: jewels = "z", stones = "ZZ"
//        Output: 0

package strings;

import java.util.*;

public class JewelsAndStones {

    public static int numJewelsInStones(String jewels, String stones) {
        int res = 0;
        Set setJ = new HashSet();
        for (char j: jewels.toCharArray())
            setJ.add(j);
        for (char s: stones.toCharArray())
            if (setJ.contains(s)) res++;
        return res;
    }


    public static void main(String[] args) {
        System.out.println(numJewelsInStones("aA", "aAAbbbb"));
    }
}
