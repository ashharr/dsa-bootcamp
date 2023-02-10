import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SubsetsTwo {
    static void printAns(List<List<Integer>> ans) {
        System.out.println("The unique subsets are ");
        System.out.println(ans.toString());
    }

    public static void findSubsets(int[] nums, int index, List<Integer> ds, List<List<Integer>> ansList) {
        ansList.add(new ArrayList<>(ds)); 
        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1])
                continue;
            ds.add(nums[i]);
            findSubsets(nums, i + 1, ds, ansList);
            ds.remove(ds.size() - 1);
        }
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ansList = new ArrayList<>();
        findSubsets(nums, 0, new ArrayList<>(), ansList);
        return ansList;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 2 };
        List<List<Integer>> ans = subsetsWithDup(nums);
        printAns(ans);
    }
}