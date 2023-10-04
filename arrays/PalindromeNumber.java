// 9. Palindrome Number
// Easy
// Given an integer x, return true if x is a 
// palindrome
// , and false otherwise.
 
// Example 1:

// Input: x = 121
// Output: true
// Explanation: 121 reads as 121 from left to right and from right to left

class PalindromeNumber
 {
    public static boolean isPalindrome(int x) {
        String s = Integer.valueOf(x).toString();
        // System.out.println(s);
        
		for( int i=0,j=s.length()-1 ; i < j ; i++, j-- ) {
			if(s.charAt(i) != s.charAt(j)) {
				return false;
			}
		}

        return true;
    }

	public static void main(String arg[]) {
		System.out.println(isPalindrome(121121));
		System.out.println(isPalindrome(121));
		System.out.println(isPalindrome(-121121));
		System.out.println(isPalindrome(1000));
	}
}
