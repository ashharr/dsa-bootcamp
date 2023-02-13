import java.util.ArrayList;
import java.util.List;

class PalindromePartitioning {
    public static List<List<String>> partition(String s) {
        List<String> path = new ArrayList<>();
        List<List<String>> ans =new ArrayList<>();
        sub(0,s,path, ans);
        return ans;
    }
    public static void sub(int index, String s, List<String> path, List<List<String>> ans){
        if( index == s.length()){
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int i = index; i < s.length();++i){
            if(isPalindrome(s, index, i)){
                path.add(s.substring(index,i+1));
                sub(i+1,s,path,ans);
                path.remove(path.size()-1);
            }
        }
    }
    public static boolean isPalindrome(String s,int start,int end){
        while(start <= end){
            if(s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
    public static void main(String args[]) {
        String s = "aabb";
        List <List< String >> ans = partition(s);
        int n = ans.size();
        System.out.println("The Palindromic partitions are :-");
        System.out.print(" [ ");
        for (int i = 0; i < ans.size(); i++) {
            System.out.print("[ ");
            for (int j = 0; j < ans.get(i).size(); j++) {
                System.out.print(ans.get(i).get(j) + " ");
            }
            System.out.print("] ");
        }
        System.out.print("]");


    }
}