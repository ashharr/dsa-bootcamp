// Implementing our own Stack
public class CustomStack {
    protected int[] data;

    // imagine this is an array with defined size
    private static final int DEFAULT_SIZE = 10;
    int top = -1;


    public CustomStack(){
        this(DEFAULT_SIZE);
    }
    public CustomStack(int size){
        this.data = new int[size];
    }

    public boolean push(int item){
        if(isFull()){
            System.out.println("Stack Overflow !");
            return false;
        }

        top++;
        data[top] = item;
        return true;
    }

    public int pop() throws StackException{
        if(isEmpty()){
            throw new StackException("Stack Empty !");
        }
        return data[top--];

    }
    public int peek() throws StackException{
        if(isEmpty()){
            throw new StackException("Stack Empty !");
        }
        return data[top];
    }
    public boolean isFull(){
        return data.length - 1 == top;
    }

    public boolean isEmpty(){
        return top == -1;
    }

}
