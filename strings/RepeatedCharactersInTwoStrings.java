// Suppose we have 2 Strings {"Rahim", "Rahul"}
// Return set of  characters that are repeated in both the strings
// In this case {"r","a", "h"}

package strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RepeatedCharactersInTwoStrings {
    public static String repeatedCharacters (String s1, String s2){
        StringBuilder sb =new StringBuilder();
        Map<String, Integer> map = new HashMap<String, Integer>();
        String[] s = s1.split("");
        for (int i = 0; i < s.length; i++) {
            if(map.containsKey(s[i])) map.put(s[i], map.get(s) +1);
            else map.put(s[i], 1);
        }
//        for (Map.Entry<String,Integer> m:
//             map.entrySet()) {
//            System.out.println(m.getKey());
//            System.out.println(m.getValue());
//        }
        String[] ss = s2.split("");
        for (int i = 0; i < ss.length; i++) {
            if(map.containsKey(ss[i])) {
                sb.append(ss[i]);
                if( map.get(ss[i]) == 1) map.remove(ss[i]);
                else map.put(s[i], map.get(s)-1);
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println( repeatedCharacters("rahul", "raaaahim"));
    }
}
