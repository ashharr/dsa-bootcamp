//Game of Two Stacks | Medium | Hackerrank
//Alexa has two stacks of non-negative integers, stack  and stack  where index  denotes the top of the stack. Alexa challenges Nick to play the following game:
//
//        In each move, Nick can remove one integer from the top of either stack  or stack .
//        Nick keeps a running sum of the integers he removes from the two stacks.
//        Nick is disqualified from the game if, at any point, his running sum becomes greater than some integer  given at the beginning of the game.
//        Nick's final score is the total number of integers he has removed from the two stacks.
//        Given , , and  for  games, find the maximum possible score Nick can achieve.
//        Example
//        The maximum number of values Nick can remove is . There are two sets of choices with this result.
//        1 2 3 4 5
//        6 7 8 9
//        Output: 4 => 1 2 3 4 where sum 10 < maxSum
//        Remove  from  with a sum of .
//        Remove  from  and  from  with a sum of .
import java.util.*;

public class TwoStacks {

    public static int twoStacks(int maxSum, List<Integer> a, List<Integer> b) {
        // Write your code here
        return twoStacksHelper(maxSum, a, b, 0, 0) - 1;
    }
    private static int twoStacksHelper(int maxSum, List<Integer> a, List<Integer> b, int sum, int count){
        if( sum > maxSum){
            return count;
        }

        if(a.size() == 0 || b.size() == 0){
            return count;
        }

        int ans1 = twoStacksHelper(maxSum, a.subList(1, a.size()), b, sum + a.get(0), count +1);
        int ans2 = twoStacksHelper(maxSum, a, b.subList(1, b.size()), sum + b.get(0), count+1);
        return Math.max(ans1, ans2);

    }
}


