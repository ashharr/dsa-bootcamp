import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestInArray {

    //Naive Solution is sorting and printing kth largest
    // Better solution is priority queue (heaps)
    // Optimal Solution is using QuickSelect Algorithm
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> largeK = new PriorityQueue<Integer>(k + 1);

        for(int el : nums) {
            largeK.add(el);
            System.out.println(Arrays.toString(largeK.toArray(

            )));
            if (largeK.size() > k) {
                largeK.poll();
                System.out.println("found "+Arrays.toString(largeK.toArray(

                )));
            }
        }
        if(!largeK.isEmpty()) return largeK.poll();
        return -1;
    }

    public static void main(String[] args) {
        int[] nums ={3,2,3,1,2,4,5,5,6};
        int k = 4;
        System.out.println(
                findKthLargest(nums,k)
        );
    }

    static int partition(int[] arr, int l, int r) {

        int f = arr[r] ;
        int i = l;

        for (int j = l; j <= r - 1; j++) {
            if (arr[j] <= f) {
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++;
            }
        }
        int temp=arr[i];
        arr[i]=arr[r];
        arr[r]=temp;
        return i;
    }

    static int kth_Smallest_Element(int[] arr,int l,int r, int k) {
        if (k <= r - l + 1 && k > 0) {

            int ind = partition(arr, l, r);


            if (ind - l == k - 1) {
                return arr[ind];
            }
            if (ind - l > k - 1) {
                return kth_Smallest_Element(arr, l, ind - 1, k);
            }


            return kth_Smallest_Element(arr, ind + 1, r, k - ind + l - 1);
        }
        return Integer.MAX_VALUE;
    }

    public int findKthLargest2(int[] nums, int k){
        return kth_Smallest_Element(nums, 0,nums.length-1,nums.length-k+1);
    }
}
