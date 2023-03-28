// 378. Kth Smallest Element in a Sorted Matrix | Medium
//
//        Given an n x n matrix where each of the rows and columns is sorted in ascending order, return the kth smallest element in the matrix.
//        Note that it is the kth the smallest element in the sorted order, not the kth distinct element.
//        You must find a solution with a memory complexity better than O(n2).
//
//        Example 1:
//
//        Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
//        Output: 13

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestInSortedMatrix {
    // Brute Approach || O(N Log N)  where n*n == N
    //  Add to 1d array and sort and return kth smallest

    // Better Approach || Priority Queue | O(N * log(K))
    public static int kthSmallest(int[][] matrix, int k) {

        PriorityQueue<Integer> maxHeap =new PriorityQueue<>(Collections.reverseOrder());
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(maxHeap.size() < k){
                    maxHeap.add(matrix[i][j]);
                } else {
                    // if incoming element is smaller than peek of heap
                    if( matrix[i][j] < maxHeap.peek()){
                        maxHeap.poll();
                        maxHeap.add(matrix[i][j]);
                    }
                }
            }
        }
        return maxHeap.peek();
    }
    // Optimal Approach would be binary search approach
    // slightly better than PQ approach
    public static void main(String[] args) {
        int[][] matrix = {{1,5,9},{10,11,13},{12,13,15}};
        System.out.println(kthSmallest(matrix, 8));
    }

}
