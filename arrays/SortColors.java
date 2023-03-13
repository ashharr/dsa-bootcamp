class SortColors {
    public void sortColors(int[] nums) {
        int low = 0, mid= 0, high = nums.length-1;
        while(mid <= high){
            if(nums[mid] == 0){
                swap(mid,low, nums);
                low++;
                mid++;
            }
            else if(nums[mid] == 1){
                mid++;
            }
            else{
                swap(high, mid, nums);
                high--;
            }
        }
    }
    public void swap( int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}