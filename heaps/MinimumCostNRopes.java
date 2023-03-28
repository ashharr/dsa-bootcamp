//Connect n ropes with minimum cost | Difficulty Level : Medium
//        Given are N ropes of different lengths, the task is to connect these ropes into one rope with minimum cost, such that the cost to connect two ropes is equal to the sum of their lengths.
//
//        Examples:
//        Input: arr[] = {4,3,2,6} , N = 4
//        Output: 29

import java.util.PriorityQueue;

public class MinimumCostNRopes {
    public static int minCost(int[] arr, int n){
        PriorityQueue<Integer> q = new PriorityQueue<>(n);
        for (int i = 0; i < n; i++) {
            q.add(arr[i]);
        }
        int cost = 0;
        while(q.size() > 1 ){
            int first = q.poll();
            int second = q.poll();
            cost += (first + second);
            q.add(first + second);
        }
        return cost;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int n = 3;
        System.out.println(minCost(arr, n));
    }
}
