//        28. Find the Index of the First Occurrence in a String  | Easy
//        Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
//
//        Example 1:
//
//        Input: haystack = "sadbutsad", needle = "sad"
//        Output: 0
//        Explanation: "sad" occurs at index 0 and 6.
//        The first occurrence is at index 0, so we return 0.

package strings;

public class IndexOfFirstOccurence {
    // we will make use of rabin karp algorithm
    // modify it in a way that as soon as we get
    // a match we return index else we return -1
    public int strStr(String haystack, String needle) {
        double p=0, t=0;
        int i,j;
        String txt = haystack, pat = needle;
        int m=pat.length(), n=txt.length();
        if( n < m){
            return -1;
        }
        int count=0;
        // calculating hash value for pattern and first window in text
        for (i = 0; i < m; i++) {
            p = p +  (pat.charAt(i) * Math.pow(10,m-(i+1)));
            t = t +  (txt.charAt(i) * Math.pow(10,m-(i+1)));

        }
        for (i = 0; i <= (n-m); i++) {
            // comparing hash values
            if(p == t){
                // if hash value is same comparing strings
                for (j = 0; j < m; j++) {
                    if (txt.charAt(i + j) != pat.charAt(j))
                        break;
                }
                if(j == m){
                    return i;
                }
            }
            // rolling hash function till n-m
            if(i < (n-m)){
                // removing first character calculated value and adding new character value
                t =  (t - (txt.charAt(i) * Math.pow(10,m-1))) * 10 + txt.charAt(i+m);
            }
        }
        return -1;
    }
}
