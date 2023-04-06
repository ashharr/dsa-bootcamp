//242. Valid Anagram | Easy
//
//        Given two strings s and t, return true if t is an anagram of s, and false otherwise.
//        An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
//        typically using all the original letters exactly once.
//
//        Example 1:
//
//        Input: s = "anagram", t = "nagaram"
//        Output: true


package strings;

import java.util.Arrays;
import java.util.HashMap;

public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {

        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();

        if(s.length() != t.length()) return false;

        for (Character c :
                s.toCharArray()) {

            if(!hm.containsKey(c)) {
                hm.put(c, 1);
            }
            else{
                hm.replace(c,hm.get(c)+1);
            }
        }


        for (int i = 0; i < t.length(); i++) {
            if(hm.containsKey(t.charAt(i)) && hm.get(t.charAt(i)) >= 1){
                hm.replace(t.charAt(i),hm.get(t.charAt(i))-1);
            } else {
                return false;
            }
        }
        for (int i:
             hm.values()) {
            if(i>0){
                return false;
            }
        }
        return true;
    }

    public static boolean isAnagram2(String s, String t)
    {
        if(s.length()!=t.length() ) return false;
        char s_ar[]=s.toCharArray();
        Arrays.sort(s_ar);
        String s_str=String.valueOf(s_ar);

        char t_ar[]=t.toCharArray();
        Arrays.sort(t_ar);
        String t_str=String.valueOf(t_ar);
        if(s_str.equals(t_str))
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.println(isAnagram2(s,t));
    }
}
