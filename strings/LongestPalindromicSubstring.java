class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        
        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            // odd length
            int len1 = expandAroundCenter(s, i, i);
            //even length
            int len2 = expandAroundCenter(s, i, i+1);
            
            int maxLen = Math.max(len1, len2);

            if(maxLen > end -start)
            {
                start = i - (maxLen - 1)/2;
                end = i + maxLen/2;
            }
        }
            return s.substring(start, end);
        }


        
    }

    private static int expandAroundCenter(String s, int left, int right) {
        // TODO Auto-generated method stub
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right) ){
            left--;
            right++;
        }

        //return length of the palindrome
        
        return right - left -1;
    }
}