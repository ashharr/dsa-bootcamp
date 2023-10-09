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
