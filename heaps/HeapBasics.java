
// Time Complexity analysis | Space Complexity analysis
// Create Binary Heap - O(1) | O(n)
// Peek Heap - O(1) | O(1)
// Size of Heap - O(1) | O(1)
// Traversal of Heap - O(n) | O(1)
// Insert - O(logN) | O(logN)
// Extract node Binary Heap - O(logN) | O(logN)
// Delete Binary Heap - O(1) | O(1)


public class HeapBasics {
    int[] arr;
    int sizeOfTree;


    public HeapBasics(int size){
        // since we are skipping 0 index so size+1
        arr = new int[size+1];
        this.sizeOfTree = 0;
        System.out.println("Binary Heap has been created");
    }

    public boolean isEmpty(){
        return sizeOfTree == 0;
    }
    public Integer peek(){
        if(isEmpty()){
            System.out.println("Binary Heap is Empty");
            return null;
        }
        return arr[1];
    }
    public Integer sizeOfHeap(){
        return sizeOfTree;
    }

    public void levelOrderTraversal(){
        for (int i = 1; i <= sizeOfTree; i++) {
            System.out.print(arr[i] + " " );
        }
        System.out.println("\n");
    }

    // Heapify Insert
    public void heapifyBottomToTop(int index, String heapType){
        int parent = index/2;
        if(index <= 1){
            return;
        }
        if(heapType == "Min"){
            if(arr[index] < arr[parent]){
                int tmp = arr[index];
                arr[index] = arr[parent];
                arr[parent] = tmp;
            }
        } else if(heapType == "Max"){
            if(arr[index] > arr[parent]){
                int tmp = arr[index];
                arr[index] = arr[parent];
                arr[parent] = tmp;
            }
        }
        heapifyBottomToTop(parent,heapType);
    }

    // Heapify Extract
    public void heapifyTopToBottom(int index, String heapType){
        int left = index*2;
        int right = index*2 +1;
        int swapChild =0;
        if(sizeOfTree < left){
            return;
        }

        if(heapType == "Max"){
            // in case of only one child
            if(left == sizeOfTree){
                if(arr[index] < arr[left]){
                    int tmp = arr[left];
                    arr[left] = arr[index];
                    arr[index] = tmp;
                }
                return;
            } else {
                // pick greater child
                if(arr[left] > arr[right]){
                    swapChild = left;
                }
                else swapChild = right;
                if(arr[index] < arr[swapChild]){
                    int tmp = arr[index];
                    arr[index] = arr[swapChild];
                    arr[swapChild] = tmp;
                }
            }
        } else if(heapType == "Min"){
            if(left == sizeOfTree){
                if(arr[index] > arr[left]){
                    int tmp = arr[left];
                    arr[left] = arr[index];
                    arr[index] = tmp;
                }
                return;
            } else {
                // pick smaller child
                if(arr[left] < arr[right]){
                    swapChild = left;
                }
                else swapChild = right;
                if(arr[index] > arr[swapChild]){
                    int tmp = arr[index];
                    arr[index] = arr[swapChild];
                    arr[swapChild] = tmp;
                }
            }
        }
        heapifyTopToBottom(swapChild,heapType);
    }
    public int extractHeadOfHeap(String heapType){
        if(isEmpty()){
            return -1;
        }
        int extractedValue = arr[1];
        arr[1] = arr[sizeOfTree];
        sizeOfTree--;
        heapifyTopToBottom(1, heapType);
        return extractedValue;
    }

    public void insert(int value, String heapType){
        arr[sizeOfTree+1] =value;
        sizeOfTree++;
        heapifyBottomToTop(sizeOfTree,heapType);
        System.out.println("Inserted "+value+" successfully in "+heapType+"Heap");
    }
    public void deleteHeap(){
        arr=null;
        System.out.println("Binary Heap has been successfully deleted.");
    }
    public static void main(String[] args) {
        HeapBasics obj = new HeapBasics(5);
        String heapType = "Min";
        obj.insert(10, heapType);
        obj.insert(5, heapType);
        obj.insert(15, heapType);
        obj.insert(1, heapType );
        obj.peek();
        System.out.println("Size of heap = "+obj.sizeOfHeap());
        obj.levelOrderTraversal();
        System.out.println(obj.extractHeadOfHeap(heapType) +" removed");
        obj.levelOrderTraversal();

    }
}
