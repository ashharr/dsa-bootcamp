package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        recurPermute(0, nums, ans);
        return ans;
    }
    private void recurPermute(int index, int[] nums, List<List<Integer>> ans){
        if(index >= nums.length){
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i < nums.length; i++) {
                temp.add(nums[i]);
            }
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i = index; i < nums.length; i++){
            swap(nums,index, i);
            recurPermute(index+1, nums, ans);
            swap(nums, index, i);
        }
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void main(String[] args) {
        int nums[] = {1,2,3};
        Permute sol = new Permute();
        List < List < Integer >> ls = sol.permute(nums);
        System.out.println("All Permutations are");
        for (int i = 0; i < ls.size(); i++) {
            for (int j = 0; j < ls.get(i).size(); j++) {
                System.out.print(ls.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
