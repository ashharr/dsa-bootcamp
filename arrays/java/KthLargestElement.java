package arrays.java;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElement {
    
    // using streams
    public static int kthSmallestStream(int[] arr, int N, int K) {
        return Arrays.stream(arr).boxed().sorted().skip(K-1).findFirst().get();
    }

    //using sorting
    public static int kthSmallestSorting(int[] arr, int N, int K) {
       Arrays.sort(arr);
       for (int i = 0; i < K; i++) {
        if(i == (K-1)) return arr[i];
       }
       return 0;
    }

    //using min heap
    public static int kthSmallestMinHeap(int[] arr, int N, int K) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            q.offer(arr[i]);
        }

        if(q.size()> K){
            q.poll();
        }

        return q.peek();
     }


    public static void main(String[] args) {
        int[] nums = {55, 44, 33, 88, 22};
        System.out.println(kthSmallestStream(nums, nums.length, 2)); 
        System.out.println(kthSmallestSorting(nums, nums.length, 2)); 
        System.out.println(kthSmallestMinHeap(nums, nums.length, 2)); 
    
    }
}
