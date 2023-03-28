import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class TopKFrequent {
    public static int[]  topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();

        for (int i:
             nums) {
            map.put(i, map.getOrDefault(i,0)+ 1);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));

        for(int key : map.keySet()){ maxHeap.add(key); }

        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            ans[i] = maxHeap.poll();
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3};
        System.out.println(Arrays.toString(topKFrequent(arr, 2)));
    }
}