import java.util.*;

class Queues {
    // Stack is a class
    // Queue is an interface
    // Tells us what to do; not how to do it...

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(3);
        queue.add(9);
        queue.add(14);
        queue.add(20);

        boolean x = queue.remove(10);
        System.out.println(queue.peek());
//        System.out.println(queue.remove());
        System.out.println(queue.peek());

        System.out.println(Arrays.toString(queue.toArray())+ x);

        // Deque
        // You can remove and insert from both sides

//        Deque<Integer> deque = new ArrayDeque<>();
//
//        // used in trees
//        // traversals left to right / right to left
//
//        deque.addFirst(10);
//        deque.addFirst(20);
//        deque.add(30);
//        deque.addLast(40);
//        System.out.println(deque.removeFirst());
//        System.out.println(Arrays.toString(deque.toArray()));

    }

}