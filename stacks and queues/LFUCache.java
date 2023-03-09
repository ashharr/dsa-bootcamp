import java.util.HashMap;
import java.util.Map;

class LFUCache {
    final int capacity;
    int curSize;
    int minFrequency;
    Map<Integer, DLLNode> cache;
    Map<Integer, DoublyLinkedList> freqMap;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFrequency = 0;
        this.curSize = 0;

        this.cache = new HashMap<>();
        this.freqMap = new HashMap<>();
    }

    public int get(int key) {
        DLLNode curNode = cache.get(key);
        if(curNode == null){
            return -1;
        }
        updateNode(curNode);
        return curNode.value;
    }
    public void updateNode(DLLNode curNode){
        int curFreq = curNode.frequency;
        DoublyLinkedList curList = freqMap.get(curFreq);
        curList.removeNode(curNode);

        // if the current list has the last node which is being removed we will also update
        // minFrequency to keep it updated to the latest list which has nodes.
        if(curList.listSize == 0 && curFreq == minFrequency){
            minFrequency++;
        }
        curNode.frequency++;
        DoublyLinkedList newList = freqMap.getOrDefault(curNode.frequency, new DoublyLinkedList());
        newList.addNode(curNode);
        freqMap.put(curNode.frequency, newList);
    }
    public void put(int key, int value) {
        if(capacity == 0){
            return;
        }
        if(cache.containsKey(key)){
            DLLNode curNode = cache.get(key);
            curNode.value = value;
            updateNode(curNode);
        }
        else {
            curSize++;
            if(curSize > capacity){
                // min freq list
                DoublyLinkedList minFreqList = freqMap.get(minFrequency);
                cache.remove(minFreqList.tail.prev.key);
                minFreqList.removeNode(minFreqList.tail.prev);
                curSize--;
            }
            // reset minimum frequency to 1 because of adding new node;
            minFrequency = 1;
            DLLNode newNode = new DLLNode(key,value);

            // get the list with freq 1 and add node to list and add cache;
            DoublyLinkedList curList = freqMap.getOrDefault(1, new DoublyLinkedList());
            curList.addNode(newNode);
            freqMap.put(1, curList);
            cache.put(key, newNode);

        }
    }
    // Defining DLL Node and DLL list

    class DLLNode {
        int key;
        int value;
        int frequency;
        DLLNode prev;
        DLLNode next;
        public DLLNode(int key, int value){
            this.key = key;
            this.value = value;
            this.frequency = 1;

        }
    }
    class DoublyLinkedList {
        int listSize;
        DLLNode head;
        DLLNode tail;
        public DoublyLinkedList(){
            this.listSize = 0;
            this.head = new DLLNode(0,0);
            this.tail = new DLLNode(0,0);
            head.next = tail;
            tail.prev = head;
        }

        public void addNode(DLLNode node){
            DLLNode headNext = head.next;
            node.next = head.next;
            node.prev = head;
            head.next = node;
            headNext.prev = node;
            listSize++;
        }

        public void removeNode(DLLNode node){
            DLLNode prevNode = node.prev;
            DLLNode nextNode = node.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            listSize--;
        }
    }

}



/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */