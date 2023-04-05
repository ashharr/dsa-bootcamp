//        686. Repeated String Match | Medium
//
//        Given two strings a and b, return the minimum number of times you should repeat string a so that string b is a substring of it.
//        If it is impossible for b​​​​​​ to be a substring of a after repeating it, return -1.
//        Notice: string "abc" repeated 0 times is "", repeated 1 time is "abc" and repeated 2 times is "abcabc".
//
//        Example 1:
//        Input: a = "abcd", b = "cdabcdab"
//        Output: 3
//        Explanation: We return 3 because by repeating a three times "abcdabcdabcd", b is a substring of it.
//
package strings;

public class RabinKarp {
    public static int repeatedStringMatch(String a, String b) {
        StringBuilder s = new StringBuilder(a);
        StringBuilder s2 = new StringBuilder(a);

        StringBuilder p = new StringBuilder(b);
        int resCount = 0, i;


        for (i = 0; i <= p.length(); i++) {
            if (i != 0) {
                s.append(s2);
            }
            // resCount is number of times pattern is repeated
            resCount = rabinKarp(p.toString(),s.toString(),101);
            // System.out.println("iteration "+i+" rabinKarp("+p.toString()+", " + s.toString()+")="+resCount);
            if(resCount>0){
             break;
            }
        }
        if(resCount>0) {
            return i + 1;
        }
        else return -1;
    }

    public static int rabinKarp(String pat, String txt, int q){
        int p=0, t=0;
        int i,j;
        int m=pat.length(), n=txt.length();
        if( n < m){
            return 0;
        }
        int count=0;
        // calculating hash value for pattern and first window in text
        for (i = 0; i < m; i++) {
            p = p + (int) (pat.charAt(i) * Math.pow(10,m-(i+1)));
            t = t + (int) (txt.charAt(i) * Math.pow(10,m-(i+1)));

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
                    count+=1;
                }
            }
            // rolling hash function till n-m
            if(i < (n-m)){
                // removing first character calculated value and adding new character value
                t = (int) (t - (txt.charAt(i) * Math.pow(10,m-1))) * 10 + txt.charAt(i+m);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "abc";
        String b = "cabcabca";

//        int x = rabinKarp("dba", "ccaccadba", 101);
        System.out.println(repeatedStringMatch(s,b));

//        System.out.println(rabinKarp("cabcabca","abcabcabcabc",101));
    }


}
