import java.util.Stack;

class QueueUsingStacks {
    private Stack<Integer> first;
    private Stack<Integer> second;
    int x;

    public QueueUsingStacks() {
        first = new Stack<>();
        second = new Stack<>();
        x = 0;
    }

    public void push(int x) {
        first.push(x);
    }

    public int pop() {
        if( !first.isEmpty())
            while(!first.isEmpty()){
                second.push(first.pop());
            }
        if( !second.isEmpty()){
            x =  second.pop();
        }
        while(!second.isEmpty()){
            first.push(second.pop());
        }
        return x;
    }

    public int peek() {
        if(!first.isEmpty())
            while(!first.isEmpty()){
                second.push(first.pop());
            }
        if(!second.isEmpty()){
            x =  second.peek();
        }
        while(!second.isEmpty()){
            first.push(second.pop());
        }
        return x;
    }

    public boolean empty() {
        return first.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */