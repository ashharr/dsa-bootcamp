package queue;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    // DLL Class
    class Node{
        Node pre, next;
        int key, value;
        Node(int k, int v){
            this.key = k;
            this.value = v;
        }
    }

    Node head = new Node(0,0), tail = new Node(0,0);
    Map<Integer, Node> map = new HashMap<>();
    int capacity;
    public LRUCache(int _capacity) {
        // Declaring DLL and Hashmap

            // Declaring LRU Cache for first time (constructor)
                this.capacity = _capacity;
                head.next = tail;
                tail.pre = head;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            // removing and adding that node to the front because its used now
            remove(node);
            insert(node);
            return node.value;
        }
        else {
            return -1; // not found
        }
    }

    public void put(int key, int value) {
        // new key came remove old key
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        // check cache size
        if(map.size() == capacity){
            // removing Least Recently Used element i.e. oldest
            remove(tail.pre);
        }
        insert(new Node(key, value));
    }

    // removing the node passed using map reference
    private void remove( Node node){
        map.remove(node.key);
        // deleting both links of this node we want to remove
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    // inserting the node in the front because it's the latest used
    // by linking head to new node and node to head's next
    private void insert (Node node){
        map.put(node.key,node);
        Node headNext = head.next;
        head.next = node;
        node.pre = head;
        headNext.pre = node;
        node.next = headNext;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */