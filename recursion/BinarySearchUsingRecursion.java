import java.util.ArrayList;
import java.util.List;

public class BinarySearchUsingRecursion {
    public static void main(String[] args) {
        // write a function that takes in a number and prints it
        // print first 5 numbers: 1 2 3 4 5
        int ans = fib(10);
//       System.out.println(ans);

        int[] intArray = new int[]{ 1,2,3,4,5,6,7,8,9,10 };
        int index = binarySearch(intArray,0, intArray.length-1,10);
//        System.out.println(index);
//        System.out.println(factorial(5));
//        System.out.println(sumOfDigits(4556));
//        System.out.println(countSteps(8, 0));
//        System.out.println(skip("abbcad",'a'));
        System.out.println(subseq("","abc"));

    }

    static int fib(int n) {
        if (n == 0 || n ==1 ){
            return n;
        }
        return fib(n-1) + fib(n-2);
    }
    static int binarySearch(int[] arr,int left,int right, int x) {
        int mid = (left + right) /2;
        if (left > right){
            return -1;
        }
        if (arr[mid] == x) {
            return mid;
        }
        else  if( x >= arr[mid]){
            return binarySearch(arr, mid+1, right, x);
        }
        return binarySearch(arr, left, mid, x);

    }
    public static int factorial(int n) {
        if(n == 1) {
            return 1;
        }
        return n * factorial(n-1); 
        
    }
    public static int sumOfDigits( int n) {
        if(n == 0) {
            return 0;
        }
        return n%10 + sumOfDigits((int)n/10);
    }

    public static int countSteps( int num, int c){
        if(num==0){
            return c;
        }
        if(num % 2 == 0){
            return countSteps((int)num/2, c+1);
        }
        return countSteps(num - 1, c+1);
    }

    public static String skip(String up, char skipChar) {
        if(up.isEmpty()){
            return "";
        }
        char ch = up.charAt(0);
        if(ch == skipChar){
            return skip(up.substring(1), skipChar);
        }
        else {
            return  ch + skip(up.substring(1), skipChar);
        }

    }
    static ArrayList<String> subseq(String p, String up) {
        if(up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> left = subseq(p+ch, up.substring(1));
        ArrayList<String> right = subseq(p, up.substring(1));

        left.addAll(right);
        return left;
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = candidates.length;
        void dfs(List<Integer> cur, int curSum, int index){
            if(curSum > target){
                return;
            }
            if(curSum == target) {
                ans.add(new ArrayList<>(cur));
                return;
            }
            for(i=0; i<candidates.length; i++) {
                dfs(cur.add(candidates[i]), curSum + candidates[i], i, target, ans);
                cur.remove(cur.size() - 1);
            }
        }
        dfs(new ArrayList<>(), 0, 0);
        return ans;
    }
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> ans = new ArrayList<>();
            int n = candidates.length;
            void dfs(List<Integer> cur, int curSum, int idx) {
                if (curSum > target) return;
                if (curSum == target) {
                    ans.add(new ArrayList<>(cur));
                    return;
                }
                for (int i = idx; i < n; i++) {
                    cur.add(candidates[i]);
                    dfs(cur, curSum + candidates[i], i);
                    cur.remove(cur.size() - 1);
                }
            }
            dfs(new ArrayList<>(), 0, 0);
            return ans;
        }
    }


}
