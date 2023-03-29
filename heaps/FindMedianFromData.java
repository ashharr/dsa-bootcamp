import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

//295. Find Median from Data Stream | Hard
//
//        The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value, and the median is the mean of the two middle values.
//        For example, for arr = [2,3,4], the median is 3.
//        For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
//        Implement the MedianFinder class:
//        MedianFinder() initializes the MedianFinder object.
//        void addNum(int num) adds the integer num from the data stream to the data structure.
//        double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
//
//        Example 1:
//
//        Input
//        ["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
//        [[], [1], [2], [], [3], []]
//        Output
//        [null, null, null, 1.5, null, 2.0]
class FindMedianFromData {

    // I. Brute Approach | ArrayList | O(NLogN)
//    ArrayList<Integer> arr;
//    public FindMedianFromData() {
//        arr = new ArrayList<Integer>();
//    }
//
//    public void addNum(int num) {
//        arr.add(num);
//    }
//
//    public double findMedian() {
//        if (arr.size() % 2 != 0)
//            return (double) arr.get(arr.size() / 2);
//
//        return (double)(arr.get((arr.size() - 1) / 2) + arr.get(arr.size() / 2)) / 2.0;
//    }
//


    // II. Optimal Approach | Priority Queue | O(1)

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    public FindMedianFromData() {
        maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        minHeap = new PriorityQueue<Integer>();
    }

    public void addNum(int num) {
        if(maxHeap.isEmpty() || maxHeap.peek() >= num){
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }

        // maxHeap will at most have minHeap.size + 1 number of elements
        if( maxHeap.size() > minHeap.size() + 1){
            minHeap.add(maxHeap.poll());
        } else if( minHeap.size() > maxHeap.size()){
            maxHeap.add(minHeap.poll());
        }

    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size())
            return (double) (minHeap.peek() + maxHeap.peek()) / 2.0;

        return (double)maxHeap.peek();
    }
}
