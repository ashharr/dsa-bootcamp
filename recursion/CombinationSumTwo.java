import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CombinationSumTwo {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        findCom(candidates, target, ans, ds, 0);
        return ans;
    }

    public static void findCom(int[] arr, int target, List<List<Integer>> ans, List<Integer> ds, int ind) {

        if (target == 0) {
            ans.add(new ArrayList<Integer>(ds));
            return;
        }
        for (int i = ind; i < arr.length; i++) {
            // including the arr[i] for first time only i > ind condition
            if (i > ind && arr[i] == arr[i - 1]) continue;
            // break if we find a number greater than we want
            if (target < arr[i]) {
                break;
            }
            ds.add(arr[i]);
            findCom(arr, target - arr[i], ans, ds, i + 1);
            ds.remove(ds.size() - 1);
        }
    }

    public static void main(String args[]) {
        int v[] = {10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> comb = combinationSum2(v, 8);
        System.out.println(comb.toString().replace(",", " "));
    }
}