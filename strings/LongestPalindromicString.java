package strings;

public class LongestPalindromicString {

    // I. Brute Approach | O(n^3)
    public static boolean isPalindrome(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        return s.equals(rev);
    }


    public static String longestPalindrome(String s) {
        int bestLen = 0;
        String bestS = "";
        int n = s.length();
        for (int L = 0; L < n; L++) {
            for (int R = L; R < n; R++) {
                int len = R - L + 1;
                String subs = s.substring(L, L + len);
                if (len > bestLen && isPalindrome(subs)) {
                    bestLen = len;
                    bestS = subs;
                }
            }
        }
        return bestS;
    }

//* L and R are two pointers that move in search of palindrome in the string s.
//* Their movement is same but starting position changes as the parity for the length of the palindrome being search is changed.
//* The starting point is same for odd parity.
//* When we search for even parity palindrome we change the R pointer by incrementing it by +1. Now when we move the pointers it will always be even length string.
//* The condition for while loop is such that both L and R are bounded within the string index and characters at L and R are same.
//
// # Complexity
//- Time complexity: O(n^2)
//
//- Space complexity: O(1)

    // II. Optimal Solution | O(n^2)
    static int low;
    static int maxLen;
    public static String longestPalindrome2(String s) {
        int len = s.length();
        if( len < 2){
            return s;
        }
        for (int i = 0; i < len - 1; i++) {
            // consider odd length
            searchPalindrome(s,i,i);
            // consider even length
            searchPalindrome(s,i,i+1);
        }
        return s.substring(low, low+maxLen);
    }

    public static void searchPalindrome(String s, int L, int R){
        // search for palindrome by starting from center L/R
        while(L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)){
            L--;
            R++;
        }
        if(maxLen < (R - L - 1)){
            low = L+1;
            maxLen = R-L-1;
        }
    }

    public static void main(String[] args) {
//        System.out.println(isPalindrome("mano"));

        System.out.println(longestPalindrome2("ajosmadamdbn"));

    }
}
