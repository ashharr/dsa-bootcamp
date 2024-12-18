//88. Merge Sorted Array | Easy

//    You are given two integer arrays nums1 and nums2,
//    sorted in non-decreasing order, and two integers m and n,
//    representing the number of elements in nums1 and nums2
//    respectively.
//
//    Merge nums1 and nums2 into a single array sorted in non-decreasing order.
//
//    The final sorted array should not be returned by the function,
//    but instead be stored inside the array nums1. To accommodate
//    this, nums1 has a length of m + n, where the first m elements
//    denote the elements that should be merged, and the last n elements
//    are set to 0 and should be ignored. nums2 has a length of n.
//
//
//
//Example 1:
//
//Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//Output: [1,2,2,3,5,6]
//Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
//The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
//

package arrays.java;

import java.util.Arrays;

public class MergeTwoSortedArrays {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        // gap method O(NlogN)
        // gap method O(NlogN)
        if(n!=0){
            // appending nums2 to nums1
            for (int i = m, j =0; i < m+n && j < n; i++, j++) {
                nums1[i] = nums2[j];
            }
        }
        // upper limit gap = n // 2
        int gap = (m+n)/2 + (m+n)%2;

        while( gap >0 && n!=0) {
            System.out.println(gap);
            int p1=0,p2=gap;
            while(p2< nums1.length) {
                if(nums1[p1] > nums1[p2]) {
//                    swap(nums1[p1], nums1[p2]);
                    int temp =nums1[p1];
                    nums1[p1] = nums1[p2];
                    nums1[p2] = temp;
                }
                p1 +=1;
                p2 +=1;
            }
            if(gap == 1) gap = 0;
            gap = gap / 2 + gap % 2;
        }
        System.out.println(Arrays.toString(nums1));
    }
    public static void swap(int i, int j){
        int temp = i;
        i = j;
        j = temp;
    }

    public static void main(String[] args) {
        merge(new int[] {1,2,4,5,6,0}, 5, new int[] {3}, 1);

    }
}
