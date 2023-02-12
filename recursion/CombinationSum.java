import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    	Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        getResult(result, new ArrayList<Integer>(), candidates, target, 0);
        return result;
    }
    
    public static void getResult(List<List<Integer>> result, List<Integer> cur, int candidates[], int target, int start){
    	if(target > 0){
    		for(int i = start; i < candidates.length && target >= candidates[i]; i++){
    			cur.add(candidates[i]);
    			getResult(result, cur, candidates, target - candidates[i], i);
    			cur.remove(cur.size() - 1);
    		}//for
    	}//if
    	else if(target == 0 ){
    		result.add(new ArrayList<Integer>(cur));
    	}//else if
    }
    public static void main(String[] args) {
        int[] cc = new int[]{ 2,3,7};
        List<List<Integer>> result = combinationSum(cc, 7);
        System.out.println(result);
   
    }
}
