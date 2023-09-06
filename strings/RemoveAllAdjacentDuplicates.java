//  1047. Remove All Adjacent Duplicates In String |  Easy

//        You are given a string s consisting of lowercase English letters. A duplicate removal consists of choosing two adjacent and equal letters and removing them.
//        We repeatedly make duplicate removals on s until we no longer can.
//        Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.
//
//        Example 1:
//
//        Input: s = "abbaca"
//        Output: "ca"


package strings;

public class RemoveAllAdjacentDuplicates {
    // I. Naive Solution
    public static String removeDuplicates(String s) {
        String res ="";
        if(!checkAdjacentDup(s)) return s;
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == s.charAt(i-1))
                if(i>1){
                    res = res.concat(s.substring(0,i-1) + s.substring(i+1));
//                    System.out.println(s.substring(i+1) +" "+res + " in1");
                    break;
                } else {
                    res = s.substring(i+1);
//                    System.out.println(res + " in2");
                    break;
                }
        }
//        System.out.println(res + " out");
        if(checkAdjacentDup(res)) res = removeDuplicates(res);
        return res;
    }

    public static boolean checkAdjacentDup(String s){
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == s.charAt(i-1)) return true;
        }
        return false;
    }

    // Better Solution : Using String Builder and stack approach

    // We will append each char to a StringBuilder
    // Once we meet a repeated character we deleted the
    // last char from SB

    public static String removeDuplicates2(String s){
        StringBuilder res = new StringBuilder();

        for (char c : s.toCharArray()) {
            int size = res.length();
            if( size > 0 && c == res.charAt(size - 1) ) res.deleteCharAt(size-1);
            else res.append(c);
        }
        return res.toString();
    }



    public static void main(String[] args) {
        String check = "abbaca";
        String check2 = "aabbcc";
        String check3 = "abcd";
        String check4 = "popo";


        System.out.println(removeDuplicates2(check));
        System.out.println(removeDuplicates2(check2));
        System.out.println(removeDuplicates2("azxxzy"));
        System.out.println(removeDuplicates2(check4));

    }
}
